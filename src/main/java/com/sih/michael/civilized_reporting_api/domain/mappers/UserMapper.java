package com.sih.michael.civilized_reporting_api.domain.mappers;

import com.sih.michael.civilized_reporting_api.domain.dtos.UserDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.User;

public interface UserMapper {
    UserDTO toDTO(User user);
    User fromDTO(UserDTO userDTO);
}
