package com.sathish.demo.service;
import com.sathish.demo.dto.*;import com.sathish.demo.entity.Exam;import com.sathish.demo.exception.ResourceNotFoundException;import com.sathish.demo.repository.ExamRepository;
import org.springframework.stereotype.Service;import java.util.*;
@Service public class ExamService {
 private final ExamRepository repo; public ExamService(ExamRepository r){repo=r;}
 public ExamResponseDTO create(ExamRequestDTO d){Exam e=new Exam();copy(d,e);e.setStatus("UPCOMING");return dto(repo.save(e));}
 public List<ExamResponseDTO> all(){return repo.findAll().stream().map(this::dto).toList();}
 public ExamResponseDTO get(Integer id){return dto(repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Exam not found: "+id)));}
 public ExamResponseDTO update(Integer id,ExamRequestDTO d){Exam e=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Exam not found: "+id));copy(d,e);return dto(repo.save(e));}
 public void delete(Integer id){if(!repo.existsById(id))throw new ResourceNotFoundException("Exam not found: "+id);repo.deleteById(id);}
 private void copy(ExamRequestDTO d,Exam e){e.setExamName(d.examName());e.setDescription(d.description());e.setDuration(d.duration());e.setTotalMarks(d.totalMarks());e.setPassingMarks(d.passingMarks());e.setStartTime(d.startTime());e.setEndTime(d.endTime());}
 private ExamResponseDTO dto(Exam e){return new ExamResponseDTO(e.getExamId(),e.getExamName(),e.getDescription(),e.getDuration(),e.getTotalMarks(),e.getPassingMarks(),e.getStartTime(),e.getEndTime(),e.getStatus());}
}
