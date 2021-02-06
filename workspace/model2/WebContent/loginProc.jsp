<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.sql.*"
	import="model1.*"
%>
<!-- 로그인 정보를 가지고 빈에 담고, 디비에 연결하여 회원인지 체크하는 쿼리를 수행한다. -->
<%! 
	Connection conn = null;
	public void jspInit(){
		System.out.println("멤버변수 초기화 : Db 연결");
		String driver 	= 	"oracle.jdbc.driver.OracleDriver";
		String url		=	"jdbc:oracle:thin:@localhost:1521:xe";
		String id		=	"ejyoo";
		String pw		=	"java";
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("연결완료");
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}
	public void jspDestory(){
		try{
			if( conn != null ) {
				conn.close();
				System.out.println("연결종료");
			}
		} catch (Exception e){
			System.out.println("연결종료 실패");
		}
		System.out.println("멤버 변수 해제 : DB 연결 종료");
	}
%>

<%
	//아이디 비번 이용하여 쿼리 수행
	String uid = request.getParameter("uid");
	String upw = request.getParameter("upw");
	String sql = "select * from tbl_user where userid='" + uid + "' and userpw='" + upw + "'";
	//쿼리 수행 코드
	Statement stmt  = conn.createStatement ();
	ResultSet rs	= stmt.executeQuery (sql);
	//쿼리 결과로 다음 데이터가 있으면 수행해라.
	User userBean = null;
	if(rs.next()){
		userBean = new User();
		userBean.setIdx (rs.getInt("IDX"));
		userBean.setUid (rs.getString ("USERID"));
		userBean.setUpw (rs.getString ("USERPW"));
		userBean.setRegdate (rs.getString ("REGDATE"));
	}
	
	rs.close();
	stmt.close();
	
	if( userBean == null ){
		RequestDispatcher rd =	request.getRequestDispatcher("loginError.jsp");
		rd.forward(request,response);
	}else{
	//페이지 이동
		request.setAttribute("user", userBean);
		RequestDispatcher rd =	request.getRequestDispatcher("bbs.jsp");
		rd.forward(request,response);
	}
%>