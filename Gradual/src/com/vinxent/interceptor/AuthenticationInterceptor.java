package com.vinxent.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticationInterceptor extends AbstractInterceptor {

	/**
	 * 判断用户是否已经登录
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Map session = invocation.getInvocationContext().getSession();
		Object user = session.get("user");
		if (user==null) {
			ActionSupport action = (ActionSupport)invocation.getAction();
			action.addActionError("你还没有登录啊，亲");
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
