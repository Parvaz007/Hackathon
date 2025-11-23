package com.exambuddy.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WeakTopicResponse {
    private String topicName;
    private int correct;
    private int wrong;
    private double accuracy;
}
