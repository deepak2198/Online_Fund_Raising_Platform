package com.bootcamp.funds.service;

import com.bootcamp.funds.dto.CommentDto;

public interface CommentService {
	
	public CommentDto createComment(Long postId, CommentDto dto);
	public CommentDto updateComment(Long postId, Long commentId, CommentDto dto);
	public String deleteCommentById(Long postId, Long commentId);

}
