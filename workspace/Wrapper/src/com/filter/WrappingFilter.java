package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.w.RequestWrapper;
import com.w.WrapperResponse;


@WebFilter("/WrappingFilter")
public class WrappingFilter implements Filter {

    public WrappingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청이 들어오면 요청 객체를 래퍼 객체로 감싸서 이 래퍼 객체를 서블릿으로 전달한다.
		String str = request.getParameter ("msg");
		System.out.println ("[필터] 원데이터 : " + str);
		RequestWrapper req = new RequestWrapper((HttpServletRequest)request);
		//응답 객체도 응답 레퍼 객체로 감싸서 서블릿으로 전송한다.
		WrapperResponse res = new WrapperResponse((HttpServletResponse)response);
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
