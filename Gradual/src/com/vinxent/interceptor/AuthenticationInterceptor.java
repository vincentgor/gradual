package com.vinxent.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticationInterceptor extends AbstractInterceptor {

	/**
	 * �ж��û��Ƿ��Ѿ���¼
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Map session = invocation.getInvocationContext().getSession();
		Object user = session.get("user");
		if (user==null) {
			ActionSupport action = (ActionSupport)invocation.getAction();
			action.addActionError("�㻹û�е�¼������");
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
