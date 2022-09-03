package com.bootcamp.funds.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.bootcamp.funds.dto.UserDto;
import com.bootcamp.funds.model.User;

@Component
public class UserConverter {
	
	public UserDto convertEntityToDto(User user) {
		ModelMapper mapper = new ModelMapper();
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}
	
	public User convertDtoToEntity(UserDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(dto, User.class);
		return user;
	}

}
