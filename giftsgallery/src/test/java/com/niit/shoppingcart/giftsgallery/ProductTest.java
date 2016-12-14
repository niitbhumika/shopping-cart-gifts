package com.niit.shoppingcart.giftsgallery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.giftsgallery.dao.ProductDAO;
import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Supplier;

public class ProductTest {

	static AnnotationConfigApplicationContext context;
	
	public static void main(String[] args)
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		Product product=(Product) context.getBean("product");
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		Category cat= new Category();
		Supplier sup=new Supplier();
		
		
		product.setProd_name("flowers52");
		product.setQuantity(1);
		product.setProd_price(1);
		product.setCat_id(1);
		product.setSup_id(1);
		
		/*product.setProd_name("Gifts");
		product.setCat_id(1);
		product.setProd_id(1);
		product.setProd_price(120);
		product.setQuantity(1);*/
		
		
		
		
		productDAO.saveOrUpdate(product);
		System.out.println("product created test");

	}

	}
