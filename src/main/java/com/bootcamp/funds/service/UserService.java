package com.bootcamp.funds.service;

import java.util.List;

import com.bootcamp.funds.dto.UserDto;

public interface UserService {
	public UserDto addUser(UserDto dto);
	public UserDto updateUser(String username, UserDto dto);
	public String deleteUser(String username);
	List<UserDto> showAllUsers();
	UserDto getUserByName(String username);

}
