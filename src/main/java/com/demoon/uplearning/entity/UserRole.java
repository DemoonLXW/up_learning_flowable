package com.demoon.uplearning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "user_role")
public class UserRole {

    @Id
    @ManyToOne
    @JoinColumn(name = "rid")
    private Role role;

    @Id
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @Column(name = "created_time")
    private LocalDateTime created_time;
}
