package com.jpa.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.example.mdl.UserModel;

public interface UserRepo extends CrudRepository<UserModel, Integer> {

	public List<UserModel> findByName(String name);

	public List<UserModel> findByNameAndCity(String name, String city);

//	@Query("select * from user_model")
//	public List<UserModel> getAllUser();

	// Mene isko native query bana ke chk kiya hai its working fine...
	@Query(value = "Select * from user_model u where u.name =:n and u.city=:c", nativeQuery = true)
	public List<UserModel> getAllUSerByNameAndCity(@Param("n") String name, @Param("c") String city);

	// This is a simple native query
	@Query(value = "select * from user_model", nativeQuery = true)
	public List<UserModel> getUsers();
}
