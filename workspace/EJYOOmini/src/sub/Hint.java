package sub;

import java.util.Scanner;

public class Hint {
	String[] criminalAdjective = {"외로운","거친","용감한","빠른"};
	String[] criminalNoun = {"사각형","몸","기술","접촉"};
	int criminalCount = 1;
	
	String[] motivationAdjective = {"치사한","이기적인","답답한","계산적인"};
	String[] motivationNoun = {"머리","약속","대화","압박"};
	int motivationCount = 1;
	
	String[] toolAdjective = {"딱딱한","작은","아르마운","냄새나는"};
	String[] toolNoun = {"원","갈증","꽃","나무"};
	int toolCount = 1;
	
	String criminalHint1;
	String criminalHint2;
	String motivationHint1;
	String motivationHint2;
	String toolHint1;
	String toolHint2;
	
	Hint(){	}
	
	Hint(String criminalHint1, String criminalHint2, String motivationHint1, String motivationHint2, String toolHint1, String toolHint2){
		this.criminalHint1 		= criminalHint1;
		this.criminalHint2 		= criminalHint2;
		this.motivationHint1 	= motivationHint1;
		this.motivationHint2	= motivationHint2;
		this.toolHint1			= toolHint1;
		this.toolHint2			= toolHint2;
	}
	void criminalCount(int count) {
		Card cd = new Card();
		System.out.println ("count : " + count);
		System.out.print ("■■ 범인 힌트 : ");
		for(int i = 0 ; i < count ; i++) {
			System.out.print (criminalAdjective[i] + ", " + criminalNoun[i]);
			System.out.print("★");
		}
		System.out.println ();
		cd.cardPrintln("criminal");
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
	}
	
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
			System.out.print ("어디에 힌트를 얻겠습니까? (범인,살해동기,살해도구) >> ");
			String userChoice = sc.nextLine();
			if(userChoice.equals ("범인")) {
				criminalCount(hintcount);
			}
		}else if(hintcount==3) {
			Scanner sc = new Scanner(System.in);
			System.out.print ("어디에 힌트를 얻겠습니까? (범인,살해동기,살해도구) >> ");
			String userChoice = sc.nextLine();
			if(userChoice.equals ("범인")) {
				criminalCount(hintcount);
			}
		}else if(hintcount==4) {
			Scanner sc = new Scanner(System.in);
			System.out.print ("어디에 힌트를 얻겠습니까? (범인,살해동기,살해도구) >> ");
			String userChoice = sc.nextLine();
			if(userChoice.equals ("범인")) {
				criminalCount(hintcount);
			}
		}
		
		
		
		/*
		System.out.print ("■■ 범인 힌트" + (hintcount) +  " : " + criminalHint1 + ", " + criminalHint2 + " ■■");
		System.out.println ();
		cd.cardPrintln("criminal");//범인 목록을 보기위한 메서드
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		
		
		System.out.print ("■■ 살해동기 힌트" + (hintcount) +  " : " + motivationHint1 + ", " + motivationHint2 + " ■■");
		System.out.println ();
		cd.cardPrintln("motivation");//살해동기 목록을 보기위한 메서드
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		
		
		
		System.out.print ("■■ 살해도구 힌트" + (hintcount) +  " : " + toolHint1 + ", " + toolHint2 + " ■■");
		System.out.println ();
		cd.cardPrintln("tool");//살해도구 목록을 보기위한 메서드
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		*/
	}
	
	
	
	
	int userHint(int hintcount) {
		User users = new User();
		
		System.out.println ((hintcount)+"번째 힌트입니다.");
		Hint ht;
		if(hintcount==1) {
			ht = new Hint("외로운","사각형","치사한","머리","딱딱한","원");
			
			/*
			DyingMessage.criminalHint += (ht.criminalHint1 + "," + ht.criminalHint2+",");
			System.out.println ("criminalHint : " + DyingMessage.criminalHint);
			DyingMessage.motivationHint += (ht.motivationHint1 + "," + ht.motivationHint2+",");
			System.out.println ("motivationHint : " + DyingMessage.motivationHint);
			DyingMessage.toolHint += (ht.toolHint1 + "," + ht.toolHint2+",");
			System.out.println ("toolHint : " + DyingMessage.toolHint);
			*/
			
			ht.hintPrintln (hintcount);
			users.reasoningInput(hintcount);
			hintcount++;
		}else if(hintcount==2) {
			ht = new Hint("거친","몸","이기적인","약속","작은","갈증");
			
			/*
			DyingMessage.criminalHint += (ht.criminalHint1 + "," + ht.criminalHint2+",");
			System.out.println ("criminalHint : " + DyingMessage.criminalHint);
			DyingMessage.motivationHint += (ht.motivationHint1 + "," + ht.motivationHint2+",");
			System.out.println ("motivationHint : " + DyingMessage.motivationHint);
			DyingMessage.toolHint += (ht.toolHint1 + "," + ht.toolHint2+",");
			System.out.println ("toolHint : " + DyingMessage.toolHint);
			*/
			
			ht.hintPrintln (hintcount);
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			users.reasoningInput(hintcount);
			hintcount++;
		}else if(hintcount==3) {
			ht = new Hint("용감한","기술","답답한","대화","아름다운","꽃");
			
			/*
			DyingMessage.criminalHint += (ht.criminalHint1 + "," + ht.criminalHint2+",");
			System.out.println ("criminalHint : " + DyingMessage.criminalHint);
			DyingMessage.motivationHint += (ht.motivationHint1 + "," + ht.motivationHint2+",");
			System.out.println ("motivationHint : " + DyingMessage.motivationHint);
			DyingMessage.toolHint += (ht.toolHint1 + "," + ht.toolHint2+",");
			System.out.println ("toolHint : " + DyingMessage.toolHint);
			*/
			
			ht.hintPrintln (hintcount);
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			users.reasoningInput(hintcount);
			hintcount++;
		}else if(hintcount==4) {
			DyingMessage dm = new DyingMessage();
			ht = new Hint("빠른","접촉","계산적인","압박","냄새나는","나무");
			
			DyingMessage.criminalHint += (ht.criminalHint1 + "," + ht.criminalHint2);
			System.out.println ("criminalHint : " + DyingMessage.criminalHint);
			DyingMessage.motivationHint += (ht.motivationHint1 + "," + ht.motivationHint2);
			System.out.println ("motivationHint : " + DyingMessage.motivationHint);
			DyingMessage.toolHint += (ht.toolHint1 + "," + ht.toolHint2);
			System.out.println ("toolHint : " + DyingMessage.toolHint);
			
			ht.hintPrintln (hintcount);
			System.out.println ("사용할 수 있는 힌트가 모두 소진되었습니다.");
			dm.userMenu();
			hintcount++;
		}
		return hintcount;
	}
	
}
