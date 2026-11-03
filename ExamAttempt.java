package com.sathish.demo.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="exam_attempts")
public class ExamAttempt {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer attemptId;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="student_id",nullable=false) private Student student;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="exam_id",nullable=false) private Exam exam;
 private LocalDateTime startTime; private LocalDateTime endTime; private String status="IN_PROGRESS";
 public Integer getAttemptId(){return attemptId;} public void setAttemptId(Integer v){attemptId=v;}
 public Student getStudent(){return student;} public void setStudent(Student v){student=v;}
 public Exam getExam(){return exam;} public void setExam(Exam v){exam=v;}
 public LocalDateTime getStartTime(){return startTime;} public void setStartTime(LocalDateTime v){startTime=v;}
 public LocalDateTime getEndTime(){return endTime;} public void setEndTime(LocalDateTime v){endTime=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
