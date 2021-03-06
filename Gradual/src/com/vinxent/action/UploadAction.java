/*
 * 上传文件action， 一次可以上传多个文件，支持中文命名的文件上传
 */
package com.vinxent.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	/**
	 * 暂时只支持非汉字文件名上传，保存在根目录下的upload下
	 * 进行改造，可以同时上传三个文件，同理可以传很多个
	 */
	private static final long serialVersionUID = 1L;
	private String title;      //文件标题
	private File[] upload;       //文件
	private String[] uploadContentType;    //文件类型
	private String[] uploadFileName;      //文件名
	private String savePath;            //保存的路径
	private String allowTypes;     //允许上传的文件类型
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getRequest().getSession().getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getAllowTypes() {
		return allowTypes;
	}
	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}
	
	@Override
	public String execute() throws Exception {
		//得到上传的文件数组
		File[] files = getUpload();
		//遍历每个要上传的文件
		for (int i = 0; i < files.length; i++) {
			//转移到我们想要保存的目录下
			FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"+getTitle()+"_" +getUploadFileName()[i]);
			//上传的文件，保存在“struts.multipart.saveDir”下
			FileInputStream fis = new FileInputStream(files[i]);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=fis.read(buffer))>0) {
				fos.write(buffer, 0, len);
			}
			fos.close();  //记得关闭
			fis.close();  //记得关闭
		}
		System.out.println("------already uploaded-----");
		return SUCCESS;
	}
	
	///一下几个函数，由于使用struct2的文件拦截上传功能，故在此可以不用写一下代码
	
	/*
	 * 过滤文件类型
	 */
//	public String filterTypes(String[] types) {
//		//希望上传的文件类型
//		String fileType = getUploadContentType();
//		for (String type:types) {
//			if(type.equals(fileType))
//				return null;
//		}
//		return INPUT;
//	}
	
	/*
	 * 执行输入校验
	 */
//	public void validate() {
//		String filterResult = filterTypes(getAllowTypes().split(","));
//		if(filterResult != null) {
//			//添加fieldError
//			addFieldError("upload", "你要上传的文件类型不正确");
//		}
//	}
}
