package com.main.dao;

import com.main.model.Manager;

/**
 * @author venkanna chowdary penubothu
 *
 */
public interface ManagerDao {
	public void saveManager(Manager manager);

	public Manager fetchManagerById(long id);
}
