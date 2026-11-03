package com.sathish.demo.entity;
import jakarta.persistence.*;
@Entity @Table(name="answers")
public class Answer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer answerId;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="attempt_id",nullable=false) private ExamAttempt attempt;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="question_id",nullable=false) private Question question;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="selected_option_id") private Option selectedOption;
 private boolean correct; private Integer awardedMarks;
 public Integer getAnswerId(){return answerId;} public void setAnswerId(Integer v){answerId=v;}
 public ExamAttempt getAttempt(){return attempt;} public void setAttempt(ExamAttempt v){attempt=v;}
 public Question getQuestion(){return question;} public void setQuestion(Question v){question=v;}
 public Option getSelectedOption(){return selectedOption;} public void setSelectedOption(Option v){selectedOption=v;}
 public boolean isCorrect(){return correct;} public void setCorrect(boolean v){correct=v;}
 public Integer getAwardedMarks(){return awardedMarks;} public void setAwardedMarks(Integer v){awardedMarks=v;}
}
