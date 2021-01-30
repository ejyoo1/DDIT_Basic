package com.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cs", description = "서블릿 연결 DB 폼", urlPatterns = { "/cs" })
public class ConnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	String driver 	= "oracle.jdbc.driver.OracleDriver";
	String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
	String id		= "ejyoo";
	String pw		= "java";
       
    public ConnServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println ("디비 초기화");
		try {
			Class.forName (driver);
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println ("연결 완료");
		}catch (Exception e) {
			System.out.println ("연결 실패");
		}
		
	}

	public void destroy() {
		System.out.println ("디비 해제");
		try {
			if( conn != null ) {
				conn.close();
				System.out.println ("연결 종료");
			}
		} catch (Exception e) {
			System.out.println ("연결 종료 실패");
		}
		System.out.println ("멤버변수 해제 : DB 연결 종료");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println ("디비 쿼리 수행 예정");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
