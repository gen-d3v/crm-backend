package com.crmnexus.backend.controller.auth;

import com.crmnexus.backend.dto.request.LoginRequest;
import com.crmnexus.backend.dto.request.RegisterRequest;
import com.crmnexus.backend.dto.response.LoginResponse;
import com.crmnexus.backend.dto.response.RegisterResponse;
import com.crmnexus.backend.service.interfaces.auth.MeService;
import com.crmnexus.backend.service.interfaces.worker.WorkerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final MeService meService;
    private final WorkerService workerService;

    public AccountController(MeService meService, WorkerService workerService) {
        this.meService = meService;
        this.workerService = workerService;
    }

    @PostMapping("/register")
   public ResponseEntity<RegisterResponse> register (@Valid @RequestBody RegisterRequest registerRequest) {
        RegisterResponse response  = meService.register(registerRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse response = meService.login(loginRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("/test")
    public void test() {
        workerService.testEncryptionAndDecryption();

    }
}




