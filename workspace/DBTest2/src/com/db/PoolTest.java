package com.db;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//풀링 테스트
@WebServlet(name = "pt", description = "커넥션 풀링 테스트", urlPatterns = { "/pt" })
public class PoolTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
       
    public PoolTest() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
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

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
