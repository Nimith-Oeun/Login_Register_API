package com.personal.Login_Register.dto;

import com.personal.Login_Register.enumeration.UserRole;
import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String email;
    private String password;

}
