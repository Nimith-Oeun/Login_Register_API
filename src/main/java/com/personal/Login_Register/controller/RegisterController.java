package com.personal.Login_Register.controller;

import com.personal.Login_Register.dto.RegisterRequest;
import com.personal.Login_Register.service.register.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/register")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest){
        String respone = registerService.registerUser(registerRequest);
        return ResponseEntity.ok(respone);
    }

    @GetMapping("confirm")
    public ResponseEntity<String> confirmToken(@RequestParam("token") String token) {
        String response = registerService.confirmToken(token);
        return ResponseEntity.ok(response);
    }



}
