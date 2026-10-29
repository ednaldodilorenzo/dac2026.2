package com.example.base.controller;

import com.example.base.dto.LoginReqDto;
import com.example.base.dto.UsuarioReqDto;
import com.example.base.service.AdminService;
import com.example.base.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestBody LoginReqDto dto) {
        return authService.login(dto);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody UsuarioReqDto dto) {
        adminService.salvarUsuario(dto);
    }

}
