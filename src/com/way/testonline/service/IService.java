package com.way.testonline.service;

import java.util.List;

import com.way.testonline.hibernate.Student;
import com.way.testonline.hibernate.Test;

public interface IService {

	// LoginAction调用方法，用于查找student信息
	Student checkname(String name);

	// ChooseCourseAction调用方法，用于查找试题信息
	List<Test> findtest(String course, int pageNow, int pageSize);

	// 查找正确答案
	Test checkanswer(int s);

}
