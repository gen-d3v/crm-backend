package com.crmnexus.backend.service.impl.user;

import com.crmnexus.backend.dto.request.LoginRequest;
import com.crmnexus.backend.dto.response.LoginResponse;
import com.crmnexus.backend.service.interfaces.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public LoginResponse Login(LoginRequest loginRequest) {
        LoginResponse loginResponse = login(loginRequest);




        return loginResponse;

    }
}
