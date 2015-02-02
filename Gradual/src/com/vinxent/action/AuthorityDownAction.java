/*
 * 这是一个有身份验证的下载action，必须登录后才能开启下载
 */

package com.vinxent.action;

import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class AuthorityDownAction implements Action {
	
	private String inputPath;   //要下载的目标文件
	
	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	///必须返回一个 InputStream 的结果，作为 下载的入口流
	public InputStream getTargetFile() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);	
	}

	/*
	 * 身份验证
	 */
	@Override
	public String execute() throws Exception {
		//取得Actioncontext实例
		ActionContext ctx = ActionContext.getContext();
		//访问HttpSession
		Map session = ctx.getSession();
		String user = (String)session.get("user");
		//判断是否有权限
		if(user != null && user.equals("vinxent")) {
			return SUCCESS;
		}
		ctx.put("tip", "你还没有登录，或者登录的用户名不正确，请重新登录！");
		return LOGIN;
	}

}
