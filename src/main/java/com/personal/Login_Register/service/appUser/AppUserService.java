package com.personal.Login_Register.service.appUser;

import com.personal.Login_Register.model.AppUser;
import com.personal.Login_Register.model.token.ConfirmationToken;
import com.personal.Login_Register.repository.AppUserRepository;
import com.personal.Login_Register.service.token.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found in the database")
                );
    }

    public String signUpUser(AppUser appUser) {
        boolean exist = appUserRepository.findByEmail(appUser.getEmail())
                .isPresent();

        if (exist) {
            throw new IllegalStateException("Email already taken");
        }

        String PasswordEncode = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(PasswordEncode);

        appUserRepository.save(appUser);

        //TODO: Send comfirmation token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //TODO: Send email

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
