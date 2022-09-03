package com.bootcamp.funds.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.funds.dto.UserDto;
import com.bootcamp.funds.exceptions.UserNotFoundException;
import com.bootcamp.funds.model.User;
import com.bootcamp.funds.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto addUser(UserDto dto) {
		User user = modelMapper.map(dto, User.class);
		user = repo.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(Long userId, UserDto dto) {
		repo.deleteById(userId);
		return addUser(dto);
	}

	@Override
	public List<UserDto> showAllUsers() {
		List<User> users = repo.findAll();
		List<UserDto> userDto = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public String deleteUserById(Long user_id) {
		Optional<User> opt = repo.findById(user_id);
		if(!opt.isPresent()) {
			throw new UserNotFoundException();
		}
		repo.deleteById(user_id);
		return "User with Id:: "+user_id+" is deleted successfully";
	}
	
	@Override
	public UserDto getUserById(Long user_id) {
		boolean opt = repo.existsById(user_id);
		if(opt == false) {
			throw new UserNotFoundException();
		}
		return modelMapper.map(repo.findById(user_id).get(), UserDto.class);
	}

}
