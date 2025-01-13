package com.hit.identityservice.controller;

import com.hit.identityservice.domain.dto.request.AuthenticationRequest;
import com.hit.identityservice.domain.dto.request.IntrospectRequest;
import com.hit.identityservice.domain.dto.response.ApiResponse;
import com.hit.identityservice.domain.dto.response.AuthenticationResponse;
import com.hit.identityservice.domain.dto.response.IntrospectResponse;
import com.hit.identityservice.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        var result = authenticationService.Authenticate(authenticationRequest);
        return ApiResponse.<AuthenticationResponse>builder()
                .success(true)
                .data(result)
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> login(@RequestBody IntrospectRequest introspectRequest) throws JOSEException, ParseException {
        var result = authenticationService.Introspect(introspectRequest);
        return ApiResponse.<IntrospectResponse>builder()
                .success(true)
                .data(result)
                .build();
    }
}
