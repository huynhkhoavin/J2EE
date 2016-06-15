package com.grocerystore.repository;

import com.grocerystore.domain.CustomerOrder;
import com.grocerystore.domain.OrderedProduct;
import com.grocerystore.domain.OrderedProductId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderedProductDao extends JpaRepository<OrderedProduct, OrderedProductId> {
	@Query("select c from Product c")
        List<Object[]> getProduct();
        
        @Query("select p.name, p.price, o.quantity from OrderedProduct o, Product p where((o.product = p.id) and (o.customerOrder = ?1))")
        List<Object[]> getOrderProduct(CustomerOrder order);
}
