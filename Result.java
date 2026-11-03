package com.sathish.demo.entity;
import jakarta.persistence.*;
@Entity @Table(name="results")
public class Result {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer resultId;
 @OneToOne(fetch=FetchType.EAGER) @JoinColumn(name="attempt_id",nullable=false,unique=true) private ExamAttempt attempt;
 private Integer totalMarks; private Integer obtainedMarks; private Double percentage; private String resultStatus; private Integer rank;
 public Integer getResultId(){return resultId;} public void setResultId(Integer v){resultId=v;}
 public ExamAttempt getAttempt(){return attempt;} public void setAttempt(ExamAttempt v){attempt=v;}
 public Integer getTotalMarks(){return totalMarks;} public void setTotalMarks(Integer v){totalMarks=v;}
 public Integer getObtainedMarks(){return obtainedMarks;} public void setObtainedMarks(Integer v){obtainedMarks=v;}
 public Double getPercentage(){return percentage;} public void setPercentage(Double v){percentage=v;}
 public String getResultStatus(){return resultStatus;} public void setResultStatus(String v){resultStatus=v;}
 public Integer getRank(){return rank;} public void setRank(Integer v){rank=v;}
}
