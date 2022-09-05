package com.bootcamp.funds.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "user_name", unique = true)
	@NotNull(message = "User Name should not be empty")
	private String username;
	
	@Column(name = "first_name")
	@NotNull(message = "First Name should not be empty")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
 
	@Column(name = "email_id")
	@NotNull(message = "emailId should not be empty")
	private String emailId;
	
	@Column(name = "password")
	@NotNull(message = "password should not be empty")
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> post = new HashSet<>();

}
