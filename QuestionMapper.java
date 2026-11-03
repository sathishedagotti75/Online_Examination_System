package com.sathish.demo.mapper;
import com.sathish.demo.entity.Question;import com.sathish.demo.dto.QuestionRequestDTO;
import org.springframework.stereotype.Component;
@Component public class QuestionMapper { public Question toEntity(QuestionRequestDTO d){Question q=new Question();q.setQuestionText(d.questionText());q.setMarks(d.marks());q.setNegativeMarks(d.negativeMarks()==null?0:d.negativeMarks());q.setQuestionType(d.questionType());return q;} }
