package k_jdbc;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;

public class JDBCBoard extends JDBCConnection{
	static ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
	public static void main (String[] args) {
		/*
		 * 오라클 데이터베이스에 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요.
		 * 테이블 : TB_JDBC_BOARD
		 * 컬럼 : BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
		 * 
		 * */
		selectInsertAll();
		while(true) {
			readAll();
//			사용자가 입력할 수 있도록 안내
			System.out.println ("1. 조회\t 2. 등록\t 0.종료");
			System.out.print ("입력>");
			int input = ScanUtil.nextInt ();
			
			switch(input) {
				case 1:
					read();
					break;
				case 2:
					insert();
					break;
				case 0:
					System.exit (0);
			}//close switch
		}

	}
	private static void selectInsertAll() {
		boardList = new ArrayList<>();
		try {
			con = DriverManager.getConnection (url,id,pw);
			
			
//			SELECT
			String sql = " SELECT board_no 번호, "
					+ "title 제목, "
					+ "content 내용, "
					+ "user_id 이름, "
					+ "reg_date 생성시간 "
					+ "FROM TB_JDBC_BOARD ORDER BY BOARD_NO ";
			
//			쿼리실행
			ps = con.prepareStatement (sql);
//			쿼리결과 삽입
			rs = ps.executeQuery();
			
//			쿼리 컬럼 객체 가져오기
			ResultSetMetaData md = rs.getMetaData ();
			
//			컬럼 개수 조회
			int columnCount = md.getColumnCount ();
			
			for(int i = 1 ; i <= columnCount ; i++) {//컬럼 수 만큼 찍기
//				컬럼 이름 출력
				System.out.print (md.getColumnName(i) + "\t\t");
			}
			System.out.println ();
			
//			컬럼 내용 ArrayList 저장
			while(rs.next()) {
				HashMap<String, Object> board = new HashMap<>();	
				BoardDTO bdto = new BoardDTO();
				bdto.setBoard_no (rs.getInt("번호"));//board_no
				bdto.setTitle (rs.getString("제목"));//title
				bdto.setContent (rs.getString("내용"));//content
				bdto.setUser_id (rs.getString("이름"));//user_id
				bdto.setReg_date (rs.getString("생성시간"));//reg_date
					
				board.put ("board_no", bdto.getBoard_no ());
				board.put ("title", bdto.getTitle ());
				board.put ("content", bdto.getContent ());
				board.put ("user_id", bdto.getUser_id ());
				board.put ("reg_date", bdto.getReg_date ());
				
				boardList.add (board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println ("연결실패");
		}finally {
			if( rs != null ) try { rs.close(); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}//end finally
	}//end readAll
	
	private static void readAll(){
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//		ArrayList 출력
		for(int i = boardList.size() - 1 ; i >= 0 ; i--) {
			
			HashMap<String, Object> board = new HashMap<>();	
			board = boardList.get (i);
			System.out.println (board.get ("board_no")
					+ "\t\t" + board.get ("title")
					+ "\t\t" + board.get ("content")
					+ "\t\t" + board.get ("user_id")
					+ "\t\t" + board.get ("reg_date")
					);
		}
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	
	private static void read() {
		HashMap<String, Object> board = new HashMap<>();	
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
			case 2:
				delete(board);
				break;
			case 0:
				System.out.println ("목록으로");
				break;
		}//end switch
	}//end read method
	
	private static void insert() {
		System.out.print ("제목>");
		String title = ScanUtil.nextLine ();
		System.out.print ("내용>");
		String content = ScanUtil.nextLine ();
		System.out.print ("작성자>");
		String user_id = ScanUtil.nextLine ();
		
		try {
//			db연결
			con = DriverManager.getConnection (url,id,pw);
//			쿼리 작성
			String sql = "INSERT INTO TB_JDBC_BOARD(BOARD_NO,TITLE,CONTENT,USER_ID,REG_DATE)\r\n"
					+ "VALUES(BOARD_NO_SEQ.NEXTVAL,?,?,?,sysdate)";
//			쿼리 실행
			ps = con.prepareStatement(sql);
			ps.setObject (1, title);
			ps.setObject (2, content);
			ps.setObject (3, user_id);
//			쿼리결과 삽입
			int result = ps.executeUpdate ();
			if(0<result) {
				System.out.println (result + "개 행이 삽입되었습니다.");
			}else {
				System.out.println ("등록이 실패하였습니다.");
			}//close if-else
			selectInsertAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			객체 반환
//			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}
	}
	
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
							+ " SET TITLE = ?,"
							+ " CONTENT = ?"
							+ " WHERE BOARD_NO = ? ";
//			쿼리실행
			ps = con.prepareStatement (sql);
			ps.setObject (1, board.get ("title"));
			ps.setObject (2, board.get ("content"));
			ps.setObject (3, board.get ("board_no"));
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
	
	private static void delete(HashMap<String, Object> board){	
		try {
//			db 연결
			con = DriverManager.getConnection (url,id,pw);
//			쿼리작성
			String sql = "DELETE FROM TB_JDBC_BOARD WHERE BOARD_NO = ? ";
//			쿼리실행
			ps = con.prepareStatement (sql);
			ps.setObject (1, board.get ("board_no"));
//			쿼리결과 삽입
			int result = ps.executeUpdate ();
			System.out.println (result + "개 행이 삭제되었습니다.");
			selectInsertAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			객체 반환
//			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}
	}
}
