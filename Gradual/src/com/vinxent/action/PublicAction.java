package com.vinxent.action;

import com.opensymphony.xwork2.ActionSupport;

public class PublicAction extends ActionSupport {
	
	/**
	 * »áÔ±·¢Ìû
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String content;
	private String titleString;
	private String contentString;

	@Override
	public String execute() throws Exception {
		if (titleString!=null) {
			title = titleString;
		}
		if (contentString!=null) {
			content = contentString;
		}
		return SUCCESS;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitleString() {
		return titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}

	public String getContentString() {
		return contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
	}


}
