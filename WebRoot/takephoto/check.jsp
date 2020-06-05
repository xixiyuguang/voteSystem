<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.*,com.zq.po.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br>
 <div align="center"><font color="red">${msg }</font></div>
 <br>
<a href="${pageContext.request.contextPath }/takephoto/1.png">chakan</a>
<img alt="" src="${pageContext.request.contextPath }/takephoto/1.png">
<hr><br>
<a href="${pageContext.request.contextPath }/JsonString">查看json数据</a>
<br>
<a href="${pageContext.request.contextPath }/mouthServlet">查看嘴巴分析情况</a>

<br>
<a href="${pageContext.request.contextPath }/eyeServlet">查看眼睛分析情况</a>
<br>
<a href="${pageContext.request.contextPath }/contourServlet">查看头部状态分析情况</a>

</body>
</html>