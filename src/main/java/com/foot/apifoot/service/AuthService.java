package com.foot.apifoot.service;

import com.foot.apifoot.dto.AuthRequestDto;
import com.foot.apifoot.dto.AuthResponseDto;

public interface AuthService {
    AuthResponseDto register(AuthRequestDto request);
    AuthResponseDto login(AuthRequestDto request);
}