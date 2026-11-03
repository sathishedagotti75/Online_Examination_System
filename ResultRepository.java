package com.sathish.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.*; import com.sathish.demo.entity.*;
import com.sathish.demo.entity.Result;
public interface ResultRepository extends JpaRepository<Result, Integer> {
 Optional<Result> findByAttempt(ExamAttempt attempt); List<Result> findAllByOrderByObtainedMarksDesc();
}
