package com.sathish.demo.controller;
import com.sathish.demo.dto.ResultResponseDTO;import com.sathish.demo.service.ResultService;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/results") public class ResultController {
 private final ResultService service;public ResultController(ResultService s){service=s;}
 @GetMapping("/{attemptId}") public ResultResponseDTO byAttempt(@PathVariable Integer attemptId){return service.byAttempt(attemptId);}
 @GetMapping public List<ResultResponseDTO> all(){return service.all();}
 @GetMapping("/rankings") public List<ResultResponseDTO> rankings(){return service.all();}
}
