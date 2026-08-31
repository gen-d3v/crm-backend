package com.crmnexus.backend.service.interfaces.user;


import com.crmnexus.backend.dto.request.LoginRequest;
import com.crmnexus.backend.dto.response.LoginResponse;

public interface UserService {

    LoginResponse login(LoginRequest loginRequest);

}
