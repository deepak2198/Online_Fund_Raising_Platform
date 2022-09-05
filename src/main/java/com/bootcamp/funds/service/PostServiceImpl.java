package com.bootcamp.funds.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bootcamp.funds.dto.PostDto;
import com.bootcamp.funds.exceptions.APIException;
import com.bootcamp.funds.exceptions.PostNotFoundException;
import com.bootcamp.funds.exceptions.UserNotFoundException;
import com.bootcamp.funds.model.Post;
import com.bootcamp.funds.model.User;
import com.bootcamp.funds.repository.PostRepository;
import com.bootcamp.funds.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public PostDto createPost(Long userId, PostDto dto) {
		Post post = mapper.map(dto, Post.class);
		
		// retrieve user entity by userId
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException());
        
        //set user to post entity
        post.setUser(user);
        
		Post newPost = postRepo.save(post);
		return mapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(Long userId, Long postId, PostDto dto){
		// retrieve user entity by id
		User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException());
		
		// retrieve post entity by id
		Post post = postRepo.findById(postId).orElseThrow(() -> new PostNotFoundException());
		
		if(!(post.getUser().getId() == user.getId())) {
			throw new APIException(HttpStatus.BAD_REQUEST, "post doesnot belongs to the user");
		}
		
		post.setDescription(dto.getDescription());
		post.setCreatedOn(dto.getCreatedOn());
		post.setCreatedBy(dto.getCreatedBy());
		
		Post updatedPost = postRepo.save(post);
		return mapper.map(updatedPost, PostDto.class);
	}

	@Override
	public String deletePostById(Long userId, Long postId){
		// retrieve user entity by id
		User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException());
				
		// retrieve post entity by id
		Post post = postRepo.findById(postId).orElseThrow(() -> new PostNotFoundException());
				
		if(!(post.getUser().getId() == user.getId())) {
			throw new APIException(HttpStatus.BAD_REQUEST, "post doesnot belongs to the user");
		}
		
		postRepo.delete(post);
		return "Post with ID:: "+postId+" deleted successfully";
	}

	@Override
	public PostDto getPostById(Long userId, Long postId) {
		// retrieve user entity by id
		User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException());
						
		// retrieve post entity by id
		Post post = postRepo.findById(postId).orElseThrow(() -> new PostNotFoundException());
						
		if(!(post.getUser().getId() == user.getId())) {
			throw new APIException(HttpStatus.BAD_REQUEST, "post doesnot belongs to the user");
		}
		
		return mapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPosts(Long userId) {
		List<Post> postData = postRepo.findByUserId(userId);
		
		return postData.stream().map(post -> mapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

}
