package com.niit.shoppingcart.giftsgallery.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.giftsgallery.model.UserInfo;

@Repository(value = "userDAO")
// @EnableTransactionManagement
public class UserDAOImpl implements UserDAO {

	@Autowired
	UserInfo userInfo;

	@Autowired
	private SessionFactory sessionFactory;

	public boolean isValidate(String id, String password) {
		if (id.equals("bhu@gmail.com") && password.equals("bhu"))

		{
			// b=true;
			return true;
		} else {
			return false;
		}
	}

	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionFactory = sessionfactory;
	}

	public List<UserInfo> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(UserInfo user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public boolean saveOrUpdate(UserInfo user) {

				try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(user);
			t.commit();
			// sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}


	}

	//@Transactional
	
	public UserInfo get(String name) {
		
		System.out.println("inside get method");
		Session s = sessionFactory.getCurrentSession();
		Transaction t = s.beginTransaction();
		// emailid col in tab .name is string
		String str = "From UserInfo where emailid='" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(str);
		List<UserInfo> ulist = query.list();

		if ((ulist != null) && ulist.isEmpty()) {
			System.out.println("fetch from user");
			t.commit();

		}

		return ulist.get(0);
	}
}