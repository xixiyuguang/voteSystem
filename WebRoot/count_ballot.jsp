<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>显示候选人</title>
</head>
<body bgcolor="#F6F9FE">
		<br>
		<br>
		<br>
		<br> 候选人列表：
		<table width="100%" border=1 >
			<tr >		 
				<td>name</td>	 	 
				<!-- <td>image</td> -->
				<td>ballot</td>			 
			</tr>
		 <c:forEach items="${candidateList}" var="list"> 			
				<tr height="3">			 
					<td>${list.name }</td>
					 
					<%-- <td> <img alt="" height="100" width="70" 
					src="${pageContext.request.contextPath }/files/images/${list.image }">
					<a href="${pageContext.request.contextPath }/files/images/${list.image }">查看大图</a>						 					   
					 </td> --%>
					<td>${list.ballot }</td>
				</tr>
			</c:forEach>
		</table>
	 
</body>
</html>
