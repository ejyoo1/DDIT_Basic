package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {
	public static void main (String[] args) {
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String id 		= "pc19";
		String pw		= "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection (url,id,pw);
			
			String sql = "select * from cart where cart_member = ?";
//			like를 쓰는 경우에는 연결 고리 || 를 표시해야함.
//			String sql = "select * from cart where cart_member like '%' || ? || '%'";
			ps = con.prepareStatement (sql);
//			물음표에 값 채워넣기 setString(물음표인덱스,물음표값)
			ps.setString (1, "a001");
//			ps.setInt (int parameterIndex, int x);
//			ps.setDate (int parameterIndex, Date x);
//			ps.setObject (int parameterIndex, Object x);
			
			rs = ps.executeQuery ();
			
//			rs에서 쿼리를 통한 결과 컬럼이 몇개인지 알 수 있는 클래스 존재함.
			ResultSetMetaData md = rs.getMetaData (); //메타데이터 : 데이터에 대한 데이터
			
//			컬럼의 수를 알 수 있음.
			int columnCount = md.getColumnCount (); //컬럼 수
			
			while(rs.next ()) {
				for(int i = 1 ; i <= columnCount ; i++) {//컬럼 수만큼 찍기 
//					(ResultSetmetaData)md.getColumnName(i) : 컬럼 이름 출력
					System.out.print (md.getColumnName(i) + " : ");
//					(ResultSet)rs.getObject(i) : 타입에 상관없이 값을 가져올 수 있음.
					Object value = rs.getObject (i);
					System.out.print (value + "\t");
				}
				System.out.println ();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}
	}
}
