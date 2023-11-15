package com.demoon.uplearning.service.impl;


import com.demoon.uplearning.service.ApplicantService;
import com.demoon.uplearning.entity.Project;
import com.demoon.uplearning.entity.Role;
import com.demoon.uplearning.entity.User;
import com.demoon.uplearning.entity.UserRole;
import com.demoon.uplearning.repository.ProjectRepository;
import com.demoon.uplearning.repository.UserRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
    public User getTeacherReviewerByApplicantID(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public List<Role> getRolesByUserID(Integer id) {
        User user = userRepository.findById(id).orElseThrow();

        return user.getRoles();
    }

    @Override
    @Transactional
    public void modifyProjectByProjectID(Integer id, Project update) {
        Project origin = projectRepository.findById(id).orElseThrow();
        if(update.getReviewStatus() != null) {
            origin.setReviewStatus(update.getReviewStatus());
        }
        projectRepository.save(origin);
    }


}
