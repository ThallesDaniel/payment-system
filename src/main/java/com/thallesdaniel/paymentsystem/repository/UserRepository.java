package com.thallesdaniel.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thallesdaniel.paymentsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}