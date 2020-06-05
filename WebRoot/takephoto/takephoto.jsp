<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.*,com.zq.po.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<!-- 引入bootstrap -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
 <c:if test="${sessionScope.candidate!=null}">
	after judge   you  have the right use this system<br>
		<div align="center">
			<font size="5" color="red">welcom 驾驶员 ${sessionScope.candidate.name }</font>
		</div>
	</c:if>
	<c:if test="${sessionScope.candidate == null}">
	<div ><font color="red">你还不是我们的用户，可以选择 :</font></div><br>
		<a href="${pageContext.request.contextPath }/takephoto/qrcode.jsp">联系管理员</a>或者
		<a href="${pageContext.request.contextPath }/takephoto/leaveword.jsp" target="_blank">留言</a>
	</c:if>
	<br/>
  
<style type="text/css">
body {
	background:#ECF0F1;
	margin:50px;
	text-align:center;
}
#video, #canvas{
	display:inline-block;
	background:#BDC3C7;
}
button{
	font-size:32px;
	padding:10px 100px;
	display:block;
	margin:20px auto;
	clear:both;
	border-radius:6px;
	background:#3498DB;
	border:0;
	color:#FFF;
}
</style>
<video id="video" width="400" height="300" autoplay></video>
<canvas id="canvas" width="400" height="300"></canvas>
<hr/>
<p>使用流程：
1.将摄像头对准您的脸，点击拍照。
2.拍照和时候，点击上传。
3.点击分析结果。</p>


<button id="capture" type="button" class="btn btn-info">拍照</button> 
<button id="upload" type="button" class="btn btn-default" >上传</button>

<a href="${pageContext.request.contextPath }/takephoto/check.jsp">test</a>
	<button id="check" type="button" class="btn btn-success" >查看分析结果</button>


<!-- js代码 -->
<script type="text/javascript">
var capture = document.getElementById("capture");
var upload=document.getElementById("upload");
var video = document.getElementById("video");
var canvas = document.getElementById("canvas");
var check = document.getElementById("check");//查看按钮操作

var context = canvas.getContext("2d");
navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
window.URL = window.URL || window.webkitURL;
navigator.getUserMedia({video:true}, onSuccess, onError); //��������ͷ��׽��Ƶ��Ϣ

/* 拍照操作 */
capture.onclick = function(e){
	e.preventDefault();
	context.drawImage(video, 0, 0, 400, 300);  
	var img = context.getImageData(0, 0, 400, 300);
	var picLength = 400 * 300; //������ظ���
	context.putImageData(img, 0, 0);
	alert("拍照成功");
}

/* 上传操作 */
upload.onclick=function(e){
	/* canvas将图片解析成base64的图片编码 */
	   	var data = canvas.toDataURL("image/png");
	   	console.log("打印",data);
	   	/* 创建js请求 */
       
        var imgData=document.getElementById("canvas").toDataURL("image/png");
        var data=imgData.substr(22);
        if(data.length<1000){
        	alert("请先上传");
        }else{
        	 var xhr = new XMLHttpRequest();
        	xhr.open("POST","http://localhost:8080/vote/deal");
            xhr.send(data);
        }
	}

/* 查看结果跳转 */
check.onclick=function(e){
	/* canvas将图片解析成base64的图片编码 */
	   	var data = canvas.toDataURL("image/png");
	   	console.log("打印",data);
	   	/* 创建js请求 */
       
        var imgData=document.getElementById("canvas").toDataURL("image/png");
        var data=imgData.substr(22);
        if(data.length<1000){
        	alert("请先上传图片");
        }else{
        	 window.location.href="${pageContext.request.contextPath }/takephoto/check.jsp";
        }
	}

function onSuccess(stream){
	video.src = window.URL.createObjectURL(stream);  
}
function onError(){
	mystatus.innerHTML = "乱码"
}
</script>

</body>
</html>