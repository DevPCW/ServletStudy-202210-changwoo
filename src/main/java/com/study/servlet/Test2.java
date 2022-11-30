package com.study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test/2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Test2 클래스 service() 호출!!");
		resp.setContentType("text/plain; charset=utf8");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("그냥 텍스트 응답");
	}

}
