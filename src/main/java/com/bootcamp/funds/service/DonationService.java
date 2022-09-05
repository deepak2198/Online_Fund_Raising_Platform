package com.bootcamp.funds.service;

import java.util.List;

import com.bootcamp.funds.dto.DonationDto;

public interface DonationService {
	
	List<DonationDto> viewAllDonations(long postId);

    DonationDto viewDonation(long postId, long donationId);

    DonationDto donate(long postId, DonationDto donationDto);

}
