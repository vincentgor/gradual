package com.vinxent.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MethodInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String excludeMethods;
	private String includeMethods;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		setExcludeMethods(excludeMethods);
		setIncludeMethods(includeMethods);
		return null;
	}

}
