package com.demoon.uplearning.repository;

import com.demoon.uplearning.entity.Student;
import com.demoon.uplearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
