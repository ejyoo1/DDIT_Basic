package k_jdbc;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;

public class JDBCBoard extends JDBCConnection{
	static ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
	static HashMap<String, Object> board = new HashMap<>();	
	static String sql = "";
	public static void main (String[] args) {
		/*
		 * 오라클 데이터베이스에 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요.
		 * 테이블 : TB_JDBC_BOARD
		 * 컬럼 : BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
		 * 
		 * */
		readAll();
//		사용자가 입력할 수 있도록 안내
		System.out.println ("1. 조회\t 2. 등록\t 0.종료");
		System.out.print ("입력>");
		int input = ScanUtil.nextInt ();
		
		switch(input) {
			case 1:
				read();
				break;
		}//close switch
	}
	
	private static void read() {
		System.out.println ("게시글 번호 입력>");
		int boardNo = ScanUtil.nextInt ();
//		데이터 접근
		for(int i = 0 ; i < boardList.size() ; i++) {
//			입력한 값이 보드내 저장된 해쉬 키와 동일한 경우
			if((Integer)boardList.get (i).get("board_no") == boardNo) {
				board = boardList.get (i);
				break;
			}//end if
		}//end for
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println ("번호\t: " + board.get ("board_no"));
		System.out.println ("제목\t: " + board.get ("title"));
		System.out.println ("내용\t: " + board.get ("content"));
		System.out.println ("작성자\t: " + board.get ("user_id"));
		System.out.println ("작성일\t: " + board.get ("reg_date"));
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println ("---------------------------------------------");
		System.out.println ("1.수정\t2.삭제\t0.목록");
		System.out.println ("입력>");
		int input = ScanUtil.nextInt ();
		
		switch(input) {
			case 1:
				update(board);
				break;
		}//end switch
	}//end read method
	
	
	private static void update(HashMap<String, Object> board) {
		System.out.println ("제목>");
		String title = ScanUtil.nextLine ();
		System.out.println ("내용>");
		String content = ScanUtil.nextLine ();
		
		board.put ("title", title);
		board.put ("content", content);
		
		try {
//			DB연결
			con = DriverManager.getConnection (url,id,pw);
			Object board_no = board.get ("board_no");
//			쿼리작성
			String sql = "UPDATE TB_JDBC_BOARD "
							+ "SET TITLE = '"+ board.get ("title") +"',"
							+ "CONTENT = '"+ board.get ("content") +"' "
							+ "WHERE BOARD_NO = "+board.get ("board_no");
//			쿼리실행
			ps = con.prepareStatement (sql);
//			쿼리결과 삽입
			int result = ps.executeUpdate ();
			System.out.println (result + "개 행이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			객체 반환
//			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}//close finally
		
		
		System.out.println ("수정 완료되었습니다.");
	}//end update
	
	
	private static void readAll() {
		try {
			con = DriverManager.getConnection (url,id,pw);
			
			
//			SELECT
			sql = " SELECT * FROM TB_JDBC_BOARD";
			
//			쿼리실행
			ps = con.prepareStatement (sql);
//			쿼리결과 삽입
			rs = ps.executeQuery();
//			쿼리 컬럼 객체 가져오기
			ResultSetMetaData md = rs.getMetaData ();
//			컬럼 개수 조회
			int columnCount = md.getColumnCount ();
			System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//			컬럼 제목 출력
			for(int i = 1 ; i <= columnCount ; i++) {
				System.out.print (md.getColumnName (i) + "\t\t");
			}
			System.out.println ();
			
//			컬럼 내용 ArrayList 저장
			while(rs.next()) {
				BoardDTO bdto = new BoardDTO();
				bdto.setBoard_no (rs.getInt("board_no"));
				bdto.setTitle (rs.getString("title"));
				bdto.setContent (rs.getString("content"));
				bdto.setUser_id (rs.getString("user_id"));
				bdto.setReg_date (rs.getString("reg_date"));
					
				board.put ("board_no", bdto.getBoard_no ());
				board.put ("title", bdto.getTitle ());
				board.put ("content", bdto.getContent ());
				board.put ("user_id", bdto.getUser_id ());
				board.put ("reg_date", bdto.getReg_date ());
					
				boardList.add (board);
			}
			System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			
//			ArrayList 출력
			for(int i = boardList.size() - 1 ; i >= 0 ; i--) {
				HashMap<String, Object> boards = boardList.get (i);
				System.out.println (boards.get ("board_no")
						+ "\t\t" + boards.get ("title")
						+ "\t\t" + boards.get ("content")
						+ "\t\t" + boards.get ("user_id")
						+ "\t\t" + boards.get ("reg_date")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println ("연결실패");
		}finally {
			if( rs != null ) try { rs.close(); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}//end finally
	}//end readAll
}
