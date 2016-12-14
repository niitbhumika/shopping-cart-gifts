package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.Supplier;
		
@Repository
public interface CategoryDAO
{
	
	public boolean saveOrUpdate(Category category);
	public boolean delete(Category category);
	public Category get(String name);
	public List<Category> list();	
	
	
}
