package com.personal.Login_Register.service.register;

import com.personal.Login_Register.dto.RegisterRequest;

public interface RegisterService {
    String registerUser(RegisterRequest registerRequest);
    String confirmToken(String token);
}
