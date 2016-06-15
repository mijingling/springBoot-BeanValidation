package com.qz.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.qz.vo.validation.annotation.CheckPassword;
import com.qz.vo.validation.annotation.Forbidden;
import com.qz.vo.validation.groups.Add;
import com.qz.vo.validation.groups.Edit;

@CheckPassword()
public class UserVo implements Serializable {

	private static final long serialVersionUID = 734996817803080583L;

	// message，通过result.getFieldError().getDefaultMessage()获取，暂时未用到
	@NotNull(message = "notNull", groups = { Edit.class })
	private Integer id;
	// 自定义校验
	@NotBlank(message = "notBlank", groups = { Edit.class, Add.class })
	@Forbidden(message = "forbidden", groups = { Edit.class, Add.class })
	private String name;
	@NotBlank(message = "notBlank", groups = { Add.class })
	private String passwd;
	private String confirmation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
}
