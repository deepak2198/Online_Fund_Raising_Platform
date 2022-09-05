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

import com.bootcamp.funds.dto.PostDto;
import com.bootcamp.funds.service.PostServiceImpl;

@RestController
@RequestMapping("/user/{userId}")
public class PostController {
	
	@Autowired
	PostServiceImpl postService;
	
	@PostMapping("/addPost")
	public ResponseEntity<String> addPost(@PathVariable Long userId, @RequestBody PostDto dto){
		postService.createPost(userId, dto);
		return new ResponseEntity<String>("Post created successfully by the user having ID:: "+userId, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllPosts")
	public ResponseEntity<List<PostDto>> getAllPosts(@PathVariable Long userId){
		return new ResponseEntity<List<PostDto>>(postService.getAllPosts(userId), HttpStatus.OK);
	}
	
	@GetMapping("/getPost/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Long userId, @PathVariable Long postId){
		return new ResponseEntity<PostDto>(postService.getPostById(userId, postId), HttpStatus.OK);
	}
	
	@PutMapping("/updatePost/{postId}")
	public ResponseEntity<PostDto> updatePost(@PathVariable Long userId, @PathVariable Long postId, @RequestBody PostDto dto){
		return new ResponseEntity<PostDto>(postService.updatePost(userId, postId, dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePost/{postId}")
	public ResponseEntity<String> DeletePostById(@PathVariable Long userId, @PathVariable Long postId){
		postService.deletePostById(userId, postId);
		return new ResponseEntity<String>("Post with ID:: "+postId+" deleted successfully", HttpStatus.OK);
	}

}
