package com.wyk.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wyk.framework.service.impl.BaseServcieImpl;
import com.wyk.library.model.Book;
import com.wyk.library.persistence.BookMapper;
import com.wyk.library.service.BookService;

@Service
public class BookServiceImpl extends BaseServcieImpl<Book> implements BookService {

	@Autowired
	private BookMapper bookMpper;
	
	@Override
	public List<Book> queryBooksByMap(Map<String, Object> map) {
		if(null == map || map.isEmpty()){
			return null;
		}
		String type = (String) map.get("type");
		String key = (String) map.get("key");
		if("1".equals(type)){
			map.put("author", key);
		}else if("2".equals(type)){
			map.put("publisher", key);
		}else if("3".equals(type)){
			map.put("synopsis", key);
		}else{
			map.put("bookName", key);
		}
		
		return bookMpper.queryBooksByMap(map);
	}

	@Cacheable(value = "userCache", key = "bookNo")
	public String getNum(String bookNo){
		return System.currentTimeMillis() + "";
	}
}
