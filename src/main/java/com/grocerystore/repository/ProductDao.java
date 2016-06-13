package com.grocerystore.repository;

import com.grocerystore.domain.Product;
import org.springframework.data.repository.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends Repository<Product, Integer> {
	
	List<Product> findByCategoryId(Byte id);
	
	Product findOne(Integer id);
        void save(Product a);
        
        public List<Product> findAll();
}
