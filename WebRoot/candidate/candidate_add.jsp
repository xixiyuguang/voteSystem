<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<script type="text/javascript">

function checkName(){
	var ueridObj=document.getElementById("name_id");
	var userid=ueridObj.value;
	var msg ="   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	if(!userid)
		msg ="<font color='red'>不能为空！</font>";
	var span = document.getElementById("useridSpan");
	span.innerHTML = msg;
	return msg == "   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	}
function checkAge(){
var reg = /^(-|\+)?\d+$/ ;
// reg.test(str)
	var ueridObj=document.getElementById("age_id");
	var userid=ueridObj.value;
	var msg ="   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	if(!userid)
		msg ="<font color='red'>不能为空！</font>";
	else if(!reg.test(userid))
		msg ="<font color='red'>必须是年龄！</font>";
	var span = document.getElementById("ageidSpan");
	span.innerHTML = msg;
	return msg == "   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	}
function checkAddress(){
var reg = /^(-|\+)?\d+$/ ;
// reg.test(str)
	var ueridObj=document.getElementById("address_id");
	var userid=ueridObj.value;
	var msg ="   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	if(!userid)
		msg ="<font color='red'>不能为空！</font>";
	var span = document.getElementById("addressidSpan");
	span.innerHTML = msg;
	return msg == "   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	}
function checkIntroduce(){
var reg = /^(-|\+)?\d+$/ ;
// reg.test(str)
	var ueridObj=document.getElementById("introduce_id");
	var userid=ueridObj.value;
	var msg ="   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	if(!userid)
		msg ="<font color='red'>不能为空！</font>";
	var span = document.getElementById("introduceidSpan");
	span.innerHTML = msg;
	return msg == "   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	}
function checkImage(){
var reg = /^(-|\+)?\d+$/ ;
// reg.test(str)
	var ueridObj=document.getElementById("image_id");
	var userid=ueridObj.value;
	var msg ="   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	if(!userid)
		msg ="<font color='red'>不能为空！</font>";
	var span = document.getElementById("imageidSpan");
	span.innerHTML = msg;
	return msg == "   <img src='../Images/true.PNG' border='1' style='width:12px'>";
	}
	
</script>

<body style="text-align: center;" bgcolor="#F6F9FE">
	<h1>添加候选人信息</h1>
	<hr>
	<!--/ImageUpload      /AddCandidate-->
<%-- 	<font color="red">${msg }</font>
 --%>	<form action="${pageContext.request.contextPath}/ImageUpload " method="POST" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" id="name_id" onblur="checkName()"/>
				<span id="useridSpan" style=" color:#F00">不能为空！</span>
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="sex" value="男" id="sex_id"  onblur="checSex()"/>男 
					<input type="radio" name="sex" value="女" id="sex_id"  onblur="checkSex()"/>女
					<!-- <span id="sexidSpan" style=" color:#F00">不能为空！</span> -->
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>
					<input type="text" name ="age" id="age_id"  onblur="checkAge()"/>
					<span id="ageidSpan" style=" color:#F00">不能为空！</span>
				</td>
			</tr>
			<tr>
				<td>地址</td>
				<td>
					<input type="text" name ="address" id="address_id" onblur="checkAddress()"/>
					<span id="addressidSpan" style=" color:#F00">不能为空！</span>
				</td>
			</tr>
			<tr>
				<td>个人介绍</td>
				<td><textarea name="introduce" cols="100" rows="4" id="introduce_id" onblur="checkIntroduce()"></textarea><br>
				<!-- <span id="introducedSpan" style=" color:#F00">不能为空！</span> -->
				</td>
			</tr>
			<tr>
				<td>照片</td>
				<td>
				<input name="image" type="file" size="40" maxlength="1024" id="image_id" onblur="checkImage"/>
				<!-- <span id="imageidSpan" style=" color:#F00">不能为空！</span><br> -->
				</td>
			</tr>
		
			<tr>
				<td><input type="submit" value="添加候选人" onclick="check()" />
				</td>
				<td align="center"><input type="reset" id="009" name="重置" value="重置"></td>
			</tr>
		</table>
	</form>
	<br><br>
</body>
</html>
