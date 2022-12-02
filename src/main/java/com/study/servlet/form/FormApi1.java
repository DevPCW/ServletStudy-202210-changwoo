package com.study.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/form/1")
public class FormApi1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get요청옴!!");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("phone"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("pw"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("pw"));
		
//		String name = request.getParameter("test");
//		String phone = request.getParameter("phone");
//		String email = request.getParameter("email");
//		String address = request.getParameter("address");
//		String password = request.getParameter("pw");
//		
//		response.getWriter().print("name: " + name);
//		response.getWriter().print("name: " + phone);
//		response.getWriter().print("name: " + email);
//		response.getWriter().print("name: " + address);
//		response.getWriter().print("name: " + password);
		
		response.setContentType("text/plain; charset=utf8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("name: " + request.getParameter("name"));
		out.println("phone: " + request.getParameter("phone"));
		out.println("email: " + request.getParameter("email"));
		out.println("address: " + request.getParameter("address"));
		out.println("password: " + request.getParameter("pw"));
	}

}

