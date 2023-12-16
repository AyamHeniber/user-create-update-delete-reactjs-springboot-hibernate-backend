package com.novelti.usercreate.mapper;

import com.novelti.usercreate.dto.UserDto;
import com.novelti.usercreate.entity.UserCreate;

public class UserMapper 
{
	
	public static UserDto mapToUserDto(UserCreate usercreate)
	{
		return new UserDto(
			usercreate.getId(),
			usercreate.getFirstName(),
			usercreate.getLastName(),
			usercreate.getEmail(),
			usercreate.getMobile(),
			usercreate.getAddress1(),
			usercreate.getAddress2(),
			usercreate.getCountry(),
			usercreate.getState(),
			usercreate.getZipCode()
		);
	}
	
	public static UserCreate mapToUserCreate(UserDto userdto)
	{
		return new UserCreate(
			userdto.getId(),
			userdto.getFirstName(),
			userdto.getLastName(),
			userdto.getEmail(),
			userdto.getMobile(),
			userdto.getAddress1(),
			userdto.getAddress2(),
			userdto.getCountry(),
			userdto.getState(),
			userdto.getZipCode()
		);
	}
}
