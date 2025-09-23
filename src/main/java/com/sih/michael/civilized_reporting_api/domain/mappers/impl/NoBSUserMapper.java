package com.sih.michael.civilized_reporting_api.domain.mappers.impl;

import com.sih.michael.civilized_reporting_api.domain.dtos.UserDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.domain.mappers.UserMapper;
import org.springframework.stereotype.Component;

@Component("NoBS")
public class NoBSUserMapper implements UserMapper {
    @Override
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .comments(user.getComments())
                .build();
    }

    @Override
    public User fromDTO(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .role(userDTO.getRole())
                .build();
    }
}
