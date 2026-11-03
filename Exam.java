package com.sathish.demo.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="exams")
public class Exam {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer examId;
 @Column(nullable=false) private String examName; private String description;
 private Integer duration; private Integer totalMarks; private Integer passingMarks;
 private LocalDateTime startTime; private LocalDateTime endTime;
 private String status="UPCOMING";
 public Integer getExamId(){return examId;} public void setExamId(Integer v){examId=v;}
 public String getExamName(){return examName;} public void setExamName(String v){examName=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public Integer getDuration(){return duration;} public void setDuration(Integer v){duration=v;}
 public Integer getTotalMarks(){return totalMarks;} public void setTotalMarks(Integer v){totalMarks=v;}
 public Integer getPassingMarks(){return passingMarks;} public void setPassingMarks(Integer v){passingMarks=v;}
 public LocalDateTime getStartTime(){return startTime;} public void setStartTime(LocalDateTime v){startTime=v;}
 public LocalDateTime getEndTime(){return endTime;} public void setEndTime(LocalDateTime v){endTime=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
