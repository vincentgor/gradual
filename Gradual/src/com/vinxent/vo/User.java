package com.vinxent.vo;

public class User {
	private int id;  //用户id
	private String name;   //用户名
	private String password;   //密码
	private boolean is_delete;  //是否已经删除
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	public int getId() {
		return id;
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
