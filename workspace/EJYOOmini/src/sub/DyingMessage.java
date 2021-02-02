package sub;

import java.util.Scanner;

public class DyingMessage{
	static int hintcount = 1;
	static String criminalHint = "";
	static String motivationHint = "";
	static String toolHint = "";
	static int criminalCountNum = 1;
	static int motivationCountNum = 1;
	static int toolCountNum = 1;
	
	public static void main (String[] args) {
		
		System.out.println("다잉메세지. 소설가가 남긴 마지막 메세지");

		
		
		while(true) {
			DyingMessage dm = new DyingMessage();
			if(hintcount==5) {
				dm.userMenuSettings();//메뉴 목록을 출력하는 메서드
				break;
			}
			System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■"+hintcount+"번째 판입니다.■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println ("범인을 찾아주세요!");
			dm.showCardList();//카드 목록을 출력하는 메서드
			dm.userMenuSettings();//메뉴 목록을 출력하는 메서드
			
		}
	}
	
	void showCardList() {//첫 시작 시 깔린 카드의 현황을 보여주는 메서드
		Card cd = new Card();
		
		System.out.println("소설가의 마지막 문장을 보고 '범인', '살해동기', '살해도구'를 맞춰주세요");
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		System.out.print ("■범인목록■ ");
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
	
	
	String userMenu() {//제공된 힌트수에 따라 힌트 제한
		String userSetMenu;
		if(hintcount==1 || hintcount==2 || hintcount==3|| hintcount==4 ) {//힌트를 3회까지 얻을 수 있음.
			userSetMenu = "당신은 힌트를 얻겠습니까? 정답을 맞추시겠습니까? (힌트얻기 / 정답맞추기 / 정답보기 / 게임종료)";
		}else {//힌트 3회를 모두 소진하는 경우]
			System.out.println (hintcount);
			System.out.println ("힌트 기회를 모두 사용하였습니다. 당신은 이제 소설가를 죽인 범인을 잡아야합니다.");
			userSetMenu = "정답을 맞추시겠습니까? 포기하고 정답을 보겠습니까? (정답맞추기 / 정답보기)";
		}
		return userSetMenu;
	}
	
	
	void userMenuSettings() {//메뉴 목록을 세팅해주는 메서드
		Scanner sc = new Scanner(System.in);
		DyingMessage dm = new DyingMessage();
		Hint hints = new Hint();
		User users = new User();
		System.out.println (dm.userMenu());
		String userInput1 = sc.nextLine ();
		switch(userInput1) {
			case "힌트얻기" :
				hintcount = hints.userHint(hintcount);
				break;
			case "정답맞추기" :
				users.userSuccess ();
				break;
			case "게임종료" : 
				users.userDistory ();
				break;
			case "정답보기" :
				users.userAnswer ();
				break;
			default : 
				System.out.println ("없는메뉴입니다. 다시 입력해주세요.");
				userMenuSettings();
				break;
		}
	}
}
