package com.crmnexus.backend.controller.auth;

import com.crmnexus.backend.dto.request.RegisterRequest;
import com.crmnexus.backend.dto.response.RegisterResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    public RegisterController() {
    }

    ResponseEntity<RegisterResponse> register (@Valid @RequestBody RegisterRequest registerRequest) {
        return null;
    }
}
