<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>欢迎投票</title>
<%--     <frameset rows="55px,*">			
			<frame src="navigation.jsp" scrolling="no" frameborder="0" noresize></frame>
			<frame src="${pageContext.request.contextPath }/ListCandidateToVoter" name="index" frameborder="0" noresize></frame>
	</frameset> --%>
  </head>
  
  <body> 
 requestScope.url==== ${requestScope.url}<br> 
  <div> <a href="${pageContext.request.contextPath }/JfreeChartServlet">刷新</a></div>
  <img alt="" src="${requestScope.url} " >	
  </body>
</html>
