package com.bootcamp.funds.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.bootcamp.funds.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter   @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String description;
	private LocalDate createdOn;
	private String createdBy;
	
	//private User user;
	
	private Set<Comment> commentList = new HashSet<Comment>();

}
