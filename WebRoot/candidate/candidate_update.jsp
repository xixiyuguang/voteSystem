<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body style="text-align: center;" bgcolor="#F6F9FE">
	<h1>修改<!-- 候选人 -->信息</h1>
	<hr>
	${sessionScope.candidate.name }
	<form
		action="${pageContext.request.contextPath}/UpdateImageServlet?id=${sessionScope.candidate.id }"
		method="POST" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name"
					value="${sessionScope.candidate.name } " /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>						 
				<c:choose>
					<c:when test="${sessionScope.candidate.sex eq '女'}">
						<input type="radio" name="sex" value="男" />男 
					    <input type="radio" name="sex" value="女" checked="checked" />女 
					</c:when>
					<c:otherwise>
							<input type="radio" name="sex" value="男" checked="checked"/>男 
					        <input type="radio" name="sex" value="女" />女
					</c:otherwise>					
				</c:choose>				
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age"
					value="${sessionScope.candidate.age }" /></td>
			</tr>
			<tr>
				<td>账号（address）</td>
				<td><input type="text" name="address"
					value="${sessionScope.candidate.address }" /></td>
			</tr>
			<tr>
				<td>密码（introduce）</td>
				<td><textarea name="introduce" cols="100" rows="4">${sessionScope.candidate.introduce }</textarea>
				</td>
			</tr>
			<tr>
				<td>照片</td>
				<td><input name="image" type="file" size="40" maxlength="1024" /><br>
				</td>
			</tr>

			<tr>
				<td><input type="submit" value="提交" /></td>
				<td align="center"><input type="reset" id="009" name="重置"
					value="重置">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<br>
</body>
</html>
