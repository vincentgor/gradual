<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�ϴ��ļ�</title>
  </head>
  <body>
  	<span style="color:red"><s:fielderror /></span>
  	<s:form action="upload.action" enctype="multipart/form-data" method="post">
      <s:textfield name="title" label="�ļ�����" /><br />
      <s:file name="upload" label="�ļ�һ" /><br />
      <s:file name="upload" label="�ļ���" /><br />
      <s:file name="upload" label="�ļ���" /><br />
      <s:submit value="�ϴ�" />
  	</s:form>
  </body>
</html>
