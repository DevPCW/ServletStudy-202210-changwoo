package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.util.DTO;


@WebServlet("/api/ajax3")
public class Ajax3Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> requestMap = DTO.getParams(request);
		System.out.println("Ajax3로 post요청 옴!!!");
		
		response.setContentType("text/plain; charset=utf8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("전화번호: " + requestMap.get("phone1") + " - " + requestMap.get("phone2") + " - " + requestMap.get("phone3"));
	}

}
