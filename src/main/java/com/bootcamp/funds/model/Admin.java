package com.bootcamp.funds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "admin_Table")
@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	
	@Column(name = "Admin_name")
	@NotNull(message = "Admin Name should not be empty")
	private String adminName;
	
	@Column(name = "Admin_email")
	@NotNull(message = "Admin email should not be empty")
	private String emailId;
	
	@Column(name = "Admin_password")
	@NotNull(message = "Admin password should not be empty")
	private String password;

}
