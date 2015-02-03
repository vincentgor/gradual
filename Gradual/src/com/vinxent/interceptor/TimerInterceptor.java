package com.vinxent.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.vinxent.listener.MyListener;

public class TimerInterceptor implements Interceptor {

	/**
	 * ʱ��������,����ͳ��actionִ�е�ʱ��
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		invocation.addPreResultListener(new MyListener());
		long startTime = System.currentTimeMillis();  //��ʼʱ��
		String result = invocation.invoke();  //ִ��action�ķ���
		long endTime = System.currentTimeMillis();
		System.out.println("Action��ִ�л��ѵĺ�����Ϊ��" + (endTime-startTime));
		return result;   //������Ӧ���
	}
}
