package com.s;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "loginProc", description = "로그인 처리", urlPatterns = { "/loginProc" })
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
       
    public LoginProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Context initCtx = new InitialContext();
			Context envCtx 	= (Context)initCtx.lookup ("java:comp/env");
			DataSource ds 	= (DataSource)envCtx.lookup("jdbc/java");
			conn 			= ds.getConnection ();
			System.out.println ("커넥션 풀로부터 커넥션 객체 획득");
			
			//쿼리 수행
			
			//반납
			conn.close ();
			System.out.println ("커넥션풀로부터 커넥션 객체 반납");
		} catch (Exception e) {
			System.out.println ("커넥션 객체 획득 오류" + e.getMessage ());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
