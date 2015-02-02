/*
 * ����һ���������֤������action�������¼����ܿ�������
 */

package com.vinxent.action;

import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class AuthorityDownAction implements Action {
	
	private String inputPath;   //Ҫ���ص�Ŀ���ļ�
	
	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	///���뷵��һ�� InputStream �Ľ������Ϊ ���ص������
	public InputStream getTargetFile() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);	
	}

	/*
	 * �����֤
	 */
	@Override
	public String execute() throws Exception {
		//ȡ��Actioncontextʵ��
		ActionContext ctx = ActionContext.getContext();
		//����HttpSession
		Map session = ctx.getSession();
		String user = (String)session.get("user");
		//�ж��Ƿ���Ȩ��
		if(user != null && user.equals("vinxent")) {
			return SUCCESS;
		}
		ctx.put("tip", "�㻹û�е�¼�����ߵ�¼���û�������ȷ�������µ�¼��");
		return LOGIN;
	}

}
