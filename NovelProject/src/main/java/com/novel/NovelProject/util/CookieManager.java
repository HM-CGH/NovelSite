package com.novel.NovelProject.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	//중복되는 문장을 제거하기 위함
	
	//쿠키생성 - 쿠키의 이름, 값, 유효기간을 사용자로부터 전달받아서 쿠키를 생성
	//응답객체에 추가
	// response는 참조형 변수 = 메모리의 주소만 가지고 있을뿐 사라지거나 하지 않는다. 
	//	실제 작업은 메모리에서 일어난다.
	public static void makeCookie(HttpServletResponse response
						, String name, String value, int maxAge){
		
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		
		response.addCookie(cookie);
		
	}
	
	// 쿠키 삭제  -- 유효기간만 0으로 만들면 됨
	// 쿠키 값을 반환
	public static void deleteCookie(HttpServletResponse response, String name){

			Cookie cookie = new Cookie(name, "");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			
			response.addCookie(cookie);
	}
	
	
	public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			if(c.getName().equals(name)){
				return c.getValue();
			}
		}
		return "";
	}
	
}
