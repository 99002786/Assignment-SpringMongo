package com.student.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "studentmongo")
@TypeAlias("Student")

public class Student {
	@Id
	Integer stid;
	String name;
	String dept;
	@Autowired
	Address address;
	
	public Student(Integer stid, String name, String dept, Address address) {
		super();
		this.stid = stid;
		this.name = name;
		this.dept = dept;
		this.address = address;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [stid=" + stid + ", name=" + name + ", dept=" + dept + ", address=" + address + "]";
	}
	

}
