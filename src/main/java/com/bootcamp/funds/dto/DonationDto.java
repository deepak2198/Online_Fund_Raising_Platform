package com.bootcamp.funds.dto;

import java.io.Serializable;

import com.bootcamp.funds.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonationDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private double amount;
	
	private Post post;
	
	
}