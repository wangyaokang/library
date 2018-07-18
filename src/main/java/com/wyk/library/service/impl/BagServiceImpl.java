package com.wyk.library.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wyk.framework.service.impl.BaseServcieImpl;
import com.wyk.library.model.Bag;
import com.wyk.library.model.User;
import com.wyk.library.service.BagService;

@Service
public class BagServiceImpl extends BaseServcieImpl<Bag> implements BagService {

	@Override
	public List<Bag> queryBagByUser(User user) {
		if(user == null ){
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getId());
		map.put("mobile", user.getMobile());
		return mapper.queryByMap(map);
	}
	
}
