package com.bootcamp.funds.service;

import java.util.List;

import com.bootcamp.funds.dto.PostDto;

public interface PostService {
	public PostDto createPost(String username, PostDto dto);
	public PostDto updatePost(String username, Long postId, PostDto dto);
	public String deletePost(String username, Long postId);
	public List<PostDto> getAllPosts();

}
