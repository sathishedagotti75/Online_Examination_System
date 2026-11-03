package com.sathish.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
import com.sathish.demo.entity.Exam;
public interface ExamRepository extends JpaRepository<Exam, Integer> {

}
