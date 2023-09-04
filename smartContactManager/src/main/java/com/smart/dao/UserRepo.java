package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select * from user u where u.email = :email")
	public User getUserByUserName(@Param("email") String email);
}
