package com.bootcamp.funds.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String adminName;
	private String emailId;
	private String password;
	 

}

