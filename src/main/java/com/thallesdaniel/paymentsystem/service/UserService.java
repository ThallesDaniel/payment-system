package com.thallesdaniel.paymentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thallesdaniel.paymentsystem.entity.User;
import com.thallesdaniel.paymentsystem.repository.UserRepository;
import com.thallesdaniel.paymentsystem.utils.RandomString;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("This email already exist");
        }else{
            String encodedPassword =  passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            String randomCode = RandomString.generateRandomString(64);
            user.setVerificationCode(randomCode);
            user.setEnabled(false);
            User savedUser = userRepository.save(user);
            
            return savedUser;
        }

    }
}
