package com.vinxent.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vinxent.action.LoginAction;

public class MyInterceptor extends AbstractInterceptor {

	/**
	 * 这是一个测试，测试 AbstractInterceptor
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		LoginAction loginAction = (LoginAction)invocation.getAction();
		System.out.println("---start----");
		String result = invocation.invoke();
		System.out.println(loginAction.getUsername());
		System.out.println(loginAction.getPassword());
		System.out.println("---end----");
		return result;
	}

}
