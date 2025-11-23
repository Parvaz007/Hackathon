package com.exambuddy.backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicRequest {
    private String topicName;
    private Integer correct;
    private Integer wrong;
}
