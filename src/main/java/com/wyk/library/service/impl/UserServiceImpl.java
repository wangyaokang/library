/**
 * 
 */
package com.wyk.library.service.impl;

import org.springframework.stereotype.Service;

import com.wyk.library.model.User;
import com.wyk.library.service.UserService;
import com.wyk.framework.service.impl.BaseServcieImpl;

@Service
public class UserServiceImpl extends BaseServcieImpl<User> implements UserService {

	/* (non-Javadoc)
	 * @see com.wyk.library.service.UserService#getAnonymous()
	 */
	@Override
	public User getAnonymous() {
		return User.Anonymous;
	}

}
