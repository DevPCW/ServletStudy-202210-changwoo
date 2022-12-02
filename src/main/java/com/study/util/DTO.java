package com.study.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;

public class DTO {
	
	public static Map<String, String> getParams(HttpServletRequest request) {
	
		Map<String, String> dataMap = new HashMap<>();	
		
		Set<String> keySet = request.getParameterMap().keySet(); //맵에서 키만 들고오는 메소드 키셋
		keySet.forEach(key -> {
			dataMap.put(key, request.getParameter(key)); // dataMap에 키와 벨류가 동시에 들어가게됨
		});
		
		return dataMap;
	}
}
