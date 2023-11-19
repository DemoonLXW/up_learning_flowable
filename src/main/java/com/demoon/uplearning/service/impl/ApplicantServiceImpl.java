package com.demoon.uplearning.service.impl;


import com.demoon.uplearning.entity.*;
import com.demoon.uplearning.service.ApplicantService;
import com.demoon.uplearning.repository.ProjectRepository;
import com.demoon.uplearning.repository.UserRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ProjectRepository projectRepository;

    @Override
    public User getUserByID(Integer id) {

        return userRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void modifyProjectByProjectID(Integer id, Project update) {
        Project origin = projectRepository.findById(id).orElseThrow();
        if(update.getReviewStatus() != null) {
            origin.setReviewStatus(update.getReviewStatus());
        }
        origin.setModifiedTime(LocalDateTime.now());
        projectRepository.save(origin);
    }


    @Override
    public String getTeacherReviewer(Integer userID) {



        return null;
    }

    @Override
    @Transactional
    public Boolean isTeacher(Integer userID) {

        User user = userRepository.findById(userID).orElseThrow();

        return user.getTeacher() != null;
    }


}
