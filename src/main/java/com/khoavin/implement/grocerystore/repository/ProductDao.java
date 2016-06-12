package com.khoavin.implement.grocerystore.repository;

import com.khoavin.implement.grocerystore.domain.Product;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductDao extends Repository<Product, Integer> {
	
	List<Product> findByCategoryId(Byte id);
	
	Product findOne(Integer id);
	
}
