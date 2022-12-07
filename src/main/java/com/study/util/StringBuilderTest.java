package com.study.util;

public class StringBuilderTest {

	public static void main(String[] args) {

		String str = "문자열1"; // 새로운 메모리 주소 할당
		str += "문자열2"; // 새로운 메모리 주소 할당
		// 새롭게 바뀐 녀석을 다시 대입을 해줘야함. 이 메소드가 리턴이 String으로 잡혀있음.
		str = str.replaceAll("문자열2", "문자열3"); // 새로운 메모리 주소 할당
		
		System.out.println(str);
		
		
		
		StringBuilder builder = new StringBuilder(32); // 매개변수 자리 (int capacity): 공간 -> 기본 디폴트 값은 16으로 잡혀있음.[char=2byte -> 16이니 32byte]
		// append 메소드 사용하면 저 16 공간 중에 한 공간으로 들어가게 됨 -> 필요한 만큼만 메모리 공간을 계속 16칸씩 늘림 -> 메모리 낭비를 안함 [자동으로 줄일수도있음]
		
		StringBuffer buffer = new StringBuffer();
		
		// StringBuilder는 비동기
		// StringBuffer는 동기(쓰레드 필수)
	}

}
