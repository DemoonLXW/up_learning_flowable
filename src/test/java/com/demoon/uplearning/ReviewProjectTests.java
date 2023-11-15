package com.demoon.uplearning;

import com.demoon.uplearning.entity.User;
import com.demoon.uplearning.entity.UserRole;
import jakarta.transaction.Transactional;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewProjectTests {

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Test
    void queryTask() {



    }
}
