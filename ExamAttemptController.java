package com.sathish.demo.controller;
import com.sathish.demo.dto.AnswerRequestDTO;import com.sathish.demo.entity.ExamAttempt;import com.sathish.demo.service.ExamAttemptService;import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/attempts") public class ExamAttemptController {
 private final ExamAttemptService service;public ExamAttemptController(ExamAttemptService s){service=s;}
 @PostMapping("/start") public ExamAttempt start(@RequestParam Integer studentId,@RequestParam Integer examId){return service.start(studentId,examId);}
 @PostMapping("/{attemptId}/submit") public Object submit(@PathVariable Integer attemptId,@Valid @RequestBody List<AnswerRequestDTO> answers){return service.submit(attemptId,answers);}
 @GetMapping public List<ExamAttempt> all(){return service.all();}
 @GetMapping("/{id}") public ExamAttempt get(@PathVariable Integer id){return service.get(id);}
}
