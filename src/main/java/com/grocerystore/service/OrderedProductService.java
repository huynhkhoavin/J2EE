package com.grocerystore.service;

import com.grocerystore.domain.CustomerOrder;
import com.grocerystore.domain.Product;
import com.grocerystore.domain.OrderedProduct;
import com.grocerystore.domain.OrderedProductId;
import com.grocerystore.repository.OrderedProductDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Transactional
public class OrderedProductService {

	@Resource
	private OrderedProductDao orderedProductDao;
	
	public void save(CustomerOrder order, Map<Product, Integer> items) {
		Set<Product> keys = items.keySet();
		Set<OrderedProduct> set = new HashSet<OrderedProduct>(0);
		for (Product key : keys) {
			int productId = key.getId();
			int orderId = order.getId();
			OrderedProductId orderedProductId = new OrderedProductId(orderId, productId);
			OrderedProduct orderedProduct = new OrderedProduct(orderedProductId, key, order, items.get(key).shortValue());
			set.add(orderedProduct);
		}
		orderedProductDao.save(set);
	}
        
//        public List<Object[]> getAllOrderDetails(Integer CustomerOrderID){
//            List<Object[]> hh = orderedProductDao.getOrderDetail(CustomerOrderID);
//            System.out.println(hh.size());
//            for(int i = 0; i < hh.size(); i++){
//                System.out.println(hh.get(i)[0]);
//                System.out.println(hh.get(i)[1]);
//                System.out.println(hh.get(i)[2]);
//            }
//            return hh;
//        }
        
        public List<Object[]> getAllProductOnOrder(CustomerOrder a){
            return orderedProductDao.getOrderProduct(a);
        }
	
}
