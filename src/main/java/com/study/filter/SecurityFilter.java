package com.study.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.domain.User;


@WebFilter("/*")
public class SecurityFilter extends HttpFilter implements Filter { // 서블릿에 들어가기전에 필터에서 하는 역할들
       

	private static final long serialVersionUID = 1L;

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String requestURI = req.getRequestURI();
		String antMatchers1 = "/mypage, /mypage/password";
		String antMatchers2 = "/login, /register";
		String logoutURI = "/logout";
		String adminPage = "/admin";
		
		System.out.println("시큐리티 동작");
		
		if(antMatchers1.contains(requestURI) && !authorization(req.getSession())) { // 인증이 되어있지 않으면, 즉 로그인이 안되면 true
			resp.sendRedirect("/login"); // 필터에서 거르는거임 -> 여기에서 걸리면 로그인으로 보내버림
			return;	
		}
		
		if(antMatchers2.contains(requestURI) && authorization(req.getSession())) { // 로그인이 되어있는데 회원가입 페이지 들어갔거나 로그인페이지 갔을 때
			resp.sendRedirect("/mypage");
			return;
		}
		
		if(logoutURI.equalsIgnoreCase(requestURI)) { // 로그아웃 요청이 들어오면 세션을 만료시켜라
			req.getSession().invalidate(); // session을 강제로 죽이는 메소드임. 로그인했던 정보가 다날라감
			resp.sendRedirect("/login");
			return;
		}
		
		System.out.println(requestURI);
		
		if(requestURI.contains(adminPage) && !hasRole(req.getSession(), "ADMIN")) { // 내가 요청한 주소에 있다면 admin이 들어가있다면
			resp.sendError(403, "Forbidden"); // 403: 권한이 없을 때 뜨는 애임
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	private boolean authorization(HttpSession session) {
		User principalUser = (User) session.getAttribute("principal");
		System.out.println(principalUser);
		return principalUser != null;
	}
	
	private boolean hasRole(HttpSession session, String role) {
		
		AtomicBoolean result = new AtomicBoolean(false);
		
		if(authorization(session)) {
			User principalUser = (User) session.getAttribute("principal");
			
			String[] roleArray = principalUser.getRoles().replaceAll(" ", "").split(",");
			
			List<String> roleList = Arrays.asList(roleArray);
			
			
			roleList.forEach(r -> {
				if(r.startsWith("ROLE_") && r.contains(role)) { // "ROLE_"로 시작하면 true, 그리고 나서 user가 들어갔을 때 유저가 포함되어있는지 있으면, 권한이 있는거
					result.set(true); // 람다는 일반 변수는 함수에서 접근 안될 경우가 있어서, Atomic 자료형 사용해서 주소 참조, 권한이 있으면 false가 true로
				}
			});
			
		}
		
		return result.get();
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
