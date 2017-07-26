package com.way.testonline.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.way.testonline.hibernate.Test;
import com.way.testonline.service.*;

/*
 * 前面的注解和注入基本与LoginAction相同
 * 
 */
@Controller("choose")
@Scope("prototype")
public class ChoeseCourseAction {

	@Resource(name = "IService")
	private IService service;

	private int pageNow = 0; // 初始页为第一页
	private int pageSize = 1; // 每页数据为1条，可调节

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();

	Map<String, Object> session4 = ActionContext.getContext().getSession();
	String ret = null;

	/*
	 * 课程选择方法 选择课程后跳转到对应的题目
	 */
	public String choose() {
		Map<String, Object> session1 = ActionContext.getContext().getSession();// 存储结果集
		Map<String, Object> session2 = ActionContext.getContext().getSession();// 存储testID，用于检查正确答案
		Map<String, Object> session3 = ActionContext.getContext().getSession();// 存储课程，保证课程不会改变
		Map<String, Object> session4 = ActionContext.getContext().getSession();// 保存当前题目的页数

		// 接收数据
		String co = request.getParameter("course");
		String page = request.getParameter("pageNow");
		if (page == null) {
			pageNow = 0;
		} else {
			pageNow = Integer.parseInt(page);
		}
		List<Test> list = new ArrayList<Test>();
		try {
			// 根据课程查找试题
			list = this.service.findtest(co, pageNow, pageSize);
			// 如果查询结果是null，则意味着题目以及做完了
			if (list == null) {
				ret = "over";
			} else {
				session4.put("pageNow", pageNow + 1);
				// 将试题放入session,便于前台取用显示
				session1.put("list", list.get(0));
				session2.put("testID", list.get(0).getId());
				session3.put("course", co);

				ret = "success";
			}

		} catch (Exception e) {
			System.out.println(e);
			ret = "error";
		}
		return ret;
	}

	/*
	 * 检查答案，正确返回success 错误返回error并将正确答案显示
	 * 
	 */
	public String checkanswer() {
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		String ret = "error";
		// 得到我们在上面取出 的testID
		int s = (int) session.getAttribute("testID");
		try {
			String answer = request.getParameter("answer");// 得到用户选择的答案
			// 取出正确答案
			Test t = this.service.checkanswer(s);
			session1.put("answer", t.getAnswer());
			// 验证֤
			if (answer != null) {
				if (t.getAnswer().equals(answer)) {
					ret = "success";
				}
			} else {
				ret = "error";
			}
		} catch (Exception e) {
			System.out.println(e);
			ret = "error";
		}
		return ret;
	}
}
