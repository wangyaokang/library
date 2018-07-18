/**
 * 
 */
package com.wyk.library.web.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wyk.library.annotation.Logined;
import com.wyk.library.model.User;
import com.wyk.library.web.api.param.Input;
import com.wyk.library.web.api.param.Output;

/**
 * 
 * 个人相关接口
 * 
 */
@Controller("apiUser")
@RequestMapping("/api/user")
public class UserController extends AbstractController {

	/**
	 * 获得当前用户的个人信息
	 * <p>
	 * 传入参数：
	 * </p>
	 * 
	 * <pre>
	 * method:info
	 * token:当前TOKEN信息
	 * </pre>
	 * 
	 * @param input
	 * @return
	 */
	@Logined
	public Output info(Input input) {
		Output result = new Output();
		result.setStatus(SUCCESS);
		result.setMsg("获得个人信息");
		result.setData(input.getCurrentUser());
		return result;
	}

	/**
	 * 修改个人信息
	 * <p>
	 * 传入参数：
	 * </p>
	 * 
	 * <pre>
	 * method:modify
	 * token:当前TOKEN信息
	 * params:{当前所有信息JSON格式}
	 * </pre>
	 * 
	 * @param input
	 * @return
	 */
	@Logined
	public Output modify(Input input) {
		Output result = new Output();
		User user = input.getCurrentUser();
		user.setName(input.getString("name"));
		user.setNickname(input.getString("nickname"));
		user.setSex(input.getInteger("sex"));
		userService.update(user);
		result.setStatus(SUCCESS);
		result.setMsg("个人信息修改成功");
		result.setData(user);
		return result;
	}
	
	/**
	 * 上传图片
	 * <p>
	 * 传入参数
	 * </p>
	 * 
	 * <pre>
	 * method : uploadImage
	 * token : 当前TOKEN信息
	 * params : {"filePath" : "d://xx.jpg"}
	 * </pre>
	 * 
	 * 
	 * @param input
	 * @return
	 */
	@Logined
	public Output uploadPhoto(Input input) {
		Output result = new Output();
		User user = input.getCurrentUser();
		String filePath = input.getString("filePath");
		File file = new File(filePath);
		try {
			FileInputStream inputStream = new FileInputStream(file);
			MultipartFile multipartFile = new MockMultipartFile(file.getName(), filePath, "jpg", inputStream);
			String protraitUrl = uploadImage(multipartFile);
			user.setProtraitUrl(protraitUrl);
		} catch (IOException e) {
			result.setMsg("头像上传失败");
		} 
		userService.update(user);
		result.setStatus(SUCCESS);
		result.setMsg("头像上传成功");
		result.setData(user);
		return result;
	}

}
