package com.study.servlet.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie/2")
public class Cookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies(); // 요청 들어올때 안에 있는 쿠키 꺼내는 거임 // s 붙어있어서 복수 // 보면 쿠키 배열로 되어있음
		
//		List<Cookie> cookieList = Arrays.asList(cookies); // 이런식으로 리스트로 관리 할 수도 있음
		
		for(Cookie c : cookies) {
			System.out.println("key: " + c.getName());
			System.out.println("value: " + URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8));
			
		}
	}


}
