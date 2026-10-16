package com.example.base.service;

import com.example.base.core.security.JwtService;
import com.example.base.dto.LoginReqDto;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;

    private final JwtService jwtService;

    @Override
    public String login(LoginReqDto dto) {
        // Authentication manager do spring securitry
        Authentication authentication = authManager.
                authenticate(
                        new UsernamePasswordAuthenticationToken(dto.email(),
                                dto.senha())
                );
        // Gerar o token e passar e retornar
        return jwtService.generateToken(authentication);
    }
}
