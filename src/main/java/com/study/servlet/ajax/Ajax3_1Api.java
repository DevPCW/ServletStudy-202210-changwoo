package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


@WebServlet("/api/ajax3_1")
public class Ajax3_1Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonData = request.getParameter("data");
		Map<String, Object> dataMap = gson.fromJson(jsonData, Map.class);
		
		//map에서 들고오면 object인데 이걸 다운캐스팅 해줘야함
//		List<String> phoneNumbers = new ArrayList<>();
//		
//		dataMap.forEach((key, value) -> { // String이면 add
//			if(value.getClass() == String.class) {
//				phoneNumbers.add((String)value);
//			}
//		});
		
		response.setContentType("application/json; charset=utf8"); // json 타입으로 응답하겠다
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		PrintWriter out = response.getWriter();
		
//		String str = "문자열1"; // 메모리 주소가 100번지라고 치면, 
//		str = str + "문자열2"; // 새로운 문자열이니 여기서 주소 200번지에 새로 들어가게됨 기존 100번지는 계속 메모리 할당 중
//		str = str + "문자열3";
		
		StringBuilder stringBuilder = new StringBuilder(); // 문자열을 만들어줌
		
		dataMap.forEach((key, value) -> {
			stringBuilder.append(value); // 010 먼저 나오고 - append 되고 그담 4082 다시 - 7825 그리고 다시 하이픈 - 이 나오는데 이걸 없애 줘야함.
			stringBuilder.append("-");
		});
		
		stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
		// delete(0, 0) => 어디서부터 어디까지 없앤다는 메소드. 여기서 length는 14 인덱스는 0~13
		// 그래서 13번 인덱스부터 14번인덱스 전까지 삭제
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("responseData", stringBuilder.toString());
		
		out.print(jsonObject.toString());
	}

}
