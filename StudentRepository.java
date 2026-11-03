package com.sathish.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
import com.sathish.demo.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer> {
 Optional<Student> findByEmail(String email); boolean existsByEmail(String email);
}
