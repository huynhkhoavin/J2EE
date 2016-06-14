package com.grocerystore.repository;

import com.grocerystore.domain.CustomerOrder;
import org.springframework.data.repository.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface OrderDao extends Repository<CustomerOrder, Integer> {
		
	List<CustomerOrder> findAll();
	
	CustomerOrder save(CustomerOrder order);
        
        @Query("select c from CustomerOrder c where c.confirmationNumber = ?1")
        CustomerOrder findByConfNumber(int ConfiNumber);
        
        @Query("select c from CustomerOrder c")
        List<CustomerOrder> findabc();
	
}
