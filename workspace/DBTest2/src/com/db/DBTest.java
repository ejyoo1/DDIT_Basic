package com.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dbConnect", description = "데이터베이스 접속 테스트", urlPatterns = { "/dbConnect"})
public class DBTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger"; 
		  Class.forName(driver);
		 */
		//DB접속 확인
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url  = "jdbc:oracle:thin:@localhost:1521:xe";
		String id 	= "ejyoo";
		String pw	= "java";
		//1. 드라이버 로드
		Connection conn = null;
		try {
			Class.forName (driver);
			//2. 연결
			conn = DriverManager.getConnection (url, id, pw);
			System.out.println ("연결완료");
			//3. 쿼리
			//4. 연결 종료
			conn.close ();
			System.out.println ("연결종료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println ("연결실패");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
