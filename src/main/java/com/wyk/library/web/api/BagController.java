package com.wyk.library.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyk.library.annotation.Logined;
import com.wyk.library.model.Bag;
import com.wyk.library.model.Book;
import com.wyk.library.model.User;
import com.wyk.library.service.BagService;
import com.wyk.library.web.api.param.Input;
import com.wyk.library.web.api.param.Output;

@Controller("apiBag")
@RequestMapping(value="/api/bag")
public class BagController extends AbstractController {
	
	@Autowired
	public BagService bagService;
	
	/**
	 * 
	 * 查询用户所借书籍信息
	 * 
	 * <pre>
	 * method : queryBags
	 * token : 当前TOKEN信息
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output queryBags(Input input){
		Output result = new Output();
		List<Bag> bags = bagService.queryBagByUser(input.getCurrentUser());
		
		if(bags.size() == 0){
			result.setMsg("没有放入任何书籍");
			result.setStatus(SUCCESS);
		}
		result.setMsg("查询成功");
		result.setData(bags);
		result.setStatus(SUCCESS);
		return result;
	}

	/**
	 * 
	 * 添加书籍至书包
	 * 
	 * <pre>
	 * method : addBook2Bag
	 * token : 当前TOKEN信息
	 * params : {"bookId" : "xxxxx"}
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output addBook2Bag(Input input){
		Output result = new Output();
		if(StringUtils.isEmpty(input.getLong("bookId"))){
			result.setMsg("未选择任何书籍");
			result.setStatus(SUCCESS);
		}
		User user = input.getCurrentUser();
		Book book = new Book();
		book.setId(input.getLong("bookId"));
		
		Bag bag = new Bag();
		bag.setUser(user);
		bag.setBook(book);
		bagService.insert(bag);
		result.setData(bag);
		result.setMsg("添加书籍成功");
		result.setStatus(SUCCESS);
		return result;
	}
}
