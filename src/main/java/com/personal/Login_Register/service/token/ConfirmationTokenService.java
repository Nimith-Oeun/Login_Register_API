package com.personal.Login_Register.service.token;

import com.personal.Login_Register.model.token.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenService {

    void saveConfirmationToken(ConfirmationToken confirmationToken);
    Optional<ConfirmationToken> getToken(String token);
    int setConfirmedAt(String token);
}
