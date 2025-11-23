package com.exambuddy.backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ExamRequest {
    private Long studentId;
    private String subject;
    private Integer marksObt;
    private Integer marksTotal;
    private LocalDate date;

    private List<TopicRequest> topics;
}
