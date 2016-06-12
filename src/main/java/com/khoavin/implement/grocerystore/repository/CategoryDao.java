package com.khoavin.implement.grocerystore.repository;

import com.khoavin.implement.grocerystore.domain.Category;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CategoryDao extends Repository<Category, Byte> {

	List<Category> findAll();
	
}
