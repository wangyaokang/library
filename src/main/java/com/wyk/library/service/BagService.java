package com.wyk.library.service;

import java.util.List;

import com.wyk.framework.service.BaseService;
import com.wyk.library.model.Bag;
import com.wyk.library.model.User;

public interface BagService extends BaseService<Bag> {
	
	/**
	 * 获取用户所借书籍
	 * @param user 
	 * @return
	 */
	public List<Bag> queryBagByUser(User user);
}
