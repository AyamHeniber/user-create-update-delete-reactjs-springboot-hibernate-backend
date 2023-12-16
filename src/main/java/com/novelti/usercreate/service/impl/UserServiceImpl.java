package com.novelti.usercreate.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.novelti.usercreate.dto.UserDto;
import com.novelti.usercreate.entity.UserCreate;
import com.novelti.usercreate.exception.ResourceNotFoundException;
import com.novelti.usercreate.mapper.UserMapper;
import com.novelti.usercreate.repository.UserRepository;
import com.novelti.usercreate.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUserCreate(UserDto userDto) {
        UserCreate userCreate = UserMapper.mapToUserCreate(userDto);
        UserCreate savedUser = userRepository.save(userCreate);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserCreateById(Long usercreateId) {
        UserCreate usercreate = userRepository.findById(usercreateId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with given id: " + usercreateId));
        return UserMapper.mapToUserDto(usercreate);
    }

	@Override
	public List<UserDto> getAllUserCreate() {
		
		List<UserCreate> userCreates=userRepository.findAll();
		return userCreates.stream().map((usercreate)-> UserMapper.mapToUserDto(usercreate))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUserCreate(Long usercreateId, UserDto updatedUserCreate) {
		UserCreate usercreate = userRepository.findById(usercreateId).orElseThrow(
				()-> new ResourceNotFoundException("User is not exists with given id: "+ usercreateId));
		
		usercreate.setFirstName(updatedUserCreate.getFirstName());
		usercreate.setLastName(updatedUserCreate.getLastName());
		usercreate.setEmail(updatedUserCreate.getEmail());
		usercreate.setMobile(updatedUserCreate.getMobile());
		usercreate.setAddress1(updatedUserCreate.getAddress1());
		usercreate.setAddress2(updatedUserCreate.getAddress2());
		usercreate.setCountry(updatedUserCreate.getCountry());
		usercreate.setState(updatedUserCreate.getState());
		usercreate.setZipCode(updatedUserCreate.getZipCode());
		
		UserCreate updatedUserCreateObj= userRepository.save(usercreate);
		
		return UserMapper.mapToUserDto(updatedUserCreateObj);
		
	}

	@Override
	public void deleteUserCreate(Long usercreateId) {
		
		UserCreate usercreate = userRepository.findById(usercreateId).orElseThrow(
				()-> new ResourceNotFoundException("User is not exists with given id: "+ usercreateId));
		
		userRepository.deleteById(usercreateId);
		
	}
}
