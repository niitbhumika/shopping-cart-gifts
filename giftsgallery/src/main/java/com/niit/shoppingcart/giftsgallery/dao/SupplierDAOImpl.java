package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Supplier;



@Repository (value= "supplierDAO")
/*@EnableTransactionManagement*/
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	Supplier supplier;
	
	/*@Autowired
	SupplierDAO supplierDAO;*/
	
	
        public SupplierDAOImpl() {
		super();
		
		// TODO Auto-generated constructor stub
	}
        public SupplierDAOImpl(SessionFactory sessionfactory)
    	{
    		super();
    		this.sessionFactory= sessionfactory;
    		
    	}

	public boolean saveOrUpdate(Supplier supplier) {
		try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(supplier);
			System.out.println("adding supplier  impl");
			
			t.commit();

			// sessionFactory.getCurrentSession().save(supplier);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	
	public List<Supplier> list() {
		
		
			String hql = "from Supplier";
			Session s = sessionFactory.getCurrentSession();
			/*Transaction tx = s.beginTransaction();*/
			org.hibernate.Query query = s.createQuery(hql);
			List<Supplier> all=query.list();
			System.out.println("supplier list in impl");
			/*tx.commit();*/
			return all;
		}
		
	

	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public Supplier get(String name) {
	
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			String hql = "from Supplier where supplier_name="+"'"+name+"'";
			org.hibernate.Query query = s.createQuery(hql);
			List<Supplier> list=query.list();
			tx.commit();
			if(list==null || list.isEmpty())
			{return null;}
			else{
				System.out.println("getting supplier det. by name");

				return list.get(0);
			}

	}
}


