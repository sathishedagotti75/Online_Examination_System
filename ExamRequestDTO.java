package com.sathish.demo.dto;
import jakarta.validation.constraints.*; import java.time.LocalDateTime;
public record ExamRequestDTO(@NotBlank String examName,String description,@NotNull @Min(1) Integer duration,
 @NotNull @Min(1) Integer totalMarks,@NotNull @Min(1) Integer passingMarks,
 LocalDateTime startTime,LocalDateTime endTime) {}
