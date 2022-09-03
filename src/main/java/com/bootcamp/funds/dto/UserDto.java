package com.bootcamp.funds.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.bootcamp.funds.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String emailId;
	private String password;
	
	private List<Comment> comments;
	
}
