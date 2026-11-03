package com.sathish.demo.dto;
import jakarta.validation.constraints.NotNull;
public record AnswerRequestDTO(@NotNull Integer questionId,@NotNull Integer selectedOptionId) {}
