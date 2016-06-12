package com.grocerystore.repository;

import com.grocerystore.domain.Category;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CategoryDao extends Repository<Category, Byte> {

	List<Category> findAll();
	
}
