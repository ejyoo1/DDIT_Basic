package sub;

import java.util.Arrays;
import java.util.Scanner;

public class User {
	String userMenu(int hintcount) {
		String userSetMenu;
		if(hintcount==0 || hintcount==1 || hintcount==2) {
			userSetMenu = "당신은 힌트를 얻겠습니까? 정답을 맞추시겠습니까? (힌트얻기 / 정답맞추기 / 정답보기 / 게임종료)";
		}else {
			System.out.println ("힌트 기회를 모두 사용하였습니다. 당신은 이제 소설가를 죽인 범인을 잡아야합니다.");
			userSetMenu = "정답을 맞추시겠습니까? 포기하고 정답을 보겠습니까? (정답맞추기 / 정답보기)";
		}
		return userSetMenu;
	}
	
	int userHint(int hintcount) {
		hintcount++;
		System.out.println ((hintcount)+"번째 힌트입니다.");
		Hint ht;
		if(hintcount==1) {
			ht = new Hint("범인힌트1-1","범인힌트1-2","살해동기1-1","살해동기1-2","도구1-1","도구1-2");
			ht.hintPrintln (hintcount);
			System.out.println ("첫번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			reasoningProcess();
		}else if(hintcount==2) {
			ht = new Hint("범인힌트2-1","범인힌트2-2","살해동기2-1","살해동기2-2","도구2-1","도구2-2");
			ht.hintPrintln (hintcount);
		}else if(hintcount==3) {
			ht = new Hint("범인힌트3-1","범인힌트3-2","살해동기3-1","살해동기3-2","도구3-1","도구3-2");
			ht.hintPrintln (hintcount);
		}
		return hintcount;
	}
	
	void reasoningProcess(){//추리 시 try 관련 질문
		System.out.println ("선택한 6장의 카드를 제거하겠습니까? (YES/NO)");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine ();
		if(userInput.equals ("YES")) {
			//검사
		}else {
			
		}
	}
	
	void reasoningInput() {
		int userAnswerCount = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println ("[제거] 범인이 아닐 것 같은 직업이 있습니까? 있다면 입력하세요.");
			String[] userAnswerCriminal = sc.nextLine ().split (",");
			userAnswerCount += userAnswerCriminal.length;
			System.out.println ("[제거] 적합하지 않는 살해 동기가 있습니까? 있다면 입력하세요.");
			String[] userAnswerMotivation = sc.nextLine ().split (",");
			userAnswerCount += userAnswerMotivation.length;
			System.out.println ("[제거] 적합하지 않는 살해 도구가 있습니까? 있다면 입력하세요.");
			String[] userAnswerTool = sc.nextLine ().split (",");
			userAnswerCount += userAnswerTool.length;
			System.out.println (userAnswerCount);
			if(userAnswerCount<6) {
				System.out.println ("제거할 카드를 적게 입력하였습니다. 이번 사건과 관련 없는 카드를 6개 입력해야 합니다.");
				userAnswerCount = 0;
			}else if(userAnswerCount>6){
				System.out.println ("제거할 카드를 많이 입력하였습니다. 이번 사건과 관련 없는 카드를 6개 입력해야 합니다.");
				userAnswerCount = 0;
			}else {//선택한 카드가 6장인 경우 
				reasoningProcess();
				break;
			}
		}
	}
	
	
	
	void userSuccess() {
		Scanner sc = new Scanner(System.in);
		System.out.println ("정답을 입력하세요. [정답입력형식] : '범인,범행동기,범행도구'");
		String[] userInputAnswer = sc.nextLine ().split (",");
		if(userInputAnswer[0].equals ("복서")) {
			System.out.println ("범인같음");
		}else {
			System.out.println ("범인다름");
		}
	}
	
	void userDistory() {
		System.out.println ("게임을 종료합니다.");
		System.exit (0);
	}
	
	void userAnswer() {
		System.out.println ("정답은 : [범인 : " + Card.round_answer[0] + " ], [범행동기 : " + Card.round_answer[1] + " ], [범행도구 : " + Card.round_answer[2] + "] 입니다.");
		userDistory();
	}
}
