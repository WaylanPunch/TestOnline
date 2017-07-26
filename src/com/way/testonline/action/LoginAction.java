package com.way.testonline.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.way.testonline.hibernate.Student;
import com.way.testonline.service.*;

/*
 *@Controller定义控制器
 *@Scope 标识作用域
 *@Resource 注入service
 * 
 */
@Controller("LoginAction")
@Scope("prototype")
public class LoginAction {

	@Resource(name = "IService")
	// 设值注入
	private IService service;

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();

	public String login() {
		// 接收action传过来的信息
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		try {
			// 判断用户名和密码是否为空
			if (name != null && pwd != null && !name.equals("") && !pwd.equals("")) {
				// 根据用户名查找student的信息
				Student stu = this.service.checkname(name);
				if (stu != null) {
					// 用户名和密码对应验证֤
					if (name.equals(stu.getName()) && pwd.equals(stu.getPassword())) {
						return "success";
					} else
						return "error";
				} else
					return "error";
			} else
				return "error";
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}

	}
}
