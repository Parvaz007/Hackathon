package com.exambuddy.backend.Controller;

import com.exambuddy.backend.DTO.WeakTopicResponse;
import com.exambuddy.backend.Service.ExamService;
import com.exambuddy.backend.Service.LLMService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class AIController {

    private final ExamService examService;
    private final LLMService llmService;

    public AIController(ExamService examService, LLMService llmService) {
        this.examService = examService;
        this.llmService = llmService;
    }

    @GetMapping("/study-plan/{studentId}")
    public String studyPlan(@PathVariable Long studentId) throws Exception {

        List<WeakTopicResponse> weakTopics = examService.getWeakTopics(studentId);

        ObjectMapper mapper = new ObjectMapper();
        String weakTopicsJson = mapper.writeValueAsString(weakTopics);

        return llmService.generateStudyPlan(weakTopicsJson);
    }

}
