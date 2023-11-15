package com.demoon.uplearning.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "student_id")
    private String studentID;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    @ToString.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    @ToString.Exclude
    private Classe classe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")
    @ToString.Exclude
    private Teacher teacher;
}
