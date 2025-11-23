package com.exambuddy.backend.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class LLMService {

    public String generateStudyPlan(String weakTopicsJson) {

        RestTemplate rest = new RestTemplate();

        String prompt = """
                You are a study coach. A student is weak in the following topics:
                %s
                
                Generate a simple and easy study plan Also please provide motivation to the student for study.But keep it descriptive and crisp.Do not suggest any harmfull content. And do not include any emojies.
                """.formatted(weakTopicsJson);

        Map<String, Object> request = Map.of(
                "model", "gemma2:2b",
                "prompt", prompt,
                "stream", false
        );

        Map response = rest.postForObject(
                "http://localhost:11434/api/generate",
                request,
                Map.class
        );

        return (String) response.get("response");
    }
}
