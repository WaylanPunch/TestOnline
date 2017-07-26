package com.way.testonline.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.way.testonline.hibernate.Student;
import com.way.testonline.hibernate.Test;

/*
 * @Repository表示持久层
 * @Autowired在配置文件中配置的生成sessionFactory的注解
 * 
 */
@Repository("IDao")
@Transactional(readOnly = false)
public class DaoImpl implements IDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public Student checkname(String name) {

		List<Student> stu = new ArrayList<Student>();
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		// 执行hql语句并将结果转化成Student类型的list集合
		Query<Student> query = session.createQuery("from Student where name=?").setParameter(0, name);
		stu = query.list();
		System.out.println(stu);
		// 返回符合条件的Student的信息
		if (stu.size() != 0) {
			return stu.get(0);
		} else {
			return null;
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Test> findtest(String course, int pageNow, int pageSize) {

		Map session1 = ActionContext.getContext().getSession();
		Session session = sessionFactory.getCurrentSession();

		// 执行原生的SQL语句，数据库分页查询
		Query<Test> query = session
				.createSQLQuery("select t.ID,t.title,t.A,t.B,t.C,t.D from test as t," + "course as c where c.course='"
						+ course + "' and c.ID=t.course_ID limit " + pageNow + "," + pageSize + "");

		// 将结果集注入到实体类Test的Bean中
		query.setResultTransformer(Transformers.aliasToBean(Test.class));

		// 类型转换
		@SuppressWarnings("unchecked")
		//List<Test> list = (List<Test>) query.getResultList();//.list();
		//List<Test> list = (List<Test>) query.list();
		//List<Test> list = query.getResultList();//.list();
		List<Test> list = query.list();

		
//		List<Object[]> queryList = query.list();
//		List<Test> list = new ArrayList<>();
//		if (queryList != null) {
//			for (int i = 0; i < queryList.size(); i++) {
//				Object[] objects = queryList.get(i);
//				Test test = new Test();
//				test.setId(Integer.parseInt(objects[0].toString()));
//				test.setTitle(objects[1].toString());
//				test.setA(objects[2].toString());
//				test.setB(objects[3].toString());
//				test.setC(objects[4].toString());
//				test.setD(objects[5].toString());
//				list.add(test);
//			}
//		}

		System.out.println("pageNow3=" + pageNow);
		System.out.println("pageNow4=" + pageNow);
		System.out.println(list.get(0).getA());

		return list;

	}

	@SuppressWarnings("deprecation")
	@Override
	public Test checkanswer(int s) {
		List<Test> t = new ArrayList<Test>();
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		// 执行hql语句并将结果转化成Test类型的list集合
		Query<Test> query = session.createSQLQuery("select answer from test where ID=? ").setParameter(0, s);
		query.setResultTransformer(Transformers.aliasToBean(Test.class));
		t = query.list();
		// 返回符合条件的Test的信息
		if (t.size() != 0) {
			return t.get(0);
		} else {
			return null;
		}
	}

}