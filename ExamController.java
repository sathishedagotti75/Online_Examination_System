package com.sathish.demo.controller;
import com.sathish.demo.dto.*;import com.sathish.demo.service.ExamService;import jakarta.validation.Valid;import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/exams") public class ExamController {
 private final ExamService service;public ExamController(ExamService s){service=s;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public ExamResponseDTO create(@Valid @RequestBody ExamRequestDTO d){return service.create(d);}
 @GetMapping public List<ExamResponseDTO> all(){return service.all();}
 @GetMapping("/{id}") public ExamResponseDTO get(@PathVariable Integer id){return service.get(id);}
 @PutMapping("/{id}") public ExamResponseDTO update(@PathVariable Integer id,@Valid @RequestBody ExamRequestDTO d){return service.update(id,d);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Integer id){service.delete(id);}
}
