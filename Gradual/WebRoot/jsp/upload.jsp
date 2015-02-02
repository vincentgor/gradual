<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>上传文件</title>
  </head>
  <body>
  	<span style="color:red"><s:fielderror /></span>
  	<s:form action="upload.action" enctype="multipart/form-data" method="post">
      <s:textfield name="title" label="文件标题" /><br />
      <s:file name="upload" label="文件一" /><br />
      <s:file name="upload" label="文件二" /><br />
      <s:file name="upload" label="文件三" /><br />
      <s:submit value="上传" />
  	</s:form>
  </body>
</html>
