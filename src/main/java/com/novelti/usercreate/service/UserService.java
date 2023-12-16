package com.novelti.usercreate.service;

import java.util.List;

import com.novelti.usercreate.dto.UserDto;

public interface UserService {
    UserDto createUserCreate(UserDto userDto);

    UserDto getUserCreateById(Long usercreateId);
    
    List<UserDto> getAllUserCreate();
    
    UserDto updateUserCreate(Long usercreateId,UserDto updatedUserCreate);
    
    void deleteUserCreate(Long usercreateId);
}
