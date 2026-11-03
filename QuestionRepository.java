package com.sathish.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.*; import com.sathish.demo.entity.*;
import com.sathish.demo.entity.Question;
public interface QuestionRepository extends JpaRepository<Question, Integer> {
 List<Question> findByExam(Exam exam);
}
