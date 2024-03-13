package dev.service;


import dev.auth.AuthRequest;
import dev.auth.AuthResponse;
import dev.auth.RegisterRequest;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse authenticate(AuthRequest request);
}
