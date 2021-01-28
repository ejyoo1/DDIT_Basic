package com.s;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "proc", description = "레퍼 처리된 서블릿", urlPatterns = { "/proc" })
public class DataProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public DataProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding ("UTF-8");
		response.setContentType ("text/html; charset=UTF-8");
		String msg = request.getParameter ("msg");
		System.out.println ("서블릿 전달 데이터" + msg);
		
		response.addCookie (new Cookie("msg", msg));
		
		response.getWriter().append("Served at: ").append(msg);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
