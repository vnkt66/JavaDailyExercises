package com.main.service;

import com.main.model.Admin;

/**
 * @author venkanna chowdary penubothu
 *
 */
public interface AdminService {
	public void saveAdmin(Admin admin);

	public Admin fetchAdminById(long id);
}
