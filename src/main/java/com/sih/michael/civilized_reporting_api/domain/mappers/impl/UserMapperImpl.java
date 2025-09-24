package com.sih.michael.civilized_reporting_api.domain.mappers.impl;

import com.sih.michael.civilized_reporting_api.domain.dtos.UserDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.domain.mappers.UserMapper;
import org.springframework.stereotype.Component;

@Component("General")
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .type(user.getType())
                .mobile(user.getMobile())
                .email(user.getEmail())
                .adhaar(user.getAdhaar())
                .verified(user.isVerified())
                .avatarUrl(user.getAvatarUrl())
                .bio(user.getBio())
                .joinedDate(user.getJoinedDate())
                .build();
    }

    @Override
    public User fromDTO(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .type(userDTO.getType())
                .mobile(userDTO.getMobile())
                .email(userDTO.getEmail())
                .adhaar(userDTO.getAdhaar())
                .verified(userDTO.isVerified())
                .avatarUrl(userDTO.getAvatarUrl())
                .bio(userDTO.getBio())
                .joinedDate(userDTO.getJoinedDate())
                .build();
    }
}
