package com.bootcamp.funds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.funds.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
