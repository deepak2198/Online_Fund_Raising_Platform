package com.bootcamp.funds.service;

import java.util.List;

import com.bootcamp.funds.model.User;

public interface UserService {
	User addUser(User user);
	User updateUser(User user);
	String deleteUserById(Long user_id);
	List<User> showAllUsers();
	User getUserById(Long user_id);
	boolean validateUser(String user_name, String password);

}
