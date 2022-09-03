package com.bootcamp.funds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.funds.dto.UserDto;
import com.bootcamp.funds.exceptions.UserNotFoundException;
import com.bootcamp.funds.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return new ResponseEntity<List<UserDto>>(userService.showAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
		return new ResponseEntity<UserDto>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{user_id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long user_id, @RequestBody UserDto user){
		UserDto opt = userService.getUserById(user_id);
		if(opt == null) {
			throw new UserNotFoundException();
		}
		UserDto u = userService.updateUser(user_id, user);
		return new ResponseEntity<UserDto>(u, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserById/{user_id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long user_id){
		return new ResponseEntity<UserDto>(userService.getUserById(user_id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{user_id}")
	public ResponseEntity<UserDto> removeUser(@PathVariable Long user_id){
		userService.deleteUserById(user_id);
		return new ResponseEntity<UserDto>(HttpStatus.OK);
	}
	

}
