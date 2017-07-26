package com.way.testonline.hibernate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	private String course;

	// @OneToMany映射关系
	// CascadeType为级联属性
	// @JoinColum为对应的多的一方的列
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "course_ID")
	private Set<Test> t = new HashSet<>();

	public Set<Test> getT() {
		return t;
	}

	public void setT(Set<Test> t) {
		this.t = t;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
