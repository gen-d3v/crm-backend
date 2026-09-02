package com.crmnexus.backend.service.impl.auth;

import com.crmnexus.backend.dto.request.LoginRequest;
import com.crmnexus.backend.dto.request.RegisterRequest;
import com.crmnexus.backend.dto.response.LoginResponse;
import com.crmnexus.backend.dto.response.RegisterResponse;
import com.crmnexus.backend.entities.UserEntity;
import com.crmnexus.backend.enums.Role;
import com.crmnexus.backend.exception.ConflictException;
import com.crmnexus.backend.exception.UnauthorizedException;
import com.crmnexus.backend.repository.UserRepository;
import com.crmnexus.backend.service.interfaces.auth.MeService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MeServiceImpl implements MeService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;


    public MeServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity user = userRepo
                .findByEmailOrUsername(loginRequest.identifier(), loginRequest.identifier());

        if (user == null) {
            throw new UnauthorizedException("Invalid credentials");
        }

        if (!passwordEncoder.matches(loginRequest.rawPassword(), user.getPasswordHash())) {
            throw new UnauthorizedException("Invalid credentials");
        }

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getRole());

    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if (emailExists(registerRequest.email())) throw new ConflictException("Email already exists");

        if (usernameExists(registerRequest.username())) throw new ConflictException("Username already exists");

        String hashedPassword = passwordEncoder.encode(registerRequest.rawPassword());
        UUID userId = UUID.randomUUID();

        Role defaultRole = Role.USER;

        UserEntity user = new UserEntity(
                userId,
                registerRequest.username(),
                registerRequest.email(),
                hashedPassword,
                registerRequest.firstname(),
                registerRequest.lastname(),
                defaultRole
        );

        userRepo.save(user);

        return new RegisterResponse("Registered successfully");
    }

    private boolean emailExists(String email) {
        return userRepo.existsUserEntitiesByEmail(email);
    }

    private boolean usernameExists(String username) {
        return userRepo.existsUserEntitiesByUsername(username);
    }
}
