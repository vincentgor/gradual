<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>��������</title>
  </head>
  <body>
    <s:fielderror />
    <span style="color:red">${requestScope.tip }</span>
  	<s:form action="public.action" method="post">
      <s:textfield name="title" label="���±���" maxLength="12"/><br />
      <s:textarea  name="content" label="��������" cssStyle="width:800px; height:500px;" /><br />
      <s:submit value="����" />
  	</s:form>
  </body>
</html>
