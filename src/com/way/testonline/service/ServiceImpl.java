package com.way.testonline.service;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.way.testonline.dao.IDao;
import com.way.testonline.hibernate.Student;
import com.way.testonline.hibernate.Test;
/*
 * @service标注业务层组件
 * @Transactional标注事务管理
 * 
 */

@Service("IService")
@Transactional(readOnly = false)
public class ServiceImpl implements IService {

	@Resource(name = "IDao")
	private IDao dao;

	// 设值注入
	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	// 重写方法
	@Override
	public Student checkname(String name) {
		Student str = this.dao.checkname(name);
		return str;
	}

	// 重写方法
	@Override
	public List<Test> findtest(String course, int pageNow, int pageSize) {
		List<Test> list = this.dao.findtest(course, pageNow, pageSize);
		return list;
	}

	@Override
	public Test checkanswer(int s) {
		Test t = this.dao.checkanswer(s);
		return t;
	}

}
