package com.main.dao;

import com.main.model.Admin;

/**
 * @author venkanna chowdary penubothu
 *
 */
public interface AdminDao {
	public void saveAdmin(Admin admin);

	public Admin fetchAdminById(long id);
}
