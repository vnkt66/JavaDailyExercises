package com.main.service;

import com.main.model.Manager;

/**
 * @author venkanna chowdary penubothu
 *
 */
public interface ManagerService {
	public void saveManager(Manager manager);

	public Manager fetchManagerById(long id);
}
