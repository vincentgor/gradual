package com.vinxent.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/*
	 * 暂时是硬编码
	 */
	public String execute() {
		ActionContext ctx = ActionContext.getContext();
		if(username.equals("vinxent") && password.equals("lsy9241")) {
			ctx.getSession().put("user", "vinxent");
			System.out.println("登录成功");
			return SUCCESS;
		}
		System.out.println("重新登录");
		ctx.put("tip", "你登录的用户名不正确，请重新登录！");
		return LOGIN;
	}
	
}
