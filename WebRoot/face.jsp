<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>欢迎进入疲劳检测系统</title>
  </head>
  
  <body background="..Images/textbackground.jpg">
  <h1 align="left">欢迎进入疲劳驾驶检测系统</h1> 
  
<a href="admin/admin_login.jsp" target="_parent">管理员登陆</a>
<br/>

游客体验链接：<a href="${pageContext.request.contextPath }/takephoto/takephoto.jsp">跳转</a>
<br/>
<a href="driver/driver_login.jsp" target="_parent">驾驶员登陆</a>
 
 
 </body>
</html>
