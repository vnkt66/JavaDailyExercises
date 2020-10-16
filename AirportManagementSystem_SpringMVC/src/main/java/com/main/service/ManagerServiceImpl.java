package com.main.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.model.Manager;
import com.main.dao.ManagerDao;

/**
 * @author venkanna chowdary penubothu This ManagerServiceImpl contains methods
 *         that handles all manager user requests from controller and calls dao
 *         layer methods
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
	private static final Logger log = Logger.getLogger(ManagerServiceImpl.class);

	@Autowired
	private ManagerDao managerDao;

	@Override
	public void saveManager(Manager manager) {
		// TODO Auto-generated method stub
		managerDao.saveManager(manager);
	}

	@Override
	public Manager fetchManagerById(long id) {
		// TODO Auto-generated method stub
		Manager manager = managerDao.fetchManagerById(id);
		return manager;
	}

}
