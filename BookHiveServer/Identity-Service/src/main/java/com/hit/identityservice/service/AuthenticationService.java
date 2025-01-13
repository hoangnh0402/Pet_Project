package com.hit.identityservice.service;

import com.hit.identityservice.domain.dto.request.AuthenticationRequest;
import com.hit.identityservice.domain.dto.request.IntrospectRequest;
import com.hit.identityservice.domain.dto.response.AuthenticationResponse;
import com.hit.identityservice.domain.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeyLengthException;

import java.text.ParseException;

public interface AuthenticationService {
    public AuthenticationResponse Authenticate(AuthenticationRequest authenticationRequest);
    public IntrospectResponse Introspect(IntrospectRequest authenticationRequest) throws JOSEException, ParseException;
}
