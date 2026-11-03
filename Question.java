package com.sathish.demo.entity;
import jakarta.persistence.*;
@Entity @Table(name="questions")
public class Question {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer questionId;
 @Column(nullable=false,length=2000) private String questionText;
 private Integer marks=1; private Integer negativeMarks=0; private String questionType="MCQ";
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="exam_id",nullable=false) private Exam exam;
 public Integer getQuestionId(){return questionId;} public void setQuestionId(Integer v){questionId=v;}
 public String getQuestionText(){return questionText;} public void setQuestionText(String v){questionText=v;}
 public Integer getMarks(){return marks;} public void setMarks(Integer v){marks=v;}
 public Integer getNegativeMarks(){return negativeMarks;} public void setNegativeMarks(Integer v){negativeMarks=v;}
 public String getQuestionType(){return questionType;} public void setQuestionType(String v){questionType=v;}
 public Exam getExam(){return exam;} public void setExam(Exam v){exam=v;}
}
