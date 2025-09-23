package com.sih.michael.civilized_reporting_api.controllers;

import com.sih.michael.civilized_reporting_api.domain.dtos.UserDTO;
import com.sih.michael.civilized_reporting_api.domain.mappers.UserMapper;
import com.sih.michael.civilized_reporting_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    private final UserMapper NoBSuserMapper;


    @GetMapping
    public List<UserDTO> showAllUsers(){
        return userService.listAllUsers().stream().map(userMapper::toDTO).toList();
    }

    @PostMapping
    public ResponseEntity<UserDTO> registerNewUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(
            userMapper.toDTO(
                    userService.createNewUser(userMapper.fromDTO(userDTO))
            ),HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
