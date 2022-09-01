package com.bootcamp.funds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.funds.exceptions.UserNotFoundException;
import com.bootcamp.funds.model.User;
import com.bootcamp.funds.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> opt = repo.findById(user.getUserId());
		if(!opt.isPresent()) {
			throw new UserNotFoundException();
		}
		return addUser(user);
	}

	@Override
	public List<User> showAllUsers() {
		return repo.findAll();
	}

	@Override
	public boolean validateUser(String user_name, String password) {
		Optional<User> opt = repo.findByUsernameAndPassword(user_name, password);
		if(opt.get() == null) {
			return false;
		}else {
			return true;
		}
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
	public User getUserById(Long user_id) {
		boolean opt = repo.existsById(user_id);
		if(opt == false) {
			throw new UserNotFoundException();
		}
		return repo.findById(user_id).get();
	}

}
