package com.crmnexus.backend.service.impl.user;
import com.crmnexus.backend.dto.request.LoginRequest;
import com.crmnexus.backend.dto.response.LoginResponse;
import com.crmnexus.backend.entities.UserEntity;
import com.crmnexus.backend.exception.httpError.UnauthorizedException;
import com.crmnexus.backend.repository.UserRepository;
import com.crmnexus.backend.service.interfaces.user.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
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
}
