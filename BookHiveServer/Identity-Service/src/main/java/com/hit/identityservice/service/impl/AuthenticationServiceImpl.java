package com.hit.identityservice.service.impl;

import com.hit.identityservice.domain.dto.request.AuthenticationRequest;
import com.hit.identityservice.exception.AppException;
import com.hit.identityservice.exception.ErrorCode;
import com.hit.identityservice.repository.UserRepository;
import com.hit.identityservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public boolean Authenticate(AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
    }
}
