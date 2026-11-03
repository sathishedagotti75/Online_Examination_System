package com.sathish.demo.service;
import com.sathish.demo.dto.AnswerRequestDTO;import com.sathish.demo.entity.*;import com.sathish.demo.exception.*;import com.sathish.demo.repository.*;
import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import java.time.LocalDateTime;import java.util.*;
@Service public class ExamAttemptService {
 private final ExamAttemptRepository attempts;private final StudentRepository students;private final ExamRepository exams;private final QuestionRepository questions;private final OptionRepository options;private final AnswerRepository answers;private final ResultService resultService;
 public ExamAttemptService(ExamAttemptRepository a,StudentRepository s,ExamRepository e,QuestionRepository q,OptionRepository o,AnswerRepository an,ResultService r){attempts=a;students=s;exams=e;questions=q;options=o;answers=an;resultService=r;}
 public ExamAttempt start(Integer studentId,Integer examId){Student s=students.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student not found"));Exam e=exams.findById(examId).orElseThrow(()->new ResourceNotFoundException("Exam not found"));
  if(attempts.existsByStudentAndExam(s,e))throw new IllegalArgumentException("Student has already attempted this exam");
  LocalDateTime now=LocalDateTime.now();if(e.getStartTime()!=null&&now.isBefore(e.getStartTime()))throw new ExamExpiredException("Exam has not started");if(e.getEndTime()!=null&&now.isAfter(e.getEndTime()))throw new ExamExpiredException("Exam has ended");
  ExamAttempt a=new ExamAttempt();a.setStudent(s);a.setExam(e);a.setStartTime(now);a.setStatus("IN_PROGRESS");return attempts.save(a);
 }
 @Transactional public Object submit(Integer attemptId,List<AnswerRequestDTO> submitted){ExamAttempt a=attempts.findById(attemptId).orElseThrow(()->new ResourceNotFoundException("Attempt not found"));
  if(!"IN_PROGRESS".equals(a.getStatus()))throw new ExamAlreadySubmittedException("Attempt is not in progress");
  for(AnswerRequestDTO d:submitted){Question q=questions.findById(d.questionId()).orElseThrow(()->new ResourceNotFoundException("Question not found"));
   if(!q.getExam().getExamId().equals(a.getExam().getExamId()))throw new IllegalArgumentException("Question does not belong to this exam");
   Option op=options.findById(d.selectedOptionId()).orElseThrow(()->new ResourceNotFoundException("Option not found"));
   if(!op.getQuestion().getQuestionId().equals(q.getQuestionId()))throw new IllegalArgumentException("Option does not belong to question");
   Answer ans=new Answer();ans.setAttempt(a);ans.setQuestion(q);ans.setSelectedOption(op);ans.setCorrect(op.isCorrect());ans.setAwardedMarks(op.isCorrect()?q.getMarks():-q.getNegativeMarks());answers.save(ans);
  }
  a.setStatus("SUBMITTED");a.setEndTime(LocalDateTime.now());attempts.save(a);return resultService.calculate(attemptId);
 }
 public List<ExamAttempt> all(){return attempts.findAll();}
 public ExamAttempt get(Integer id){return attempts.findById(id).orElseThrow(()->new ResourceNotFoundException("Attempt not found"));}
}
