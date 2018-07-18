package com.wyk.library.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.wyk.library.model.Book;
import com.wyk.library.service.BookService;
import com.wyk.library.web.api.param.Input;
import com.wyk.library.web.api.param.Output;

@Controller("apiBook")
@RequestMapping("/api/book")
public class BookController extends AbstractController {
	
	@Autowired
	public BookService bookService;
	
	/**
	 * 
	 * 添加书籍
	 * <p>
	 *  传入参数
	 * </p>
	 * 
	 * <pre>
	 * method : addBook
	 * params : {"bookNo" : "2018xxx", "bookName" : "xxx", "author" : "xxx", "publisher" : "xxxx", "synopsis" : "xxx"}
	 * </pre>
	 * @param input
	 * @return
	 */
	public Output addBook(Input input){
		Output result = new Output();
		Book book = bookService.get(input.getParams());
		if(null != book){
			result.setMsg("书籍编号已存在");
			result.setStatus(SUCCESS);
		}
		
		book = new Book();
		book.setBookNo(input.getString("bookNo"));
		book.setBookName(input.getString("bookName"));
		book.setAuthor(input.getString("author"));
		book.setPublisher(input.getString("publisher"));
		book.setSynopsis(input.getString("synopsis"));
		book.setLocation(input.getString("location"));
		bookService.insert(book);
		result.setData(book);
		result.setMsg("添加成功");
		return result;
	}

	/**
	 * 
	 * 获取书籍信息
	 * <p>
	 * 传入参数
	 * </p>
	 * 
	 * <pre>
	 * method : info
	 * params : {bookNo : "2018011801"}
	 * </pre>
	 * 
	 * @param input
	 * @return
	 */
	public Output info(Input input){
		Output result = new Output();
		Book book = bookService.get(input.getParams());
		if(null == book){
			result.setMsg("没有您要的书籍或书籍已下架");
			result.setStatus(SUCCESS);
			return result;
		}
		
		result.setData(book);
		result.setStatus(SUCCESS);
		result.setMsg("查询成功");
		return result;
	}
	
	/**
	 * 根据（作者、书名、摘要）查询
	 * <p>
	 * 	传入参数
	 * </p>
	 * 
	 * <pre>
	 * method : queryBooks
	 * params : {type : "0", key : "书名"}、{type : "1", key : "作者"}、 {type : "2", key : "出版社"}、{type : "3", key : "摘要"}
	 * </pre>
	 * @param intput
	 * @return
	 */
	public Output queryBooks(Input input){
		Output result = new Output();
		List<Book> books = bookService.queryBooksByMap(input.getParams());
		if(books.size() == 0){
			result.setMsg("没有搜索到您要的书籍");
			result.setStatus(SUCCESS);
		}
		
		result.setMsg("查询成功");
		result.setData(books);
		result.setStatus(SUCCESS);
		return result;
	}

}
















