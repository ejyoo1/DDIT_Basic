package sub;

import java.util.Scanner;

public class DyingMessage {
	static int hintcount = 0;
	public static void main (String[] args) {
		
		System.out.println("다잉메세지. 소설가가 남긴 마지막 메세지");
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		int count = 0;//게임 라운드를 출력하기 위한 카운트
		
		while(true) {
			DyingMessage dm = new DyingMessage();
			
			count++;
			System.out.println ("범인을 찾아주세요!");
			dm.showCardList();//카드 목록을 출력하는 메서드
			dm.userMenuSettings();//메뉴 목록을 출력하는 메서드
			System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■"+count+"번째 판입니다.■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			
		}
	}
	
	void showCardList() {
		Card cd = new Card();
		
		System.out.println("소설가의 마지막 문장을 보고 '범인', '살해동기', '살해도구'를 맞춰주세요");
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		System.out.print ("■범인목록■");
		cd.cardPrintln("criminal");
		System.out.println ();
		
		System.out.print ("■살해동기■ ");
		cd.cardPrintln("motivation");
		System.out.println ();
		
		System.out.print ("■살해도구■ ");
		cd.cardPrintln("tool");
		System.out.println ();
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		System.out.println ();
		
	}
	void userMenuSettings() {
		Scanner sc = new Scanner(System.in);
		User dm = new User();
		System.out.println (dm.userMenu (hintcount));
		String userInput1 = sc.nextLine ();
		switch(userInput1) {
			case "힌트얻기" :
				hintcount = dm.userHint(hintcount);
				break;
			case "정답맞추기" :
				dm.userSuccess ();
				break;
			case "게임종료" : 
				dm.userDistory ();
				break;
			case "정답보기" :
				dm.userAnswer ();
				break;
			default : 
				System.out.println ("없는메뉴입니다. 다시 입력해주세요.");
				userMenuSettings();
				break;
		}
	}
}
