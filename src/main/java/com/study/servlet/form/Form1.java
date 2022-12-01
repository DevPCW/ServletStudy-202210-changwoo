package com.study.servlet.form;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/form/1")
public class Form1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form1 호출!!!");
		System.out.println(request.getAttribute("name")); // request 저장소에 들어가있는거 꺼내겠다는 의미
		request.getRequestDispatcher("/WEB-INF/name.jsp").forward(request, response);
//		request.getRequestDispatcher("/WEB-INF/form1.html").forward(request, response);
	}




}
