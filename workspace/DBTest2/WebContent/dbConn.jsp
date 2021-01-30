<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.sql.*"
%>
<%!
	Connection conn = null;
	public void jspInit(){
		System.out.println("멤버변수 초기화 : DB 연결");
		String driver 	= "oracle.jdbc.driver.OracleDriver";
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String id 		= "ejyoo";
		String pw		= "java";
		
		try {
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
			if( conn != null ){
				conn.close();
				System.out.println("연결종료");
			}
		} catch (Exception e){
			System.out.println("연결종료 실패");
		}
		System.out.println("멤버변수 해제 : DB 연결 종료");
	}
%>

디비 연결 테스트