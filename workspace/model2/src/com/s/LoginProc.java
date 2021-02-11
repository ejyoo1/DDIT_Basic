package com.s;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model1.User;
//Controller
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
			String uid		= request.getParameter ("uid");//"guest"
			String upw		= request.getParameter ("upw");//"1234"
//			String sql = "select * from tbl_user where userid='" + uid + "' and userpw='" + upw + "'";
			String sql		= "select * from tbl_user where userid=? and userpw=?";
			PreparedStatement ps = conn.prepareStatement (sql);
			ps.setString(1, uid);
			ps.setString (2, upw);
			ResultSet rs = ps.executeQuery ();

			
//			model
			User userBean = null;
			if(rs.next()) {
				userBean = new User ();
				userBean.setIdx (rs.getInt ("idx"));
				userBean.setUid (rs.getString ("userid"));
				userBean.setUpw (rs.getString ("userpw"));
				userBean.setRegdate (rs.getString ("regdate"));
			}
						
			//반납
			rs.close ();
			ps.close (); 
//			stmt.close ();
			conn.close ();
			System.out.println ("커넥션풀로부터 커넥션 객체 반납");
			
			//디스페쳐로 전달
			if(userBean == null) {
				RequestDispatcher rd = request.getRequestDispatcher ("loginError.jsp");
			}else {
				request.setAttribute ("user", userBean);
//				bbs.jsp : View
				RequestDispatcher rd = request.getRequestDispatcher ("bbs2.jsp");
				rd.forward (request, response);
			}
			
		} catch (Exception e) {
			System.out.println ("커넥션 객체 획득 오류" + e.getMessage ());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
