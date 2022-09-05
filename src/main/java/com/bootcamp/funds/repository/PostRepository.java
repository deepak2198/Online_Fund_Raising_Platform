package com.bootcamp.funds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.funds.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	List<Post> findByUserId(long userId);

}
