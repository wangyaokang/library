/**
 * 
 */
package com.wyk.library.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wyk.library.model.User;
import com.wyk.framework.util.MD5Util;
import com.wyk.framework.web.BaseController;

@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController<User> {
	
	protected Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, Object> params){
		ModelAndView model = new ModelAndView();
		String username = params.get("username").toString();
		String password = params.get("pwd").toString();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", username);
		User user = (User) service.get(map);
		if(user == null){
			model.setViewName("login");
			model.addObject("username", username);
			model.addObject("pwd", password);
			model.addObject(MSG, "用户未注册！");
		}else if(!MD5Util.stringToMD5(password).equals(user.getPassword())){
			model.setViewName("login");
			model.addObject("username", username);
			model.addObject("pwd", password);
			model.addObject(MSG, "密码错误！");
		}else{
			model.setViewName("user_info");
			model.addObject(MSG, "登录成功！");
			model.addObject("user", user);
		}
		
		return model;
	}
}