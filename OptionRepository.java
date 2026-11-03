package com.sathish.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.*; import com.sathish.demo.entity.*;
import com.sathish.demo.entity.Option;
public interface OptionRepository extends JpaRepository<Option, Integer> {
 List<Option> findByQuestion(Question question);
}
