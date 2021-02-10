package i_api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class BoardTeacher {
	public static void main (String[] args) {
		ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
		
//		원하는대로 반복
		while(true) {
//			목록출력
			System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println ("번호\t제목\t작성자\t작성일");
			System.out.println ("---------------------------------------------");
//			최신 등록된 글부터 출력을 하기위해 for문을 뒤로부터 돌림.
			for(int i = boardList.size() - 1 ; i >= 0 ; i--) {
				HashMap<String, Object> board = boardList.get (i);
				System.out.println (board.get ("board_no")
						+ "\t" + board.get ("title")
						+ "\t" + board.get ("user")
						+ "\t" + board.get ("reg_date")
						);
			}
			System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			
//			사용자 입력할 수 있도록 안내
			System.out.println ("1.조회\t2.등록\t0.종료");
			System.out.print ("입력>");
			int input = ScanUtil.nextInt ();
			
			switch(input) {
				case 1:
					read(boardList);
					break;
				case 2:
//					메인메서드에서 생성한 boardList를 담음. 이게 싫으면 전역변수로 뺌
					insert(boardList);
					break;
				case 0:
					System.out.println ("프로그램이 종료되었습니다.");
					System.exit(0);
					break;
			}//close switch
		}//close while
	}//close main
	
//	메인메서드에서 호출하려면 static을 붙일 것. 
//	그게 아니면 class 객체를 생성해야되는데 main과 분리가 되지 않아 따로 class를 생성해야됨.
//	입력 메서드
	private static void insert(ArrayList<HashMap<String, Object>> boardList) {
		
		int max = 0;
		for(int i = 0 ; i < boardList.size (); i++) {
			if(max < (Integer)boardList.get (i).get ("board_no")) {
				max = (Integer)boardList.get (i).get ("board_no");
			}
		}
		int boardNo = max + 1;
//		System.out.print ("번호>");
//		int boardNo = ScanUtil.nextInt ();
		System.out.print ("제목>");
		String title = ScanUtil.nextLine ();
		System.out.print ("내용>");
		String content = ScanUtil.nextLine ();
		System.out.print ("이름>");
		String user = ScanUtil.nextLine ();
		
		HashMap<String, Object> board = new HashMap<>();
		board.put ("board_no", boardNo);
		board.put ("title", title);
		board.put ("content", content);
		board.put ("user", user);
		board.put ("reg_date", new Date());
		
		boardList.add (board);
		System.out.println ("게시물 등록이 완료되었습니다.");	
	}


//	조회 메서드
	private static void read(ArrayList<HashMap<String, Object>> boardList) {
		System.out.println ("게시글 번호 입력>");
		int boardNo = ScanUtil.nextInt();
//		검색된 해쉬맵 저장 변수
		HashMap<String, Object> board = new HashMap();
//		테이블에서 게시글 번호 검색
		for(int i = 0 ; i < boardList.size () ; i++) {
//			내가 입력한 번호와 보드 내 저장된 해쉬 키와 동일한경우
			if((Integer)boardList.get (i).get ("board_no") == boardNo) {
//				리스트를 저장
				board = boardList.get (i);
				break;
			}//end if
		}//end for
		
//		게시글 출력
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println ("번호\t: " + board.get ("board_no"));
		System.out.println ("작성자\t: " + board.get ("user"));
		System.out.println ("작성일\t: " + board.get ("reg_date"));
		System.out.println ("제목\t: " + board.get ("title"));
		System.out.println ("내용\t: " + board.get ("content"));
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println ("---------------------------------------------");
		System.out.println ("1.수정\t2.삭제\t0.목록");
		System.out.println ("입력>");
		int input = ScanUtil.nextInt ();
		
		switch (input) {
			case 1:
				update(board);
				break;
			case 2:
				delete(boardList, board);
				break;
		}
		
	}

//	업데이트
	private static void update(HashMap<String, Object> board) {
		System.out.println ("제목>");
		String title = ScanUtil.nextLine ();
		System.out.println ("내용>");
		String content = ScanUtil.nextLine ();
		
		board.put("title", title);
		board.put("content", content);
		
		System.out.println ("수정 완료되었습니다.");
	}	
	
//	삭제
	private static void delete(ArrayList<HashMap<String, Object>> boardList, HashMap<String, Object> board) {
		for(int i = 0 ; i < boardList.size () ; i++) {
			if(boardList.get (i).get ("board_no") == board.get ("board_no")) {
				boardList.remove (i);
				System.out.println ("삭제가 완료되었습니다.");
				break;
			}
		}
			
		
	}
		
}
