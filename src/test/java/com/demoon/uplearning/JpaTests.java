package com.demoon.uplearning;

import com.demoon.uplearning.entity.*;
import com.demoon.uplearning.repository.StudentRepository;
import com.demoon.uplearning.repository.UserRepository;
import com.demoon.uplearning.service.ApplicantService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JpaTests {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void queryUser() {

        Student student = studentRepository.findById(1).orElseThrow();
        System.out.println(student);
        System.out.println(student.getUser());
        Classe classe = student.getClasse();
        System.out.println(classe);
        Major major = classe.getMajor();
        System.out.println(major);
        College college = major.getCollege();
        System.out.println(college);
    }

    @Test
    void testProject() {

        Project project = new Project();
        System.out.println(project.getCreatedTime() == null);
        System.out.println(project.getReviewStatus() == null);

    }

    @Test
    void testDSL() {

    }

}
