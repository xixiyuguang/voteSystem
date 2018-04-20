<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 
  
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
<button id="capture">Capture</button> 
<button id="upload">Upload</button>
<a href="${pageContext.request.contextPath }/takephoto/check.jsp">查看拍照结果</a>
<script type="text/javascript">
var capture = document.getElementById("capture");
var upload=document.getElementById("upload");
var video = document.getElementById("video");
var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");
navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
window.URL = window.URL || window.webkitURL;
navigator.getUserMedia({video:true}, onSuccess, onError); //��������ͷ��׽��Ƶ��Ϣ
capture.onclick = function(e){
	e.preventDefault();
	context.drawImage(video, 0, 0, 400, 300);  
	var img = context.getImageData(0, 0, 400, 300);
	var picLength = 400 * 300; //������ظ���
	context.putImageData(img, 0, 0);

	
}
upload.onclick=function(e){
	   	var data = canvas.toDataURL("image/png");
        var xhr = new XMLHttpRequest();
        var imgData=document.getElementById("canvas").toDataURL("image/png");
        var data=imgData.substr(22);
        xhr.open("POST","http://localhost:8080/vote/deal");
        xhr.send(data);

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