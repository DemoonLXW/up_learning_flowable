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
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<UserRole> userRole = new ArrayList<>();

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private List<User> users = new ArrayList<>();

}
