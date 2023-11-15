package com.demoon.uplearning.service;


import com.demoon.uplearning.entity.Project;
import com.demoon.uplearning.entity.Role;
import com.demoon.uplearning.entity.User;

import java.util.List;

public interface ApplicantService {
    public User getUserByID(Integer id);

    public User getTeacherReviewerByApplicantID(Integer id);

    public List<Role> getRolesByUserID(Integer id);

    public void modifyProjectByProjectID(Integer id, Project update);


}
