package k_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCConnection {
	static String url 	= "jdbc:oracle:thin:@localhost:1521:xe";
	static String id	= "pc19";
	static String pw	= "java";
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
}
