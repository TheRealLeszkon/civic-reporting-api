package com.sih.michael.civilized_reporting_api.services;

import com.sih.michael.civilized_reporting_api.domain.dtos.AuthResponse;
import com.sih.michael.civilized_reporting_api.domain.dtos.LoginRequest;
import com.sih.michael.civilized_reporting_api.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> listAllUsers();
    User createNewUser(User user);

    AuthResponse verify(LoginRequest loginRequest);

    void deleteUser(UUID id);

    User findUserById(UUID id);

    User findUserByUsername(String username);

}
