package com.demoon.uplearning.ServiceImpl;


import com.demoon.uplearning.Service.ApplicantService;
import com.demoon.uplearning.entity.User;
import com.demoon.uplearning.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User getUserByID(Integer id) {

        return userRepository.findById(id).orElseThrow();
    }
}
