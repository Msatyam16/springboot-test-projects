package com.rest.example.dao;

import org.springframework.data.repository.CrudRepository;
import com.rest.example.entity.BookMdl;

public interface BookRepo extends CrudRepository<BookMdl, Integer> {
	public BookMdl findById(int id);
}
