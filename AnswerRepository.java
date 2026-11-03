package com.sathish.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.*; import com.sathish.demo.entity.*;
import com.sathish.demo.entity.Answer;
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
 List<Answer> findByAttempt(ExamAttempt attempt);
}
