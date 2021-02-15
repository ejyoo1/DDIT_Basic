package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static void main (String[] args) {
		/*
		 * JDBC (JAVA Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 jdbc
		 * 
		 * jdbc 작성단계
		 * 1. Connection 생성(DB연결)
		 * 2. Statement 생성(쿼리 작성)
		 * 3. Query 실행
		 * 4. ResultSet에서 결과 추출(select 인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 * 
		 * */
		
//		데이터베이스 접속정보
		String driver 	= "oracle.jdbc.driver.OracleDriver";
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String id 		= "pc19";
		String pw		= "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
//			DriverManager : 데이터베이스에 접속하기 위한 드라이버를 관리해주는 클래스
			con = DriverManager.getConnection (url,id,pw);
			
			String sql = "SELECT * FROM MEMBER";
//			쿼리를 돌려줌.
			ps = con.prepareStatement (sql);
			
//			쿼리를 실행(2가지 방법)
//			1) select 
			rs = ps.executeQuery ();
			
//			2) insert, update, delete : int type의 리턴타입을 가지고 잇음.
//			int result = ps.executeUpdate ();//몇개의 row가 영향을 받앗는지 반환해준다.
			
//			select 의 결과를 얻어온 rs에서 데이터 꺼내기 
//			처음 rs 무언가를 가지고 잇지 않는다.rs.next()를 실행하면 db의 첫번째 줄을 바라보게 된다.
			while(rs.next ()) {//while 문 안에서 rs.next 를 계속 실행 (의미 : 그 다음줄(행)이 잇는지 없는지 판별)
//				rs 내 행 추출
//				컬럼의 순서를 명시 : rs.getString(1);
//				컬럼의 이름을 명시 : rs.getString("MEM_ID");
				System.out.println (rs.getString (1));
				System.out.println (rs.getString ("MEM_ID"));
				
//				rs.getInt("");
//				rs.getDate("");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println ("연결실패");
		} finally {
			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}
	}
	
	
}
