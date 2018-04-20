<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.*,com.zq.po.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  background="../Images/textbackground.jpg">
	<h1 align="center"><font color="red">欢迎管理员</font></h1>
	<hr color="black">

<%-- 		<c:if test="${sessionScope.candidate!=null}">	 		 
			<font size="5" color="red">添加 ${sessionScope.candidate.name} 成功</font>
		</c:if> --%>
	
	<c:if test="${sessionScope.admin!=null}">
	after judge  <br>
		<div align="center">
			<font size="5" color="red">welcom admin ${sessionScope.admin.name }</font>
		</div>
	</c:if>
	
	<c:if test="${sessionScope.admin == null}">
	<div ><font color="red">你还不是管理员，可以选择 :</font></div><br>
		<a href="${pageContext.request.contextPath }/admin/admin_regist.jsp">注册管理员</a><br><br>
		<a href="${pageContext.request.contextPath }/admin/admin_login.jsp" target="_blank">管理员登陆</a>
	</c:if>

</body>
</html>