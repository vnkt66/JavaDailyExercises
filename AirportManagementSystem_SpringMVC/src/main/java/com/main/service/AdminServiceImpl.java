package com.main.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dao.AdminDao;

import com.main.model.Admin;

/**
 * @author venkanna chowdary penubothu This AdminServiceImpl contains methods
 *         that handles all admin user requests from controller and calls dao
 *         layer methods
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	private static final Logger log = Logger.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminDao adminDao;

	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
	}

	public Admin fetchAdminById(long id) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.fetchAdminById(id);
		return admin;
	}

}
