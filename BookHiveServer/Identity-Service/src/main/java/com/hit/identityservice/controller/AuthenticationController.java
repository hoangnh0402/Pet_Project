package com.hit.identityservice.controller;

import com.hit.identityservice.domain.dto.request.AuthenticationRequest;
import com.hit.identityservice.domain.dto.response.ApiResponse;
import com.hit.identityservice.domain.dto.response.AuthenticationResponse;
import com.hit.identityservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        boolean result = authenticationService.Authenticate(authenticationRequest);
        return ApiResponse.<AuthenticationResponse>builder()
                .data(AuthenticationResponse.builder().authenticated(result).build())
                .build();
    }
}
