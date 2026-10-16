package com.example.base.service;

import com.example.base.dto.LoginReqDto;

public interface AuthService {
    String login(LoginReqDto dto);
}
