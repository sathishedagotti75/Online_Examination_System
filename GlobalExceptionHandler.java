package com.sathish.demo.exception;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException; import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class) public ResponseEntity<Map<String,String>> notFound(RuntimeException e){return response(HttpStatus.NOT_FOUND,e.getMessage());}
 @ExceptionHandler(DuplicateStudentException.class) public ResponseEntity<Map<String,String>> duplicate(RuntimeException e){return response(HttpStatus.CONFLICT,e.getMessage());}
 @ExceptionHandler({ExamAlreadySubmittedException.class,ExamExpiredException.class,IllegalArgumentException.class}) public ResponseEntity<Map<String,String>> bad(RuntimeException e){return response(HttpStatus.BAD_REQUEST,e.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,String>> validation(MethodArgumentNotValidException e){
  Map<String,String> m=new LinkedHashMap<>(); for(FieldError f:e.getBindingResult().getFieldErrors())m.put(f.getField(),f.getDefaultMessage()); return ResponseEntity.badRequest().body(m);
 }
 private ResponseEntity<Map<String,String>> response(HttpStatus s,String msg){return ResponseEntity.status(s).body(Map.of("error",msg));}
}
