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

import com.bootcamp.funds.dto.CommentDto;
import com.bootcamp.funds.service.CommentServiceImpl;

@RestController
@RequestMapping("/post/{postId}")
public class CommentController {
	
	@Autowired
	CommentServiceImpl commentService;
	
	@PostMapping("/addComment")
	public ResponseEntity<String> postComment(@PathVariable Long postId, @RequestBody CommentDto dto){
		commentService.createComment(postId, dto);
		return new ResponseEntity<String>("Comment Posted successfully" , HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllComments")
	public ResponseEntity<List<CommentDto>> getAllComments(@PathVariable Long postId){
		return new ResponseEntity<List<CommentDto>>(commentService.getAllComments(postId), HttpStatus.OK);
	}
	
	@GetMapping("/getComment/{commentId}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable Long postId, @PathVariable Long commentId){
		return new ResponseEntity<CommentDto>(commentService.getCommentById(postId, commentId), HttpStatus.OK);
	}
	
	@PutMapping("/updateComment/{commentId}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable Long commentId, @PathVariable Long postId, @RequestBody CommentDto dto){
		return new ResponseEntity<CommentDto>(commentService.updateComment(postId, commentId, dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteComment/{commentId}")
	public ResponseEntity<String> DeleteCommentById(@PathVariable Long commentId, @PathVariable Long postId){
		commentService.deleteCommentById(postId, commentId);
		return new ResponseEntity<String>("Comment with ID:: "+commentId+" deleted successfully", HttpStatus.OK);
	}

}
