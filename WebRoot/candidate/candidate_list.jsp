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
				<td>id</td>
				<td>name</td>
				<td>sex</td>
				<td>age</td>
				<td>address</td>
				<td>introduce</td>
				<td>image</td>
				<td>ballot</td>
				<td>修改信息</td>
			</tr>
		 <c:forEach items="${requestScope.candidateList}" var="list"> 
			
				<tr height="3">
					<td>${list.id }</td>
					<td>${list.name }</td>
					<td>${list.sex }</td>
					<td>${list.age }</td>
					<td>${list.address }</td>
					<td width="20"> 
						<textarea rows="1" cols="30" disabled="disabled">${list.introduce }</textarea>
					</td>
					<td> <img alt="" height="100" width="65" 
					src="${pageContext.request.contextPath }/files/images/${list.image }">
					<a href="${pageContext.request.contextPath }/files/images/${list.image }">查看大图</a>
					 	<a href="${pageContext.request.contextPath }/DownServlet?file=${list.image }">下载图片</a>				   
					 </td>
					<td>${list.ballot }</td>
<td>
	<a href="${pageContext.request.contextPath }/FindCandidateById?id=${list.id }">修改</a>
	<a href="${pageContext.request.contextPath }/DeleteCandidate?id=${list.id }">删除</a>
</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
