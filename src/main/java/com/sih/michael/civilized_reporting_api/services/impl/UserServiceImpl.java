package com.sih.michael.civilized_reporting_api.services.impl;

import com.sih.michael.civilized_reporting_api.domain.dtos.AuthResponse;
import com.sih.michael.civilized_reporting_api.domain.dtos.LoginRequest;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.repositories.UserRepository;
import com.sih.michael.civilized_reporting_api.services.JWTService;
import com.sih.michael.civilized_reporting_api.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override //No Changes Needed
    public User createNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword() ));
        return userRepository.save(user);
    }

    @Override // No Changes Needed
    public AuthResponse verify(LoginRequest loginRequest) {
        String userId = findUserByUsername(loginRequest.getUsername()).getId();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );
        if(authentication.isAuthenticated()){
            String token =jwtService.generateToken(loginRequest.getUsername());
            return AuthResponse.builder()
                    .token(token)
                    .userId(userId)
                    .expiresIn(jwtService.extractExpiration(token).getTime())
                    .build();
        }
        return new AuthResponse("bad credentials",userId,0);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id ["+id+"] is was not found!")
        );
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("{JWT FILTER}: No User By the name Exists"));
    }


}
