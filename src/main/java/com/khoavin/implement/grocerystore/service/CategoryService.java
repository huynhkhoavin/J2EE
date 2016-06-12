package com.khoavin.implement.grocerystore.service;

import com.khoavin.implement.grocerystore.repository.CategoryDao;
import com.khoavin.implement.grocerystore.domain.Category;
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
