package com.sathish.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.*; import com.sathish.demo.entity.*;
import com.sathish.demo.entity.ExamAttempt;
public interface ExamAttemptRepository extends JpaRepository<ExamAttempt, Integer> {
 boolean existsByStudentAndExam(Student student, Exam exam); List<ExamAttempt> findByStudent(Student student);
}
