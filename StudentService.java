package com.sathish.demo.service;
import com.sathish.demo.dto.*; import com.sathish.demo.entity.Student; import com.sathish.demo.exception.*;
import com.sathish.demo.repository.StudentRepository; import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service; import java.util.*;
@Service
public class StudentService {
 private final StudentRepository repo; private final PasswordEncoder encoder;
 public StudentService(StudentRepository r,PasswordEncoder e){repo=r;encoder=e;}
 public StudentResponseDTO register(StudentRequestDTO d){
  if(repo.existsByEmail(d.getEmail()))throw new DuplicateStudentException("Email already registered");
  Student s=new Student();s.setName(d.getName());s.setEmail(d.getEmail());s.setPassword(encoder.encode(d.getPassword()));s.setDepartment(d.getDepartment());s.setPhone(d.getPhone());s.setRole("STUDENT");
  return dto(repo.save(s));
 }
 public List<StudentResponseDTO> all(){return repo.findAll().stream().map(this::dto).toList();}
 public StudentResponseDTO get(Integer id){return dto(repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found: "+id)));}
 public StudentResponseDTO update(Integer id,StudentRequestDTO d){Student s=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found: "+id));s.setName(d.getName());s.setDepartment(d.getDepartment());s.setPhone(d.getPhone());if(d.getPassword()!=null&&!d.getPassword().isBlank())s.setPassword(encoder.encode(d.getPassword()));return dto(repo.save(s));}
 public void delete(Integer id){if(!repo.existsById(id))throw new ResourceNotFoundException("Student not found: "+id);repo.deleteById(id);}
 private StudentResponseDTO dto(Student s){return new StudentResponseDTO(s.getStudentId(),s.getName(),s.getEmail(),s.getDepartment(),s.getPhone());}
}
