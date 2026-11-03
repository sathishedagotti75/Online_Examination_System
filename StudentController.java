package com.sathish.demo.controller;
import com.sathish.demo.dto.*;import com.sathish.demo.service.StudentService;import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/students")
public class StudentController {
 private final StudentService service;public StudentController(StudentService s){service=s;}
 @PostMapping("/register") @ResponseStatus(HttpStatus.CREATED) public StudentResponseDTO register(@Valid @RequestBody StudentRequestDTO d){return service.register(d);}
 @GetMapping public List<StudentResponseDTO> all(){return service.all();}
 @GetMapping("/{id}") public StudentResponseDTO get(@PathVariable Integer id){return service.get(id);}
 @PutMapping("/{id}") public StudentResponseDTO update(@PathVariable Integer id,@Valid @RequestBody StudentRequestDTO d){return service.update(id,d);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Integer id){service.delete(id);}
}
