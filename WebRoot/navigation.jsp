<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>主页</title>
</head>
<body background="Images/bg1.png" >
	<table border="1" align="center">
	
		<tr height="50">
			<td>
			<a href="${pageContext.request.contextPath }/ListCandidateToVoter" target="index"><font size="4" color="white">欢迎界面</font></a>
			</td>
			<td>
			<a href="${pageContext.request.contextPath }/BallotCountListServlet" target="index"><font size="4" color="white">查看结果</font></a>
			</td>
			<td>
			<a href="${pageContext.request.contextPath }/JfreeChartServlet" target="index"><font size="4" color="white">查看统计图</font></a>
			</td> 	
		</tr>
	 
				
	</table>
</body>
</html>