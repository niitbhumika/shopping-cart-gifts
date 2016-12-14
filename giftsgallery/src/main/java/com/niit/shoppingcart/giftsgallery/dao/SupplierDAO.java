package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import com.niit.shoppingcart.giftsgallery.model.Supplier;


public interface SupplierDAO {
	public boolean saveOrUpdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String name);
	public List<Supplier> list();	

}
