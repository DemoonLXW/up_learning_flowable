package com.demoon.uplearning.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "project")
public class Project {


    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "principle")
    private String principle;

    @Column(name = "goal")
    private String goal;

    @Column(name = "process_and_method")
    private String processAndMethod;

    @Column(name = "requirement")
    private String requirement;

    @Column(name = "result_and_conclusion")
    private String resultAndConclusion;

    @Column(name = "step")
    private String step;

    @Column(name = "review_status")
    private Integer reviewStatus;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;
}
