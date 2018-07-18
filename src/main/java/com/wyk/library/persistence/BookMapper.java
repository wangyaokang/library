package com.wyk.library.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wyk.framework.mybatis.BaseMapper;
import com.wyk.library.model.Book;

@Repository
public interface BookMapper extends BaseMapper<Book> {
	public List<Book> queryBooksByMap(Map<String, Object> map);
}
