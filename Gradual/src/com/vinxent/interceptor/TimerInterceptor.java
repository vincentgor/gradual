package com.vinxent.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.vinxent.listener.MyListener;

public class TimerInterceptor implements Interceptor {

	/**
	 * 时间拦截器,用来统计action执行的时间
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
		long startTime = System.currentTimeMillis();  //开始时间
		String result = invocation.invoke();  //执行action的方法
		long endTime = System.currentTimeMillis();
		System.out.println("Action的执行花费的毫秒数为：" + (endTime-startTime));
		return result;   //返回相应结果
	}
}
