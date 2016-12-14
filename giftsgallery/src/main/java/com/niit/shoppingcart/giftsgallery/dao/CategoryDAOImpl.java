package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.UserInfo;

@Repository (value= "categoryDAO")
/*@EnableTransactionManagement*/
public class CategoryDAOImpl implements CategoryDAO {

	
	
	     /*@Autowired*/
	   SessionFactory sessionfactory;
	
    public CategoryDAOImpl(SessionFactory sessionfactory) 
      {
		super();
		this.sessionfactory=sessionfactory;
		// TODO Auto-generated constructor stub
	  }
	
	
	
	
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}


	@Transactional

	public List<Category> list() {

/*		String hql = "from Category";
		Session s = sessionfactory.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Category> all = query.list();
		tx.commit();
		return all;*/
		System.out.println("nill");
		String hql = "from Category";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		System.out.println(hql);

		return query.list();

	}
	
	 @Transactional
	   
	public boolean saveOrUpdate(Category category) {
		 Session s=sessionfactory.getCurrentSession();
		 Transaction t=s.beginTransaction();
		 s.saveOrUpdate(category);
		 t.commit();
		 return true;
	}

	
	
	 
	 /*@Transactional*/
	public Category get(String name) {
		
            Session s = sessionfactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			String hql = "from Category where cat_name=" + "'" + name + "'";
			org.hibernate.Query query = s.createQuery(hql);
			List<Category> list = query.list();
			tx.commit();
			if (list == null || list.isEmpty()) {
				return null;
			} else {
				System.out.println("gets catogory in impl");
				return list.get(0);

			}

		
	}
}
