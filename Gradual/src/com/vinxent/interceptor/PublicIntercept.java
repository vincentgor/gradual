package com.vinxent.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.vinxent.action.PublicAction;
import com.vinxent.listener.MyListener;

public class PublicIntercept extends AbstractInterceptor {

	/**
	 * 发帖前需要拦截，如 “尼玛” 字眼
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ValueStack valueStack = invocation.getInvocationContext().getValueStack();
		invocation.addPreResultListener(new MyListener());
		Object object = invocation.getAction();
		if (object !=null) {
			if (object instanceof PublicAction) {    //如果是发表文章的话
				PublicAction action = (PublicAction)invocation.getAction();
				String title = ServletActionContext.getRequest().getParameter("title");
				String content = ServletActionContext.getRequest().getParameter("content");
				if (title.length()>=12) {
					invocation.getInvocationContext().put("tip", "标题不能大于12个字");
					System.out.println("标题不能大于12个字");
					return invocation.invoke();
				}
				if (content.contains("尼玛") || title.contains("靠")) {
					content = content.replace("尼玛", "(这里被和谐啦啦啦)");
					title = title.replace("靠", "(这里被和谐啦啦啦)");
					action.setTitleString(title);
					action.setContentString(content);
				}
				System.out.println("pre1:" + valueStack.findString("title"));
				valueStack.setValue("title", title);
				System.out.println("pre2:" + valueStack.findString("title"));
				String result = invocation.invoke();
				
				System.out.println("nex1:" + valueStack.findString("title"));
				valueStack.setValue("title", title);
				System.out.println("nex2:" + valueStack.findString("title"));
				
				
				return result;
			} else {    //不是发文章，直接跳过
				return Action.LOGIN;
			}
		}
		return Action.LOGIN;
	}

}
