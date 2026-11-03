package com.sathish.demo.mapper;
import com.sathish.demo.entity.*;import com.sathish.demo.dto.ResultResponseDTO;
import org.springframework.stereotype.Component;
@Component public class ResultMapper { public ResultResponseDTO toDto(Result r){ExamAttempt a=r.getAttempt();return new ResultResponseDTO(r.getResultId(),a.getStudent().getStudentId(),a.getStudent().getName(),a.getExam().getExamId(),a.getExam().getExamName(),r.getTotalMarks(),r.getObtainedMarks(),r.getPercentage(),r.getResultStatus(),r.getRank());} }
