<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page import="org.jfree.data.general.DefaultPieDataset,org.jfree.chart.ChartFactory
,org.jfree.chart.JFreeChart,org.jfree.chart.servlet.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

<%
    DefaultPieDataset dpd = new DefaultPieDataset();
    
    dpd.setValue("你", 25);
    dpd.setValue("我", 25);
    dpd.setValue("他", 45);
    dpd.setValue("别人", 10);
    
    JFreeChart chart = ChartFactory.createPieChart("某公司组织结构图",dpd, true, false, false);
    
    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
    
    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
%>
url = <%=url %><br>
request.getContextPath()=<%= request.getContextPath() %><br>
<table border="1">
<tr>
	<td width="200">test</td>
	<td><img src="<%= url %>" width="800" height="600"></td>
</tr>

</table>



</body>
</html>