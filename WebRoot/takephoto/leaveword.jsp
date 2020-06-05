<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.*,com.zq.po.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>留言</title>
</head>
<body>
<h2>留言</h2>
<form action="${pageContext.request.contextPath}/ImageUpload " method="POST" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" id="name_id" onblur="checkName()"/>
				<span id="useridSpan" style=" color:#F00">不能为空！</span>
				</td>
			</tr>
			<tr>
				<td>手机号</td>
				<td>
					<input type="text" name ="address" id="address_id" onblur="checkAddress()"/>
					<span id="addressidSpan" style=" color:#F00">不能为空！</span>
				</td>
			</tr>
			<tr>
				<td>留言信息</td>
				<td><textarea name="introduce" cols="100" rows="4" id="introduce_id" onblur="checkIntroduce()"></textarea><br>
				<!-- <span id="introducedSpan" style=" color:#F00">不能为空！</span> -->
				</td>
			</tr>			 	
			<tr>					
				<td align="center"><input type="reset" id="009" name="重置" value="重置"></td>
				<td align="center"><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>
	<br><br>
</body>
</html>