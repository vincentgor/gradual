<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�ϴ��ļ��ɹ�</title>
  </head>
  <body>
        �ϴ��ɹ���<br />
  �ļ����⣺  <s:property value="title" /> <br />
  �ļ�Ϊ�� <img src="<s:property value="'upload/' + uploadFileName" />"/><br />
  </body>
</html>
