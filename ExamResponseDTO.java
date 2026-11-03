package com.sathish.demo.dto;
import java.time.LocalDateTime;
public record ExamResponseDTO(Integer examId,String examName,String description,Integer duration,Integer totalMarks,
 Integer passingMarks,LocalDateTime startTime,LocalDateTime endTime,String status) {}
