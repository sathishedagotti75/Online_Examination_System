package com.sathish.demo.controller;
import com.sathish.demo.dto.*;import com.sathish.demo.security.JwtService;import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;import org.springframework.security.authentication.*;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/auth")
public class CreateAuthController {
 private final AuthenticationManager manager;private final JwtService jwt;
 public CreateAuthController(AuthenticationManager m,JwtService j){manager=m;jwt=j;}
 @PostMapping("/login") public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO d){
  manager.authenticate(new UsernamePasswordAuthenticationToken(d.email(),d.password()));
  return ResponseEntity.ok(new AuthResponseDTO(jwt.generateToken(d.email()),"Bearer"));
 }
}
