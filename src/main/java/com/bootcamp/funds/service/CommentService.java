package com.bootcamp.funds.service;

import java.util.List;

import com.bootcamp.funds.dto.CommentDto;

public interface CommentService {
	
	public CommentDto createComment(Long postId, CommentDto dto);
	public CommentDto updateComment(Long postId, Long commentId, CommentDto dto);
	public String deleteCommentById(Long postId, Long commentId);
	public CommentDto getCommentById(Long postId, Long commentId);
	public List<CommentDto> getAllComments(Long postId);

}
