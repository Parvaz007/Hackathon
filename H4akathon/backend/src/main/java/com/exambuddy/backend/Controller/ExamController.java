package com.exambuddy.backend.Controller;

import com.exambuddy.backend.DTO.ExamRequest;
import com.exambuddy.backend.DTO.WeakTopicResponse;
import com.exambuddy.backend.Entity.Exam;
import com.exambuddy.backend.Service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/add")
    public Exam addExam(@RequestBody ExamRequest request) {
        return examService.addExam(request);
    }

    @GetMapping("/all")
    public List<Exam> getAll() {
        return examService.getAllExams();
    }

    @GetMapping("/student/{studentId}")
    public List<Exam> getByStudent(@PathVariable Long studentId) {
        return examService.getExamsByStudent(studentId);
    }
    @GetMapping("/weak-topics/{studentId}")
    public List<WeakTopicResponse> getWeakTopics(@PathVariable Long studentId) {
        return examService.getWeakTopics(studentId);
    }
}
