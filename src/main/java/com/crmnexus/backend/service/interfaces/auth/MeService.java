package com.crmnexus.backend.service.interfaces.auth;

import com.crmnexus.backend.dto.request.LoginRequest;
import com.crmnexus.backend.dto.request.RegisterRequest;
import com.crmnexus.backend.dto.response.LoginResponse;
import com.crmnexus.backend.dto.response.RegisterResponse;

public interface MeService {

    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);
}
