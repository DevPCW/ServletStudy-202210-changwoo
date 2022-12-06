package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.util.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class Address {
	private String address1;
	private String address2;
	private String address3;
}

@WebServlet("/api/ajax2")
public class Ajax2Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(DTO.getParams(request));
		
		System.out.println("Ajax2로 get요청 옴!!!");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String, String> requestMap = DTO.getParams(request);
		
//		System.out.println(DTO.getParams(request));
//		
//		System.out.println("Ajax2로 post요청 옴!!!");
		
		String jsonData = request.getParameter("jsonData");
		
		System.out.println(jsonData);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Map<String, Object> addressMap = gson.fromJson(jsonData, Map.class);
		
		Address address = gson.fromJson(jsonData, Address.class);
		
		
//		System.out.println(addressMap);
		System.out.println(addressMap.get("address1")); // Map이니 get도 사용 가능
		
		System.out.println(address); // address 객체니깐 게터 세터 둘다 사용 가능
		
		Address address2 = Address.builder() // Address 객체 생성(빌더패턴 이용) 해서 응답해보기
				.address1("부산광역시")
				.address2("부산진구")
				.address3("삼정타워")
				.build();
		
		String responseJson = gson.toJson(address2); // address2 객체 얘가 Json으로 형변환되고
		
		
		
		response.setContentType("text/plain; charset=utf8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(responseJson); // Json으로 형변환 된거를 여기 넣으면됨
//		
//		out.print(requestMap.get("address1") + " " + requestMap.get("address2") + " " + requestMap.get("address3"));
//		
//		out.print("(1)지역: " + request.getParameter("address1"));
//		out.print(" ,(2)구/군: " + request.getParameter("address2"));
//		out.print(" ,(3)도로명주소: " + request.getParameter("address3"));
		
		
		
	}

}
