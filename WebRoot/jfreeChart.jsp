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
    
    dpd.setValue("��", 25);
    dpd.setValue("��", 25);
    dpd.setValue("��", 45);
    dpd.setValue("����", 10);
    
    JFreeChart chart = ChartFactory.createPieChart("ĳ��˾��֯�ṹͼ",dpd, true, false, false);
    
    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session); 
    //ServletUtilities������web�����Ĺ����࣬����һ���ַ����ļ���,�ļ����Զ����ɣ����ɺõ�ͼƬ���Զ����ڷ�������tomcat������ʱ�ļ��£�temp��
    
    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //�����ļ���ȥ��ʱĿ¼��Ѱ�Ҹ�ͼƬ�������/DisplayChart·��Ҫ�������ļ����û��Զ����<url-pattern>һ��
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