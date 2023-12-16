package com.novelti.usercreate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.novelti.usercreate.dto.UserDto;
import com.novelti.usercreate.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUserCreate(@RequestBody UserDto userDto) {
        try {
            UserDto savedUsers = userService.createUserCreate(userDto);
            return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("An internal server error occurred", e);
            return new ResponseEntity<>("An internal server error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Build Get Employee Rest API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserCreateById(@PathVariable("id") Long usercreateId) {
        UserDto userDto = userService.getUserCreateById(usercreateId);
        return ResponseEntity.ok(userDto);
    }

    // Build Get All Users Rest API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUserCreate() {
        List<UserDto> usercreates = userService.getAllUserCreate();
        return ResponseEntity.ok(usercreates);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUserCreate(@PathVariable("id") Long usercreateId,
                                                    @RequestBody UserDto updatedUserCreate) {
        UserDto userDto = userService.updateUserCreate(usercreateId, updatedUserCreate);
        return ResponseEntity.ok(userDto);
    }

    // Build delete user REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserCreate(@PathVariable("id") Long usercreateId) {
        userService.deleteUserCreate(usercreateId);
        return ResponseEntity.ok("User deleted successfully!.");
    }
}
