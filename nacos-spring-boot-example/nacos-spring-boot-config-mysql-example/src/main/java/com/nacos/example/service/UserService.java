package com.nacos.example.service;

import com.nacos.example.dao.UserRepository;
import com.nacos.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

}
