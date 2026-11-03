package com.sathish.demo.service;
import com.sathish.demo.dto.QuestionRequestDTO;import com.sathish.demo.entity.*;import com.sathish.demo.exception.ResourceNotFoundException;
import com.sathish.demo.repository.*;import org.springframework.stereotype.Service;import java.util.*;
@Service public class QuestionService {
 private final QuestionRepository questions;private final ExamRepository exams;private final OptionRepository options;
 public QuestionService(QuestionRepository q,ExamRepository e,OptionRepository o){questions=q;exams=e;options=o;}
 public Question add(Integer examId,QuestionRequestDTO d){Exam exam=exams.findById(examId).orElseThrow(()->new ResourceNotFoundException("Exam not found"));
  if(d.correctOptionIndex()>=d.options().size())throw new IllegalArgumentException("Correct option index is outside options list");
  Question q=new Question();q.setExam(exam);q.setQuestionText(d.questionText());q.setMarks(d.marks());q.setNegativeMarks(d.negativeMarks()==null?0:d.negativeMarks());q.setQuestionType(d.questionType());
  q=questions.save(q);for(int i=0;i<d.options().size();i++){Option op=new Option();op.setQuestion(q);op.setOptionText(d.options().get(i));op.setCorrect(i==d.correctOptionIndex());options.save(op);}return q;
 }
 public List<Question> byExam(Integer id){Exam e=exams.findById(id).orElseThrow(()->new ResourceNotFoundException("Exam not found"));return questions.findByExam(e);}
}
