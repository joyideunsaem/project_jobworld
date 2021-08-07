package com.sboot.kaja.userVO;

public class UserVO {
	
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private String address;
	private String gender;
	private String email;
	
	public UserVO() {
	}

	public UserVO(String id , String pw , String name , int age , String address , String gender , String email) {
		this.address = address;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.id = id;
		this.name = name;
		this.pw = pw;
	}

	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
