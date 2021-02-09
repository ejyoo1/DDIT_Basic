package i_api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Board {
	static String userName = "홍길동";
	static int number = 0;
	static ArrayList<HashMap<String,Object>> arrList = new ArrayList<>();//테이블 생성
	static HashMap<String,Object> hm;//테이블 한줄 생성
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고
		 * 조회,등록,수정,삭제가 가능한 게시판을 만들어주세요
		 * 
		 * 번호(PK), 제목, 내용, 작성자, 작성일
		 * 
		 * ----------------------------
		 * 번호	제목	작성자	작성일
		 * ----------------------------
		 * 1. 안녕하세요 홍길동 2/9
		 * 2. 안녕하세요 홍길동 2/9
		 * 3. 안녕하세요 홍길동 2/9
		 * 4. 안녕하세요 홍길동 2/9
		 * ----------------------------
		 * 1. 조회 2.등록 3.종료
		 * 
		 * 조회 후 수정 삭제 가능
		 * 
		 * */
		introMenu();
		
		
		
		
		
		

		
		
	}
	
	static void introMenu() {
		while(true) {
			resultPrint(arrList);
			System.out.println ("1. 조회\t\t2.등록\t\t3.종료");
			System.out.println ("원하는 메뉴 입력 >> ");
			String userMenu = sc.nextLine ();
			if(userMenu.equals ("1")) {
				if(!arrList.isEmpty()) {
					System.out.println ("조회합니다.");
					resultPrint(arrList);
					updateMenu();
				}else {
					System.out.println ("등록된 게시글이 없습니다.");
				}
			}else if(userMenu.equals ("2")) {
				System.out.println ("등록합니다.");
				inputData();
			}else if(userMenu.equals("3")) {
				System.out.println ("종료합니다.");
				System.exit (0);
			}else {
				System.out.println ("재입력");
			}
			System.arraycopy (userMenu, number, userMenu, number, number);
		}
	}
	//수정메뉴
	static void updateMenu(){
		System.out.println ("1. 수정\t\t2.삭제\t\t3.이전으로");
		while(true) {
			System.out.print ("번호 입력 >>");
			String input = sc.nextLine ();
			if(input.equals ("1")) {
				updateChoice();
				break;
			}else if(input.equals ("2")){
				deleteChoice();
				break;
			}else {
				System.out.println ("다시입력");
			}
		}
	}
//	삭제 게시글 선택 메서드
	static void deleteChoice(){
		resultPrint(arrList);
		System.out.print ("삭제할 게시글 번호 입력 >>");
		int input = Integer.parseInt (sc.nextLine());
		boardPrint(input);
		deleteData(input);
	}
	
//	삭제 적용 메서드
	static void deleteData(int input) {
		System.out.println ("정말 게시글을 삭제하시겠습니까? (yes/no) >>");
		String boardInput = sc.nextLine ();
		if(boardInput.equalsIgnoreCase ("YES")) {
			arrList.remove(input-1);
			System.out.println ("게시글이 삭제되었습니다.");
			indexReassign();
		}else {
			System.out.println ("게시글이 삭제되지 않았습니다.");
		}
		
	}
	
	static void indexReassign() {
		number = 0;
		for(int i = 0 ; i < arrList.size (); i++) {
			HashMap<String,Object> al = arrList.get (i);
			number++;
			al.put ("num", number);
		}
		
	}
	
	
	
//	수정메서드
	static void updateChoice(){
		resultPrint(arrList);
		System.out.print ("수정할 게시글 번호 입력 >>");
		int input = Integer.parseInt (sc.nextLine());
		boardPrint(input);
		updateData(input);
	}
	
	static void updateData(int input) {
		System.out.println ("게시글 수정 내용 입력");
		String boardInput = sc.nextLine ();
		HashMap<String, Object> al = arrList.get(input-1);
		al.put ("contents", boardInput);
	}
	
	static void boardPrint(int input) {
//		출력
		System.out.println ("-------------------------게시판-------------------------");
		System.out.println ("제목\t\t내용\t\t작성일");
		System.out.println ("------------------------------------------------------");
		
//		arrList에 저장된 HashMap 추출
		HashMap<String,Object> al = arrList.get (input-1);
		System.out.println (al.get ("title") + "\t\t" + al.get ("contents") + "\t\t" + al.get ("create"));

		System.out.println ("------------------------------------------------------");
	}

	
	
//	등록 메서드
	static void inputData() {
		hm = new HashMap<>();
		number++;
		
		String input; 
		
//		번호 자동 부여
		hm.put ("num", number);
		
		
//		게시글 제목 입력
		System.out.print ("게시글 제목 입력 >> ");
		input = sc.nextLine ();
		hm.put ("title", input);
		
//		게시글 내용 입력
		System.out.print ("게시글 내용 입력 >> ");
		input = sc.nextLine ();
		hm.put ("contents", input);
		
//		작성자 입력
		hm.put ("name", userName);
		
		
//		작성일
//		오늘날짜 가져옴
		Calendar today = Calendar.getInstance ();
//		today.get (Calendar.MONTH); //달
//		today.get (Calendar.DATE);	//일
		String nMonthDay = Integer.toString (today.get (Calendar.MONTH) + 1) + "/" + Integer.toString (today.get (Calendar.DATE));
		hm.put ("create", nMonthDay);
		
		arrList.add (hm);
	}
	
	
	
//	최종결과 출력하는 메서드
	static void resultPrint(ArrayList<HashMap<String,Object>> arrList) {
//		출력
		System.out.println ("-------------------------게시판-------------------------");
		System.out.println ("번호\t\t제목\t\t작성자\t\t작성일");
		System.out.println ("------------------------------------------------------");
		for(int i = 0 ; i < arrList.size () ; i++) {
//			arrList에 저장된 HashMap 추출
			HashMap<String,Object> al = arrList.get (i);
			System.out.println (al.get ("num") + "\t\t" + al.get ("title") + "\t\t" + al.get ("name") + "\t\t" + al.get ("create") + "\t\t");
		}
		System.out.println ("------------------------------------------------------");
	}
	
}
