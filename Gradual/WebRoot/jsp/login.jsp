<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>下载前的登录界面</title>
  </head>
  <body>
  	<h3>下载前的登录界面</h3>
  	<s:actionerror/>
  	${requestScope.tip }
  	<form action="login.action" method="post">
  	  用户名： <input type="text" name="username" /><br />
  	   密     码：    <input type="text" name="password" /><br />
  	  <input type="submit" value="登录" /><br />
  	</form>
  </body>
</html>
