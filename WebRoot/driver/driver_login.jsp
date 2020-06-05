<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Admin login.jsp</title>
  </head>
  <body bgcolor="#F6F9FE">
    <h2 align="center">驾驶员登陆界面</h2>
    <hr>
    <div align="center"><font color="red">${msg }</font></div>
    <form action="${pageContext.request.contextPath }/DriverLogin" method="post">
	     <table border="1" align="center">
	     <tr>
	     	<td>账号:</td>
	     	<td><input type="text" name="account"></td>
	     </tr>
	     <tr>
	     	<td>密码:</td>
	     	<td><input type="password" name="password"></td>
	     </tr>  
	     <tr>
	     	<td colspan="2" align="center"><input type="submit" value="登陆"></td>
	     </tr>   
	     </table>    
    </form>
  </body>
</html>
