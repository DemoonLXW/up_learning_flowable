package com.demoon.uplearning.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_time")
    private LocalDateTime created_time;

    @Column(name = "deleted_time")
    private LocalDateTime deleted_time;

    @Column(name = "modified_time")
    private LocalDateTime modified_time;

    @Column(name = "is_disabled")
    private Boolean is_disabled;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<UserRole> users = new ArrayList<>();
}
