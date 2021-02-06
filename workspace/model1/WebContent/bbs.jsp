<%@page import="org.apache.commons.collections4.bag.SynchronizedSortedBag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.sql.*"
	import="model1.*"
%>

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


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	${ user.uid } 님 반갑습니다.<br>
 	<table border="1">
 		<thead>
 			<tr>
				<td>글번호</td> 			
				<td>작성자</td>
				<td>제목</td>
				<td>내용</td>
				<td>등록일</td>
 			</tr>
 		</thead>
 		<tbody>
 			
 		
 	
 	<%
	//아이디 비번 이용하여 쿼리 수행
	String sql = "select * from tbl_board order by bno desc";
	//쿼리 수행 코드
	Statement stmt  = conn.createStatement ();
	ResultSet rs	= stmt.executeQuery (sql);
	//쿼리 결과로 다음 데이터가 있으면 수행해라.
	if( rs.next() ){
		do{
			System.out.println(rs.getString("title"));
	%>
				<tr>
					<td><%= rs.getInt("bno") %></td> 			
					<td><%= rs.getString("title") %></td>
					<td><%= rs.getString("content") %></td>
					<td><%= rs.getString("writer") %></td>
					<td><%= rs.getString("regdate") %></td>
	 			</tr>
<%	
		}while(rs.next());
	}
	
	rs.close();
	stmt.close();
 %>
 		</tbody>
 	</table>
 	
</body>
</html>