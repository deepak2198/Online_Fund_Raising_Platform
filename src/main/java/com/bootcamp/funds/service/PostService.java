package com.bootcamp.funds.service;

import java.util.List;

import com.bootcamp.funds.dto.PostDto;

public interface PostService {
	public PostDto createPost(Long userId, PostDto dto);
	public PostDto updatePost(Long userId, Long postId, PostDto dto);
	public String deletePostById(Long userId, Long postId);
	public PostDto getPostById(Long userId, Long postId);
	public List<PostDto> getAllPosts(Long userId);

}
