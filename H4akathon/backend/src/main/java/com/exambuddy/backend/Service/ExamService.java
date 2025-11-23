package com.exambuddy.backend.Service;

import com.exambuddy.backend.DTO.ExamRequest;
import com.exambuddy.backend.DTO.TopicRequest;
import com.exambuddy.backend.DTO.WeakTopicResponse;
import com.exambuddy.backend.Entity.Exam;
import com.exambuddy.backend.Entity.Topic;
import com.exambuddy.backend.Repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam addExam(ExamRequest request) {

        Exam exam = new Exam();
        exam.setStudentId(request.getStudentId());
        exam.setSubject(request.getSubject());
        exam.setMarksObt(request.getMarksObt());
        exam.setMarksTotal(request.getMarksTotal());
        exam.setDate(request.getDate());

        List<Topic> topicList = new ArrayList<>();

        for (TopicRequest t : request.getTopics()) {
            Topic topic = new Topic();
            topic.setTopicName(t.getTopicName());
            topic.setCorrect(t.getCorrect());
            topic.setWrong(t.getWrong());
            topic.setExam(exam);
            topicList.add(topic);
        }

        exam.setTopics(topicList);

        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public List<Exam> getExamsByStudent(Long studentId) {
        return examRepository.findByStudentId(studentId);
    }

    public List<WeakTopicResponse> getWeakTopics(Long studentId) {

        List<Exam> exams = examRepository.findByStudentId(studentId);
        List<WeakTopicResponse> weakTopics = new ArrayList<>();

        for (Exam e : exams) {
            for (Topic t : e.getTopics()) {
                int total = t.getCorrect() + t.getWrong();
                double accuracy = total == 0 ? 0.0 : (t.getCorrect() * 100.0 / total);

                if (accuracy < 50.0) {
                    weakTopics.add(
                            new WeakTopicResponse(
                                    t.getTopicName(),
                                    t.getCorrect(),
                                    t.getWrong(),
                                    accuracy
                            )
                    );
                }
            }
        }

        return weakTopics;
    }
}
