package com.study.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/1")
public class Session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("user_name"));
		System.out.println(session.getAttribute("user_phone"));
		System.out.println(session.getAttribute("user_email"));
		System.out.println(session.getAttribute("user_address"));
		System.out.println(session.getAttribute("user_password"));
		
		request.getRequestDispatcher("/WEB-INF/form1.html").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post요청옴!!");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		session.setAttribute("user_name", request.getParameter("name"));
		session.setAttribute("user_phone", request.getParameter("phone"));
		session.setAttribute("user_email", request.getParameter("email"));
		session.setAttribute("user_address", request.getParameter("address"));
		session.setAttribute("user_password", request.getParameter("pw"));
		
		request.getParameter("name");
		request.getParameter("phone");
		request.getParameter("email");
		request.getParameter("address");
		request.getParameter("pw");
	}

}
