package com.yujianq.entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.yujianq.annotation.IdentityCardNumber;
import com.yujianq.entity.group.Create;
import com.yujianq.entity.group.Update;

import lombok.Data;

/**
 * @author Yujianq
 * @description 用户实体类
 * @date 2020-05-14 11:18
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户 ID
	 */
	@NotNull(message = "用户 ID 不能为空", groups = { Update.class })
	private Long uid;
	
	/**
	 * 昵称
	 * 注：@NotBlank 只能作用在 String 上，不能为 null，而且调用 trim() 后，长度必须大于 0
	 * 	  @NotEmpty 不能为 null，而且长度必须大于 0
	 * 	  @NotNull 不能为 null，但可以为 ''
	 */
	@NotBlank(message = "用户昵称不能为空", groups = { Create.class, Update.class })
	@Size(min = 2, max = 20, message = "用户昵称长度必须在2-20个字符之间")
	private String uname;
	
	/**
	 * 手机号码
	 */
	@NotBlank(message = "手机号码不能为空", groups = { Create.class, Update.class })
	@Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号码格式不正确")
	private String phone;
	
	/**
	 * 密码
	 */
	@NotBlank(message = "用户密码不能为空", groups = { Create.class, Update.class })
	@Size(min = 6, max = 20, message = "用户密码长度必须在6-20个字符之间")
	private String pwd;
	
	/**
	 * 邮箱
	 */
	@Email(message = "邮箱格式不正确", groups = { Create.class, Update.class })
	private String email;
	
	/**
	 * 身份证号码
	 */
	@IdentityCardNumber(message = "身份证号码不合法", groups = { Create.class, Update.class })
	private String idCard;
	
	/**
	 * 描述、备注信息
	 */
	private String desc;
	
	//.......
	
}