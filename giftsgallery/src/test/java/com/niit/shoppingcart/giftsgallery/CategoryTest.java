package com.niit.shoppingcart.giftsgallery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.giftsgallery.dao.CategoryDAO;
import com.niit.shoppingcart.giftsgallery.model.Category;

public class CategoryTest {

static AnnotationConfigApplicationContext context;
	
	public static void main(String[] args)
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		Category category=(Category) context.getBean("category");
        category.getCat_id();
        category.setCat_description("price");
        category.setCat_name("watch");
        categoryDAO.saveOrUpdate(category);
		
}
}
