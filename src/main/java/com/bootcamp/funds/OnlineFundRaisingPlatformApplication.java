package com.bootcamp.funds;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class OnlineFundRaisingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFundRaisingPlatformApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
	    modelMapper.getConfiguration()
	        .setMatchingStrategy(MatchingStrategies.STRICT);
	    return modelMapper;
	}

}
