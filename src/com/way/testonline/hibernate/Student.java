package com.way.testonline.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @Entiy标识这是一个实体类
 * @Table表示在数据库中创建的表的名字
 * 
 */
@Entity
@Table(name = "student")
public class Student {
	private int id;

	private String name;

	private String password;

	// @Id表示该列是主键
	// @GeneratedValue表示主键生成策略
	// @Column是为列取别名，可以没有
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
