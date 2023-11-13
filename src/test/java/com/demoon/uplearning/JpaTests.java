package com.demoon.uplearning;

import com.demoon.uplearning.Service.ApplicantService;
import com.demoon.uplearning.entity.User;
import com.demoon.uplearning.entity.UserRole;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaTests {

    @Autowired
    private ApplicantService applicantService;

    @Test
    @Transactional
    void queryUser() {

        User user = applicantService.getUserByID(1L);
        for(UserRole ur:user.getRoles()) {
            System.out.println(ur.getRole());
        }

    }
}
