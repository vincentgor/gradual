/*
 * ִ����action����ʱִ�иü�����
 */
package com.vinxent.listener;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class MyListener implements PreResultListener {

	@Override
	public void beforeResult(ActionInvocation invocation, String resultCode) {
		// TODO Auto-generated method stub
		System.out.println(resultCode);
	}

}
