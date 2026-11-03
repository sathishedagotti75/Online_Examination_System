package com.sathish.demo.mapper;
import com.sathish.demo.entity.Student;import com.sathish.demo.dto.StudentResponseDTO;
import org.springframework.stereotype.Component;
@Component public class StudentMapper { public StudentResponseDTO toDto(Student s){return new StudentResponseDTO(s.getStudentId(),s.getName(),s.getEmail(),s.getDepartment(),s.getPhone());} }
