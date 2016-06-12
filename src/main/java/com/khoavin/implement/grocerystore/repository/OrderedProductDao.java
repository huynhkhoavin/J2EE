package com.khoavin.implement.grocerystore.repository;

import com.khoavin.implement.grocerystore.domain.OrderedProduct;
import com.khoavin.implement.grocerystore.domain.OrderedProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductDao extends JpaRepository<OrderedProduct, OrderedProductId> {
	
}
