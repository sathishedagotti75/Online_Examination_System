package com.sathish.demo.dto;
import jakarta.validation.constraints.*;
public record AuthRequestDTO(@Email @NotBlank String email,@NotBlank String password) {}
