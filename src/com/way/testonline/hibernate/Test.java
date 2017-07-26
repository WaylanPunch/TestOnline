package com.way.testonline.hibernate;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "A")
	private String A;
	
	@Column(name = "B")
	private String B;
	
	@Column(name = "C")
	private String C;
	
	@Column(name = "D")
	private String D;
	
	//@Basic是抓取策略
    //JoinColum要与Course中对应
	@ManyToOne
	@JoinColumn(name = "course_ID")
	@Basic(fetch = FetchType.LAZY)
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourseID(Course course) {
		this.course = course;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
