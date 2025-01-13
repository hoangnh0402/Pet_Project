package com.hit.identityservice.service;

import com.hit.identityservice.domain.dto.request.AuthenticationRequest;

public interface AuthenticationService {
    public boolean Authenticate(AuthenticationRequest authenticationRequest);
}
