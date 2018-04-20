package com.zq.jfreechart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServlet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

public class test_pie extends HttpServlet {
	@Test
	public void test() {
		DefaultPieDataset dpd = new DefaultPieDataset(); // 建立一个默认的饼图
		dpd.setValue("管理人员", 25); // 输入数据
		dpd.setValue("市场人员", 25);
		dpd.setValue("开发人员", 45);
		dpd.setValue("其他人员", 10);
		dpd.setValue("1", 10);
		dpd.setValue("2", 10);
		dpd.setValue("3", 10);

		JFreeChart chart = ChartFactory.createPieChart("某公司人员 表名", dpd, true,
				true, false);
		String path = this.getServletContext().getRealPath("files/images");

		// 可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，
		// 第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
		// saveAsFile(chart, "F:\\jfreechart\\lineXY.png", 600, 400);
		saveAsFile(chart, path + "/lineXY.png", 600, 400);
		ChartFrame chartFrame = new ChartFrame("某公司人员组织数据图ChartFrame", chart);
		// chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
		chartFrame.pack(); // 以合适的大小展现图形
		chartFrame.setVisible(true);// 图形是否可见

	}

	// 保存为文件

	public void saveAsFile(JFreeChart chart, String outputPath,

	int weight, int height) {

		FileOutputStream out = null;

		try {

			File outFile = new File(outputPath);

			if (!outFile.getParentFile().exists()) {

				outFile.getParentFile().mkdirs();

			}

			out = new FileOutputStream(outputPath);

			// 保存为PNG

			ChartUtilities.writeChartAsPNG(out, chart, weight, height);

			// 保存为JPEG

			// ChartUtilities.writeChartAsJPEG(out, chart, weight, height);

			out.flush();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (out != null) {

				try {

					out.close();

				} catch (IOException e) {

					// do nothing

				}

			}

		}

	}
}