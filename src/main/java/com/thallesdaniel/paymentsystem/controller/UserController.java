package com.thallesdaniel.paymentsystem.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thallesdaniel.paymentsystem.dto.UserRequest;
import com.thallesdaniel.paymentsystem.dto.UserResponse;
import com.thallesdaniel.paymentsystem.entity.User;
import com.thallesdaniel.paymentsystem.service.UserService;

import jakarta.validation.Valid;

import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity <UserResponse> registerUser(@RequestBody @Valid UserRequest userRequest) throws MessagingException, UnsupportedEncodingException {
        User user = userRequest.toModel();
        UserResponse userSaved = userService.registerUser(user);
        return ResponseEntity.ok().body(userSaved);
    }
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code){
        if(userService.verify(code)){
            return "Seu email foi validado!";
        } else {
            return "Ocorreu um erro na validação do seu email! Entre em contato com o suporte!";
        }
    }
    @GetMapping("/teste")
    public String teste(){
        return "você está logado";
    }
}
