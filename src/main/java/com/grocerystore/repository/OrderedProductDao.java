package com.grocerystore.repository;

import com.grocerystore.domain.OrderedProduct;
import com.grocerystore.domain.OrderedProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductDao extends JpaRepository<OrderedProduct, OrderedProductId> {
	
}
