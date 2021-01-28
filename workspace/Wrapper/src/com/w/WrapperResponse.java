package com.w;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WrapperResponse extends HttpServletResponseWrapper {
	HttpServletResponse response;
	public WrapperResponse (HttpServletResponse response) {
		super (response);
		this.response = response;
	}
	
	@Override
	public void addCookie (Cookie cookie) {
		System.out.println("[쿠키:응답레퍼]원데이터 : " + cookie.getValue ());
		//소문자로 조작하여 저장
		cookie.setValue (cookie.getValue ().toLowerCase());
		response.addCookie (cookie);
	}

}
