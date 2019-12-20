package com.varzac.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtility {
	public static void setCookie(HttpServletResponse response, String name, String value) {
		 Cookie cookie = new Cookie(name, value);
		 cookie.setMaxAge(60*60*24); 			// 1일
		 cookie.setPath("/");				    // 모든 경로에서 접근 가능하도록 
		 response.addCookie(cookie);
	}

	public static String getCookie(HttpServletRequest request, String cookieName) {
		 Cookie [] cookies = request.getCookies();
		 String value = "";

		 if(cookies != null) {
			 for(int i=0;i<cookies.length;i++) {
				 if(cookieName.equals(cookies[i].getName())) {
				   value = cookies[i].getValue();
				   break;
				 }
			 }
		 }
		 return value;
	}
}