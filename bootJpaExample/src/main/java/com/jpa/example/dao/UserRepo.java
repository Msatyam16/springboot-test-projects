package com.jpa.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.example.mdl.UserModel;

public interface UserRepo extends CrudRepository<UserModel, Integer> {

}
