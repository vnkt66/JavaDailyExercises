package com.main.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.Manager;

/**
 * @author venkanna chowdary penubothu This ManagerDaoImpl contains methods that
 *         handles all manager user requests from service layer and stores in
 *         database
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {
	private static final Logger log = Logger.getLogger(ManagerDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveManager(Manager manager) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(manager);
	}

	@Override
	public Manager fetchManagerById(long id) {
		// TODO Auto-generated method stub
		Manager manager = (Manager) sessionFactory.getCurrentSession().get(Manager.class, id);
		return manager;
	}

}
