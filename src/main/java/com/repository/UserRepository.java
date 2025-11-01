package com.example.landingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.landingapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
