package com.zq.jfreechart;

import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import com.zq.po.Candidate;
import com.zq.service.CandidateService;

public class JfreeChartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  //data set
		
		CandidateService service = new CandidateService();
		List<Candidate> candidateList = service.listAll();
		
		for(Candidate cc:candidateList){
			System.out.println(cc.getName());
			System.out.println(cc.getBallot());
			dataset.addValue(cc.getBallot(), "候选人的数据", cc.getName() );					
		}
		
		// 添加数据
//		dataset.addValue(440, "数据", "类型1");
//		dataset.addValue(360, "数据", "类型2");
//		dataset.addValue(510, "数据", "类型3");
//		dataset.addValue(390, "数据", "类型4");
		//创建主题样式
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
		//设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));
		//设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));
		//设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));
		//应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);
		//
		HttpSession session = request.getSession();
		JFreeChart chart = ChartFactory.createBarChart3D("投票结果统计图", "候选人",
				"票数", dataset, PlotOrientation.VERTICAL, true, false, false);
		String fileName = ServletUtilities.saveChartAsPNG(chart, 800, 600,
				session);
		// ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）

		String url = request.getContextPath() + "/DisplayChart?filename="
				+ fileName;
		// 根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致	
		request.setAttribute("url", url);
		request.getRequestDispatcher("/chart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
