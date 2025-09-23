package com.sih.michael.civilized_reporting_api.controllers;

import com.sih.michael.civilized_reporting_api.domain.dtos.AuthResponse;
import com.sih.michael.civilized_reporting_api.domain.dtos.LoginRequest;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final UserService userService;
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        return userService.verify(loginRequest);
    }
}
