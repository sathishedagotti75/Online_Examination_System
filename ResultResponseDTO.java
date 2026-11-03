package com.sathish.demo.dto;
public record ResultResponseDTO(Integer resultId,Integer studentId,String studentName,Integer examId,String examName,
 Integer totalMarks,Integer obtainedMarks,Double percentage,String resultStatus,Integer rank) {}
