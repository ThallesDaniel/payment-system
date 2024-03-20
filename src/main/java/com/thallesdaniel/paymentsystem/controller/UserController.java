package com.thallesdaniel.paymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thallesdaniel.paymentsystem.dto.UserRequest;
import com.thallesdaniel.paymentsystem.dto.UserResponse;
import com.thallesdaniel.paymentsystem.entity.User;
import com.thallesdaniel.paymentsystem.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity <UserResponse> registerUser(@RequestBody @Valid UserRequest userRequest) {
        User user = userRequest.toModel();
        UserResponse userSaved = userService.registerUser(user);
        return ResponseEntity.ok().body(userSaved);
    }
    
}
