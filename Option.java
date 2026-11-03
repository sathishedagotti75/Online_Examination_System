package com.sathish.demo.entity;
import jakarta.persistence.*;
@Entity @Table(name="question_options")
public class Option {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer optionId;
 @Column(nullable=false) private String optionText; private boolean correct;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="question_id",nullable=false) private Question question;
 public Integer getOptionId(){return optionId;} public void setOptionId(Integer v){optionId=v;}
 public String getOptionText(){return optionText;} public void setOptionText(String v){optionText=v;}
 public boolean isCorrect(){return correct;} public void setCorrect(boolean v){correct=v;}
 public Question getQuestion(){return question;} public void setQuestion(Question v){question=v;}
}
