// 

































package com.example.landingapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.landingapp.model.User;
import com.example.landingapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        User u = new User();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        return userRepository.save(u);
    }

    public User login(String email, String password) {
        User u = userRepository.findByEmail(email);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
