<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import= "com.opensymphony.xwork2.ActionContext"  %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�������</title>
  </head>
  <body>
  <%
 // ActionContext.getContext().getValueStack().setValue("title","nima"); 
//  String name = (String)ActionContext.getContext().getValueStack().findString("title");
  %>
  	���±��⣺<s:property value="title" /><br />
  	�������ݣ�<s:property value="content" />
  </body>
</html>
