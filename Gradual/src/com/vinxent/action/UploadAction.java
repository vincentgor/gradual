package com.vinxent.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	/**
	 * ��ʱֻ֧�ַǺ����ļ����ϴ��������ڸ�Ŀ¼�µ�upload��
	 */
	private static final long serialVersionUID = 1L;
	private String title;      //�ļ�����
	private File upload;       //�ļ�
	private String uploadContentType;    //�ļ�����
	private String uploadFileName;      //�ļ���
	private String savePath;            //�����·��
	private String allowTypes;     //�����ϴ����ļ�����
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
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
		// TODO Auto-generated method stub
		//ת�Ƶ�������Ҫ�����Ŀ¼��
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"+getTitle()+"_" +getUploadFileName());
		//�ϴ����ļ��������ڡ�struts.multipart.saveDir����
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len=fis.read(buffer))>0) {
			fos.write(buffer, 0, len);
		}
		fos.close();  //�ǵùر�
		fis.close();  //�ǵùر�
		System.out.println("------already uploaded-----");
		return SUCCESS;
	}
	
	/*
	 * �����ļ�����
	 */
//	public String filterTypes(String[] types) {
//		//ϣ���ϴ����ļ�����
//		String fileType = getUploadContentType();
//		for (String type:types) {
//			if(type.equals(fileType))
//				return null;
//		}
//		return INPUT;
//	}
	
	/*
	 * ִ������У��
	 */
//	public void validate() {
//		String filterResult = filterTypes(getAllowTypes().split(","));
//		if(filterResult != null) {
//			//���fieldError
//			addFieldError("upload", "��Ҫ�ϴ����ļ����Ͳ���ȷ");
//		}
//	}
}
