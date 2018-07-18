package com.wyk.library.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyk.framework.web.BaseController;
import com.wyk.library.model.Book;
import com.wyk.library.service.impl.BookServiceImpl;

@Controller
@RequestMapping("book")
public class BookController extends BaseController<Book> {
	
	@Autowired
	public BookServiceImpl bookService;
	
	@RequestMapping(value = "/queryBook.json", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> query(String bookNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		String str = bookService.getNum(bookNo);
		result.put("result", str);
		return result;
	}
}
