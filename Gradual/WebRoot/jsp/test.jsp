<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import= "com.opensymphony.xwork2.ActionContext"  %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>你的文章</title>
  </head>
  <body>
  <%
 // ActionContext.getContext().getValueStack().setValue("title","nima"); 
//  String name = (String)ActionContext.getContext().getValueStack().findString("title");
  %>
  	文章标题：<s:property value="title" /><br />
  	文章内容：<s:property value="content" />
  </body>
</html>
