<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.*,com.zq.po.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function check() {//candidate_id
      //alert(" 执行了");
		candidate_id1 = document.forms[0].candidate_id;
		txt= "";
		for(i=0;i < candidate_id1.length;++i){
			if(candidate_id1[i].checked) {
				txt = txt + candidate_id1[i].value + " ";
			}
		}
		if(txt==""){
			alert("请为选手头票");
		}
		//alert(" 执行了");
		document.getElementById("test").value = txt;		
	}	
</script>



<body bgcolor="#F6F9FE"> 
<br>
<%-- <div align="center"><font color="red" size="10">${msg }</font></div>
 --%>		
 <a href="admin/admin_login.jsp" target="_parent">管理员登陆</a>
		<br>拍照测试链接<a href="${pageContext.request.contextPath }/takephoto/takephoto.jsp">跳转</a> </br>
		<br> 候选人列表：<hr color="black"><br>
		
		<form action="${pageContext.request.contextPath }/voterCheck" method="post">
		value="显示数据"<input type="text" name="test" id="test" size="50" >
		ip = <input type="text" name="test_ip" id="test_ip" value="${pageContext.request.remoteAddr}"/>
		
		<!-- <input type="hidden" name="test" value=""/> -->
		
		<table width="100%" border=1 >
			<tr >
				<td>id</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>地址</td>
				<td>简介</td>
				<td>照片</td>
				<td>票数</td>
				<td>投票</td>
			</tr>
		 <c:forEach items="${requestScope.candidateList}" var="list"> 
			
				<tr height="3">
					<td>${list.id }</td>
					<td>${list.name }</td>
					<td>${list.sex }</td>
					<td>${list.age }</td>
					<td>${list.address }</td>
					<td width="20"> 
						<textarea rows="1" cols="30" disabled>${list.introduce }</textarea>
					</td>
					<td> <img alt="" height="100" width="70" 
					src="${pageContext.request.contextPath }/files/images/${list.image }">
					<a href="${pageContext.request.contextPath }/files/images/${list.image }">查看大图</a>
						 
					   
					 </td>
					<td>${list.ballot }</td>
<td>
	
	投票<input type="checkbox" name="candidate_id" value="${list.id}"/>
</td>
				</tr>
			</c:forEach>
		<tr>
	     	<td colspan="2" align="center" height="40">	     	
	     	<input type="button" value="button" onclick="check()"/>
	     	<input type="submit" name="tijiao" value="提交投票" onclick="check()"/></td>
	     </tr> 
		</table>	
	</form>	
</body>
</html>