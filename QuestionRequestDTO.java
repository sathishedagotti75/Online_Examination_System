package com.sathish.demo.dto;
import jakarta.validation.constraints.*; import java.util.List;
public record QuestionRequestDTO(@NotBlank String questionText,@NotNull @Min(1) Integer marks,
 Integer negativeMarks,String questionType,@NotEmpty List<@NotBlank String> options,
 @NotNull @Min(0) Integer correctOptionIndex) {}
