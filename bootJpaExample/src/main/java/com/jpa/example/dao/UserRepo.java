package com.jpa.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.example.mdl.UserModel;

public interface UserRepo extends CrudRepository<UserModel, Integer> {

	public List<UserModel> findByName(String name);

}
