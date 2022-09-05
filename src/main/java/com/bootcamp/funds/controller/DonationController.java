package com.bootcamp.funds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.funds.dto.DonationDto;
import com.bootcamp.funds.service.DonationServiceImpl;

@RestController
@RequestMapping("/post/{postId}")
public class DonationController {
	
	@Autowired
	DonationServiceImpl donationService;
	
	@PostMapping("/donate")
	public ResponseEntity<DonationDto> makeDonation(@PathVariable Long postId, @RequestBody DonationDto dto){
		DonationDto donationDto = donationService.donate(postId, dto);
		return new ResponseEntity<DonationDto>(donationDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/viewalldonations")
	public ResponseEntity<List<DonationDto>> showAllDonations(@PathVariable Long postId){
		return new ResponseEntity<List<DonationDto>>(donationService.viewAllDonations(postId), HttpStatus.OK);
	}
	
	@GetMapping("/donation/{donationId}")
	public ResponseEntity<DonationDto> viewDonationById(@PathVariable Long postId, @PathVariable Long donationId){
		return new ResponseEntity<DonationDto>(donationService.viewDonation(postId, donationId), HttpStatus.OK);
	}

}
