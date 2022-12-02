package com.study.servlet.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.domain.User;
import com.study.service.AccountService;
import com.study.util.DTO;


@WebServlet("/auth/login")
public class LoginApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> loginUser = DTO.getParams(request);
		
		AccountService accountService = AccountService.getInstance();
		
		User user = accountService.loadUserByUsername(loginUser.get("username"));
		
		if(user == null) {
			System.out.println("아이디 틀림!");
			// error_login.html -> script에서 사용자 정보를 확인해주세요. history.back();메소드 호출(뒤로가기) -> 다시 로그인창 뛰워주기
			return;
		}
		
		if(!accountService.checkPassword(user, loginUser.get("password"))) {
			System.out.println("비밀번호 틀림!");
			// error_login.html -> script에서 사용자 정보를 확인해주세요. history.back();메소드 호출(뒤로가기) -> 다시 로그인창 뛰워주기 
			// 해커들 때문에 패스워드 틀려도 다시 걍 로그인창으로 보내줘야함.
			return;
		}
		
		// 위의 if 안걸리면 로그인 성공! 마이페이지나 그런 곳으로 가면됨.
		
		
	}

}
