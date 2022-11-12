package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/image")
public class BinaryStreamDemo1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/JPEG");
		ServletOutputStream os=resp.getOutputStream();
		String path=req.getServletContext().getRealPath("Tech.jpg");
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		byte[] b=new byte[(int) f.length()];
		fis.read();
		os.write(b);
		os.flush();
		os.close();
	}
	
}
