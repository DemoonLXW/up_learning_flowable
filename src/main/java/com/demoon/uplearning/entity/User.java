package com.demoon.uplearning.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @Column(name = "is_disabled")
    private Boolean is_disabled;

//    @ManyToMany(targetEntity = Role.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_role",
//            joinColumns = {@JoinColumn(name = "uid")},
//            inverseJoinColumns = {@JoinColumn(name = "rid")}
//    )
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<UserRole> userRole = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "rid")}
    )
    @ToString.Exclude
    private List<Role> roles = new ArrayList<>();
}
