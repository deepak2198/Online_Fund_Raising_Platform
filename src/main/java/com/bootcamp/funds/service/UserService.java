package com.bootcamp.funds.service;

import java.util.List;

import com.bootcamp.funds.dto.UserDto;

public interface UserService {
	public UserDto addUser(UserDto dto);
	public UserDto updateUser(Long user_id, UserDto dto);
	public String deleteUserById(Long user_id);
	List<UserDto> showAllUsers();
	UserDto getUserById(Long user_id);

}
