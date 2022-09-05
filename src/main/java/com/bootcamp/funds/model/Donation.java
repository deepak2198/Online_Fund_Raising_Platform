package com.bootcamp.funds.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter   @Setter
@Table(name="donation_table")
public class Donation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="donation_id")
	private long id;
	
	@Column(name="amount_donated")
	private double amount;
	
	@Column(name="donation_date")
	private LocalDate dateOfDonation;
	
	@Column(name="comments")
	private String comments;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "donation_post_id")
	private Post post;


}
