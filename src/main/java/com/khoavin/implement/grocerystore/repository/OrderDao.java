package com.khoavin.implement.grocerystore.repository;

import com.khoavin.implement.grocerystore.domain.CustomerOrder;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderDao extends Repository<CustomerOrder, Integer> {
		
	List<CustomerOrder> findAll();
	
	CustomerOrder save(CustomerOrder order);
	
}
