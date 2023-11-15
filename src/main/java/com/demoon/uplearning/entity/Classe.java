package com.demoon.uplearning.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity(name = "class")
public class Classe {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "grade")
    private String grade;

    @Column(name = "name")
    private String name;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mid")
    @ToString.Exclude
    private Major major;

//    @OneToMany(mappedBy = "classe")
//    @ToString.Exclude
//    private List<Student> students = new ArrayList<>();

}
