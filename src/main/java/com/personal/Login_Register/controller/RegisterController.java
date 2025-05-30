package com.personal.Login_Register.controller;

import com.personal.Login_Register.dto.RegisterRequest;
import com.personal.Login_Register.service.Register.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/register")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        registerService.
        return ResponseEntity.ok().build();
    }



}
