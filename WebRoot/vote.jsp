<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>��ӭͶƱ</title>
</head>

<body>
<h2>��ӭͶƱ</h2>
<hr>
	<table align="left" border="1">
		<tr>
			<td><a href="admin/admin_login.jsp">����Ա��½</a></td>
		</tr>
		<tr>
		<td><a href="count_ballot.jsp">ͶƱ���ͳ��</a></td>
		</tr>
	</table>
	<br>
</body>
</html>
