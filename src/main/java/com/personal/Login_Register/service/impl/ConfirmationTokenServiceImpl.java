package com.personal.Login_Register.service.impl;

import com.personal.Login_Register.model.token.ConfirmationToken;
import com.personal.Login_Register.repository.ConfirmationTokenRepository;
import com.personal.Login_Register.service.token.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {

        log.info("Saving confirmation token: {}", confirmationToken.getToken());
        confirmationTokenRepository.save(confirmationToken);
        log.info("Confirmation token saved successfully");
    }

    @Override
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Override
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token,
                LocalDateTime.now()
        );
    }
}
