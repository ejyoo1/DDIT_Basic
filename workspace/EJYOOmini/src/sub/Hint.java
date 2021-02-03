package sub;

import java.util.Scanner;

public class Hint {
	static String[] criminalAdjective = {"외로운","거친","용감한","빠른"};
	static String[] criminalNoun = {"사각형","몸","기술","접촉"};
	
	static String[] motivationAdjective = {"치사한","이기적인","답답한","계산적인"};
	static String[] motivationNoun = {"머리","약속","대화","압박"};
	
	
	static String[] toolAdjective = {"딱딱한","작은","아르마운","냄새나는"};
	static String[] toolNoun = {"원","갈증","꽃","나무"};
	
	
	String criminalHint1;
	String criminalHint2;
	String motivationHint1;
	String motivationHint2;
	String toolHint1;
	String toolHint2;
	
	Hint(){	}
	
	//게임 시작 시 기본 힌트 세팅
	Hint(String criminalHint1, String criminalHint2, String motivationHint1, String motivationHint2, String toolHint1, String toolHint2){
		this.criminalHint1 		= criminalHint1;
		this.criminalHint2 		= criminalHint2;
		this.motivationHint1 	= motivationHint1;
		this.motivationHint2	= motivationHint2;
		this.toolHint1			= toolHint1;
		this.toolHint2			= toolHint2;
	}
	
	//2번째판 이상부터 선택적 힌트 설정 메서드
	static void cardCount(int criminalCountNum, int motivationCountNum, int toolCountNum) {
		Card cd = new Card();
		System.out.print ("■■ 범인 힌트 : ");
		for(int i = 0 ; i < criminalCountNum ; i++) {
			System.out.print (criminalAdjective[i] + ", " + criminalNoun[i]);
			System.out.print("★");
		}
		System.out.println ();
		cd.cardPrintln("criminal");
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		
		System.out.print ("■■ 살해동기 힌트 : ");
		for(int i = 0 ; i < motivationCountNum ; i++) {
			System.out.print (motivationAdjective[i] + ", " + motivationNoun[i]);
			System.out.print("★");
		}
		System.out.println ();
		cd.cardPrintln("motivation");
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		
		System.out.print ("■■ 범행도구 힌트 : ");
		for(int i = 0 ; i < toolCountNum ; i++) {
			System.out.print (toolAdjective[i] + ", " + toolNoun[i]);
			System.out.print("★");
		}
		System.out.println ();
		cd.cardPrintln("tool");
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
	}
	
	//선택적 힌트 출력 메서드
	void hintPrintln(int hintcount) {//힌트목록을 출력하기 위함
		Card cd = new Card();
		if(hintcount==1) {
			System.out.print ("■■ 범인 힌트 : " + criminalAdjective[0] + ", " + criminalNoun[0] + " ■■");
			System.out.println ();
			cd.cardPrintln("criminal");//범인 목록을 보기위한 메서드
			System.out.println ("---------------------------------------------------------------------------------------------");
			System.out.println ();
			
			
			System.out.print ("■■ 살해동기 힌트 : " + motivationAdjective[0] + ", " + motivationNoun[0] + " ■■");
			System.out.println ();
			cd.cardPrintln("motivation");//살해동기 목록을 보기위한 메서드
			System.out.println ("---------------------------------------------------------------------------------------------");
			System.out.println ();
			
			
			
			System.out.print ("■■ 살해도구 힌트 : " + toolAdjective[0] + ", " + toolNoun[0] + " ■■");
			System.out.println ();
			cd.cardPrintln("tool");//살해도구 목록을 보기위한 메서드
			System.out.println ("---------------------------------------------------------------------------------------------");
			System.out.println ();
		}else if(hintcount==2) {
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print ("어디에 힌트를 얻겠습니까? (범인,살해동기,살해도구) >> ");
				String userChoice = sc.nextLine();
				if(userChoice.equals ("범인")) {
					DyingMessage.criminalCountNum++;
					break;
				}else if(userChoice.equals ("살해동기")) {
					DyingMessage.motivationCountNum++;
					break;
				}else if(userChoice.equals ("살해도구")) {
					DyingMessage.toolCountNum++;
					break;
				}else {
					System.out.println ("잘못된 입력입니다. 다시 입력하세요.");
				}
			}
			cardCount(DyingMessage.criminalCountNum, DyingMessage.motivationCountNum, DyingMessage.toolCountNum);
		}else if(hintcount==3) {
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print ("어디에 힌트를 얻겠습니까? (범인,살해동기,살해도구) >> ");
				String userChoice = sc.nextLine();
				if(userChoice.equals ("범인")) {
					DyingMessage.criminalCountNum++;
					break;
				}else if(userChoice.equals ("살해동기")) {
					DyingMessage.motivationCountNum++;
					break;
				}else if(userChoice.equals ("살해도구")) {
					DyingMessage.toolCountNum++;
					break;
				}else {
					System.out.println ("잘못된 입력입니다. 다시 입력하세요.");
				}
			}
			cardCount(DyingMessage.criminalCountNum, DyingMessage.motivationCountNum, DyingMessage.toolCountNum);
		}else if(hintcount==4) {
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print ("어디에 힌트를 얻겠습니까? (범인,살해동기,살해도구) >> ");
				String userChoice = sc.nextLine();
				if(userChoice.equals ("범인")) {
					DyingMessage.criminalCountNum++;
					break;
				}else if(userChoice.equals ("살해동기")) {
					DyingMessage.motivationCountNum++;
					break;
				}else if(userChoice.equals ("살해도구")) {
					DyingMessage.toolCountNum++;
					break;
				}else {
					System.out.println ("잘못된 입력입니다. 다시 입력하세요.");
				}
			}
			cardCount(DyingMessage.criminalCountNum, DyingMessage.motivationCountNum, DyingMessage.toolCountNum);
		}
	}
	
	//힌트 제공받은 후 사용자 추리 시작을 알리는 메서드
	int userHint(int hintcount) {
		User users = new User();
		
		System.out.println ((hintcount)+"번째 힌트입니다.");
		Hint ht = new Hint();
		if(hintcount==1) {
			cardCount(DyingMessage.criminalCountNum, DyingMessage.motivationCountNum, DyingMessage.toolCountNum);
			users.reasoningInput(hintcount);
			hintcount++;
		}else if(hintcount==2) {
			ht.hintPrintln (hintcount);
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			users.reasoningInput(hintcount);
			hintcount++;
		}else if(hintcount==3) {
			ht.hintPrintln (hintcount);
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			users.reasoningInput(hintcount);
			hintcount++;
		}else if(hintcount==4) {
			ht.hintPrintln (hintcount);
			System.out.println ("사용할 수 있는 힌트가 모두 소진되었습니다.");
			DyingMessage.userMenu();
			hintcount++;
		}
		return hintcount;
	}
	
}
