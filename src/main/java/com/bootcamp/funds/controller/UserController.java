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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.funds.exceptions.UserNotFoundException;
import com.bootcamp.funds.model.User;
import com.bootcamp.funds.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.showAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestParam(name = "id") Long user_id, @RequestBody User user){
		if(userService.getUserById(user_id) == null) {
			throw new UserNotFoundException();
		}
		User u = userService.updateUser(user);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserById/{user_id}")
	public ResponseEntity<User> getUser(@PathVariable Long user_id){
		return new ResponseEntity<User>(userService.getUserById(user_id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{user_id}")
	public ResponseEntity<User> removeUser(@PathVariable Long user_id){
		userService.deleteUserById(user_id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	

}
