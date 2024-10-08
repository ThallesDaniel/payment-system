package com.thallesdaniel.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.thallesdaniel.paymentsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    UserDetails findByEmail(String email);
    User findByVerificationCode(String verificationCode);
}