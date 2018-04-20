package com.zqq.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("file");

		response.setHeader("Content-Disposition", "attachment;filename="
				+ URLEncoder.encode(filename, "utf-8"));
		response.setContentType(this.getServletContext().getMimeType(filename));// MIME

		String path = this.getServletContext().getRealPath("files/images");

		InputStream in = new FileInputStream(new File(path, filename));
		OutputStream out = response.getOutputStream();
		IOUtils.In2Out(in, out);
		IOUtils.close(in, null);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
