package com.grocerystore.service;

import com.grocerystore.repository.CategoryDao;
import com.grocerystore.domain.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CategoryService {

	@Resource
	private CategoryDao categoryDao;
	
	public List<Category> getAll() {
		return categoryDao.findAll();
	}
	
}
