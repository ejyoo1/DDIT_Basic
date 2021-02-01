package sub;

public class Hint {
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
	
	
	void hintPrintln(int count) {//힌트목록을 출력하기 위함
		Card cd = new Card();
		System.out.print ("■■ 범인 힌트" + (count) +  " : " + criminalHint1 + ", " + criminalHint2 + " ■■");
		System.out.println ();
		cd.cardPrintln("criminal");//범인 목록을 보기위한 메서드
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		
		
		System.out.print ("■■ 살해동기 힌트" + (count) +  " : " + motivationHint1 + ", " + motivationHint2 + " ■■");
		System.out.println ();
		cd.cardPrintln("motivation");//살해동기 목록을 보기위한 메서드
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		
		
		
		System.out.print ("■■ 살해도구 힌트" + (count) +  " : " + toolHint1 + ", " + toolHint2 + " ■■");
		System.out.println ();
		cd.cardPrintln("tool");//살해도구 목록을 보기위한 메서드
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
	}
	
	
	
	
	int userHint(int hintcount) {
		User users = new User();
		int criminalHintCnt = 0;
		int motivationHintCnt = 0;
		int toolHintCnt = 0;
		String criminalHint = "";
		String motivationHint = "";
		String toolHint = "";
		hintcount++;
		System.out.println ((hintcount)+"번째 힌트입니다.");
		Hint ht;
		if(hintcount==1) {
			ht = new Hint("외로운","사각형","치사한","머리","딱딱한","원");
			
			
			criminalHint += (ht.criminalHint1 + "," + ht.criminalHint2);
			System.out.println ("criminalHint : " + criminalHint);
			motivationHint += (ht.motivationHint1 + "," + ht.motivationHint2);
			System.out.println ("motivationHint : " + motivationHint);
			toolHint += (ht.toolHint1 + "," + ht.toolHint2);
			System.out.println ("toolHint : " + toolHint);
			
			
			ht.hintPrintln (hintcount);
			users.reasoningInput(hintcount);
		}else if(hintcount==2) {
			ht = new Hint("거친","몸","이기적인","약속","작은","갈증");
			ht.hintPrintln (hintcount);
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			users.reasoningInput(hintcount);
		}else if(hintcount==3) {
			ht = new Hint("용감한","기술","답답한","대화","아름다운","꽃");
			ht.hintPrintln (hintcount);
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			users.reasoningInput(hintcount);
		}else if(hintcount==4) {
			DyingMessage dm = new DyingMessage();
			ht = new Hint("빠른","접촉","계산적인","압박","냄새나는","나무");
			ht.hintPrintln (hintcount);
			System.out.println ("사용할 수 있는 힌트가 모두 소진되었습니다.");
			hintcount++;
			dm.userMenu(hintcount);
		}
		return hintcount;
	}
}
