package com.demoon.uplearning;

import com.demoon.uplearning.entity.*;
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

//    @Autowired
//    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void queryUser() {

        User user = userRepository.findOne(QUser.user.id.eq(1)).orElseThrow();
        for(Role r:user.getRoles()) {
            System.out.println(r);
        }

    }

    @Test
    void testProject() {

        Project project = new Project();
        System.out.println(project.getCreatedTime() == null);
        System.out.println(project.getReviewStatus() == null);

    }

}
