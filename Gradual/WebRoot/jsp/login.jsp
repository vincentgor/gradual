<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>����ǰ�ĵ�¼����</title>
  </head>
  <body>
  	<h3>����ǰ�ĵ�¼����</h3>
  	${requestScope.tip }
  	<form action="login.action" method="post">
  	  �û����� <input type="text" name="username" /><br />
  	   ��     �룺    <input type="text" name="password" /><br />
  	  <input type="submit" value="��¼" /><br />
  	</form>
  </body>
</html>
