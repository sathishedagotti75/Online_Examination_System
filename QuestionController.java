package com.sathish.demo.controller;
import com.sathish.demo.dto.QuestionRequestDTO;import com.sathish.demo.entity.Question;import com.sathish.demo.service.QuestionService;import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/questions") public class QuestionController {
 private final QuestionService service;public QuestionController(QuestionService s){service=s;}
 @PostMapping("/exam/{examId}") @ResponseStatus(HttpStatus.CREATED) public Question add(@PathVariable Integer examId,@Valid @RequestBody QuestionRequestDTO d){return service.add(examId,d);}
 @GetMapping("/exam/{examId}") public List<Question> byExam(@PathVariable Integer examId){return service.byExam(examId);}
}
