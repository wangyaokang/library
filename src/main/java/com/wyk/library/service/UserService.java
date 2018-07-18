/**
 * 
 */
package com.wyk.library.service;

import com.wyk.library.model.User;
import com.wyk.framework.service.BaseService;

public interface UserService extends BaseService<User> {

	public User getAnonymous();
	
}
