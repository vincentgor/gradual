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
	 * ����ǰ��Ҫ���أ��� �����ꡱ ����
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ValueStack valueStack = invocation.getInvocationContext().getValueStack();
		invocation.addPreResultListener(new MyListener());
		Object object = invocation.getAction();
		if (object !=null) {
			if (object instanceof PublicAction) {    //����Ƿ������µĻ�
				PublicAction action = (PublicAction)invocation.getAction();
				String title = ServletActionContext.getRequest().getParameter("title");
				String content = ServletActionContext.getRequest().getParameter("content");
				if (title.length()>=12) {
					invocation.getInvocationContext().put("tip", "���ⲻ�ܴ���12����");
					System.out.println("���ⲻ�ܴ���12����");
					return invocation.invoke();
				}
				if (content.contains("����") || title.contains("��")) {
					content = content.replace("����", "(���ﱻ��г������)");
					title = title.replace("��", "(���ﱻ��г������)");
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
			} else {    //���Ƿ����£�ֱ������
				return Action.LOGIN;
			}
		}
		return Action.LOGIN;
	}

}
