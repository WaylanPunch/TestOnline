package com.way.testonline.dao;

import java.util.List;

import com.way.testonline.hibernate.Student;
import com.way.testonline.hibernate.Test;

public interface IDao {
	
	Student checkname(String name);// 查找学生信息

	List<Test> findtest(String course, int pageNow, int pageSize);// 查找试题

	Test checkanswer(int s);// 查找答案
	
}
