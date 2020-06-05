<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>主页</title>
</head>
<body bgcolor="#ccffff" >

<h1 align="center">导航</h1><hr color="black">


     <!--导航栏链接  -->
	<table border="1" align="center">
	
		<tr height="50">
			<td>
			<a href="${pageContext.request.contextPath }/frameset/welcome.jsp" target="frame"><font size="5">欢迎管理员</font></a>
			</td>
		</tr>
		<!--  /candidate/candidate_list.jsp-->
		<tr height="50">
			<td><a href="${pageContext.request.contextPath }/candidateList" target="frame"><font size="5">查看用户</font></a></td>
		</tr>
		
		<tr height="50">
			<td><a href="${pageContext.request.contextPath }/candidate/candidate_add.jsp" target="frame"><font size="5">添加用户</font></a></td>
		</tr>
		<%-- <tr height="50">
			<td><a href="${pageContext.request.contextPath }/candidate/checkMessage" target="frame"><font size="5">查看留言</font></a></td>
		</tr> --%>
		
		<%-- <tr height="50">
			<td><a href="${pageContext.request.contextPath }/BallotCountListServlet" target="frame"><font size="5">票数统计</font></a></td>
		</tr> --%>
				
	</table>
</body>
</html>