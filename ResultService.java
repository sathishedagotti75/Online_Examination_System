package com.sathish.demo.service;
import com.sathish.demo.dto.ResultResponseDTO;import com.sathish.demo.entity.*;import com.sathish.demo.exception.ResourceNotFoundException;import com.sathish.demo.repository.*;
import org.springframework.stereotype.Service;import java.util.*;
@Service public class ResultService {
 private final ResultRepository results;private final AnswerRepository answers;private final ExamAttemptRepository attempts;
 public ResultService(ResultRepository r,AnswerRepository a,ExamAttemptRepository t){results=r;answers=a;attempts=t;}
 public ResultResponseDTO calculate(Integer attemptId){ExamAttempt at=attempts.findById(attemptId).orElseThrow(()->new ResourceNotFoundException("Attempt not found"));
  if(results.findByAttempt(at).isPresent())throw new IllegalArgumentException("Result already calculated");
  int score=answers.findByAttempt(at).stream().mapToInt(a->a.getAwardedMarks()==null?0:a.getAwardedMarks()).sum();
  Result r=new Result();r.setAttempt(at);r.setTotalMarks(at.getExam().getTotalMarks());r.setObtainedMarks(score);
  r.setPercentage(r.getTotalMarks()==0?0.0:score*100.0/r.getTotalMarks());r.setResultStatus(score>=at.getExam().getPassingMarks()?"PASS":"FAIL");
  return dto(results.save(r));
 }
 public ResultResponseDTO byAttempt(Integer id){ExamAttempt at=attempts.findById(id).orElseThrow(()->new ResourceNotFoundException("Attempt not found"));return dto(results.findByAttempt(at).orElseThrow(()->new ResourceNotFoundException("Result not found")));}
 public List<ResultResponseDTO> all(){return results.findAllByOrderByObtainedMarksDesc().stream().map(this::dto).toList();}
 private ResultResponseDTO dto(Result r){ExamAttempt a=r.getAttempt();return new ResultResponseDTO(r.getResultId(),a.getStudent().getStudentId(),a.getStudent().getName(),a.getExam().getExamId(),a.getExam().getExamName(),r.getTotalMarks(),r.getObtainedMarks(),r.getPercentage(),r.getResultStatus(),r.getRank());}
}
