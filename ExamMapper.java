package com.sathish.demo.mapper;
import com.sathish.demo.entity.Exam;import com.sathish.demo.dto.ExamResponseDTO;
import org.springframework.stereotype.Component;
@Component public class ExamMapper { public ExamResponseDTO toDto(Exam e){return new ExamResponseDTO(e.getExamId(),e.getExamName(),e.getDescription(),e.getDuration(),e.getTotalMarks(),e.getPassingMarks(),e.getStartTime(),e.getEndTime(),e.getStatus());} }
