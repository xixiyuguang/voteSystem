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
<br>
注意：这里的左边和右边，由于考虑到拍摄的图片和真是的人的方向不一样，我们以客户的真实的左边和右边进行信息反馈。
<hr>
信息：${sessionScope.infor}
<br>

</body>
</html>