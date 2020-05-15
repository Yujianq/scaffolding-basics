package com.yujianq.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yujianq.entity.User;
import com.yujianq.entity.group.Create;
import com.yujianq.entity.group.Update;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author Yujianq
 * @description 用户接口
 *   注：@RestController
 *   		相当于 @Controller + @ResponseBody，只会返回数据且视图解析器无效
 *   	@Controller
 *   		可以使用视图解析器跳转相应页面
 * @date 2020-05-14 11:20
 */
@RestController
@RequestMapping("user")
public class UserController {

	/**
	 * 新增用户信息
	 * @param user
	 * 注：@Validated 
	 * 		可以用在类型、方法和方法参数上，但是不能用在成员属性（字段）上
	 * 		所属包为：org.springframework.validation.annotation 包下，是由 Spring 提供
	 * 		提供分组功能，提供验证排序功能
	 *    @Valid 
	 *    	可以用在方法、构造函数、方法参数和成员属性（字段）上
	 *    	所属包为：javax.validation，是由 JDK 提供
	 *    	不提供分组功能，不提供验证排序功能
	 */
	@PostMapping("save")
	public String saveUser(@RequestBody @Validated(Create.class) User user) {
		System.err.println(user);
		return "save success：" + user;
	}
	
	@PostMapping("update")
	public String updateUser(@Validated(Update.class) User user) {
		System.err.println(user);
		return "update success：" + user;
	}
	
	@ApiOperation("根据用户 ID 获取用户详细信息")
	@ApiImplicitParam(name = "uid", value = "用户 ID", required = true, dataType = "Long")
	@GetMapping("getUser/{uid}")
	public String getUserById(@PathVariable Long uid) {
		System.err.println(uid);
		return "uid ==> " + uid;
	}
	
}
