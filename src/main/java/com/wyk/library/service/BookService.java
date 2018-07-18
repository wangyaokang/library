package com.wyk.library.service;

import java.util.List;
import java.util.Map;

import com.wyk.framework.service.BaseService;
import com.wyk.library.model.Book;

public interface BookService extends BaseService<Book> {
	List<Book> queryBooksByMap(Map<String, Object> map);
}
