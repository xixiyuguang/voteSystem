<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.*,com.zq.po.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">

</script>
<img alt="" src="${pageContext.request.contextPath }/takephoto/1.png">
<hr>
<br>
<hr>
信息：${sessionScope.infor}
<br>
长度：${sessionScope.distance} 像素

</body>
</html>