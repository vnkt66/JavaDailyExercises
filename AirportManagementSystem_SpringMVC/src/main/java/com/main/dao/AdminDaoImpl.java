package com.main.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.Admin;

/**
 * @author venkanna chowdary penubothu This AdminDaoImpl contains methods that
 *         handles all admin user requests from service layer and stores in
 *         database
 */
@Repository
public class AdminDaoImpl implements AdminDao {
	private static final Logger log = Logger.getLogger(AdminDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public Admin fetchAdminById(long id) {
		// TODO Auto-generated method stub
		Admin admin = (Admin) sessionFactory.getCurrentSession().get(Admin.class, id);
		return admin;
	}

	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(admin);
	}

}
