package com.sathish.demo.scheduler;
import com.sathish.demo.entity.Exam;import com.sathish.demo.repository.ExamRepository;
import org.springframework.scheduling.annotation.Scheduled;import org.springframework.stereotype.Component;import java.time.LocalDateTime;
@Component public class ExamScheduler {
 private final ExamRepository repo;public ExamScheduler(ExamRepository r){repo=r;}
 @Scheduled(fixedRate=60000) public void updateExamStatuses(){LocalDateTime now=LocalDateTime.now();for(Exam e:repo.findAll()){
  if(e.getEndTime()!=null&&now.isAfter(e.getEndTime()))e.setStatus("COMPLETED");
  else if(e.getStartTime()!=null&&e.getEndTime()!=null&&!now.isBefore(e.getStartTime()))e.setStatus("ONGOING");
  repo.save(e);
 }}
}
