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
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			reasoningInput();
		}else if(hintcount==2) {
			ht = new Hint("범인힌트2-1","범인힌트2-2","살해동기2-1","살해동기2-2","도구2-1","도구2-2");
			ht.hintPrintln (hintcount);
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			reasoningInput();
		}else if(hintcount==3) {
			ht = new Hint("범인힌트3-1","범인힌트3-2","살해동기3-1","살해동기3-2","도구3-1","도구3-2");
			ht.hintPrintln (hintcount);
			System.out.println (hintcount+"번째 추리를 시작합니다. 이번 사건과 관련없는 카드 6개를 입력하세요. [카드입력형식] : '카드이름1,카드이름2,...,카드이름5'");
			reasoningInput();
		}
		return hintcount;
	}
	
	void reasoningProcess(String[] userAnswerCriminal, String[] userAnswerMotivation, String[] userAnswerTool, boolean totalflag){//추리 시 try 관련 질문
		System.out.println ("선택한 6장의 카드를 제거하겠습니까? (YES/NO)");
		System.out.println ("입력한 범인 : " + Arrays.toString (userAnswerCriminal));
		System.out.println ("입력한 살해동기 : " + Arrays.toString (userAnswerMotivation));
		System.out.println ("입력한 살해도구 : " + Arrays.toString (userAnswerTool));
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine ();
		if(userInput.equals ("YES")) {
			Card cd = new Card();
			if(totalflag) {//추리 성공인 경우
				cd.cardDel (userAnswerCriminal, userAnswerMotivation, userAnswerTool);
			}else {//추리 실패인 경우
				System.out.println ("추리 실패하였습니다. 목숨 토큰이 차감됩니다.");
			}
		}else if(userInput.equals ("NO")) {
			System.out.println ("제거할 6장의 카드를 다시 입력해주세요.");
			reasoningInput();
		}
	}
	
	String[] inputCriminal() {
		Scanner sc = new Scanner(System.in);
		System.out.println ("[제거] 범인이 아닐 것 같은 직업이 있습니까? 있다면 입력하세요.");
		String[] userAnswerCriminal = sc.nextLine ().split (",");
		return userAnswerCriminal;
	}
	
	String[] inputMotivation() {
		Scanner sc = new Scanner(System.in);
		System.out.println ("[제거] 적합하지 않는 살해 동기가 있습니까? 있다면 입력하세요.");
		String[] userAnswerMotivation = sc.nextLine ().split (",");
		return userAnswerMotivation;
	}
	
	String[] inputTool() {
		Scanner sc = new Scanner(System.in);
		System.out.println ("[제거] 적합하지 않는 살해 도구가 있습니까? 있다면 입력하세요.");
		String[] userAnswerTool = sc.nextLine ().split (",");
		return userAnswerTool;
	}
	
	
	
	
	
	
	void reasoningInput() {//힌트를 본 후 관련없는 카드를 제거하기 위한 메서드
		Card card = new Card();
		int userAnswerCount = 0;
		
		while(true) {
			String[] userAnswerCriminal = inputCriminal();
			//유효성 검사 추가
			while(true) {
				boolean result = reasoningInputChecker(userAnswerCriminal,"Criminal");//true : 유효성검사 성공, false : 유효성 검사 실패
				if(result) {
					break;
				}else {
					System.out.println ("올바른 '범인' 카드를 입력해주세요.");
					userAnswerCriminal = inputCriminal();
				}
			}
			
			boolean criminalflag = card.cardCheckerCriminal(userAnswerCriminal);
			userAnswerCount += userAnswerCriminal.length;
			System.out.println (userAnswerCount);
			System.out.println ("criminalflag 추리 결과 : " + criminalflag);//true : 추리성공, false : 추리실패 
			if(criminalflag) {
				System.out.println ("추리성공");
			}else {
				System.out.println ("추리실패");
			}
			
			String[] userAnswerMotivation = inputMotivation();
			//유효성 검사 추가
			while(true) {
				boolean result = reasoningInputChecker(userAnswerMotivation,"Motivation");//true : 유효성검사 성공, false : 유효성 검사 실패
				if(result) {
					break;
				}else {
					System.out.println ("올바른 '살해동기' 카드를 입력해주세요.");
					userAnswerMotivation = inputMotivation();
				}
			}
						
			boolean motivationflag = card.cardCheckerMotivation(userAnswerMotivation);
			userAnswerCount += userAnswerMotivation.length;
			System.out.println (userAnswerCount);
			System.out.println ("motivationflag 추리 결과 : " + motivationflag);
			if(motivationflag) {
				System.out.println ("추리성공");
			}else {
				System.out.println ("추리실패");
			}
			
			String[] userAnswerTool = inputMotivation();
			//유효성 검사 추가
			while(true) {
				boolean result = reasoningInputChecker(userAnswerTool,"Tool");//true : 유효성검사 성공, false : 유효성 검사 실패
				if(result) {
					break;
				}else {
					System.out.println ("올바른 '살해도구' 카드를 입력해주세요.");
					userAnswerTool = inputTool();
				}
			}
			
			
			boolean toolflag = card.cardCheckTool(userAnswerTool);
			userAnswerCount += userAnswerTool.length;
			System.out.println (userAnswerCount);
			System.out.println ("toolflag 추리 결과 : " + toolflag);
			if(toolflag) {
				System.out.println ("추리성공");
			}else {
				System.out.println ("추리실패");
			}
			
			//추리 최종결과
			boolean totalflag = criminalflag&&motivationflag&&toolflag;
			System.out.println ("totalflag 결과 : " + toolflag);
			
			
			
			
			if(userAnswerCount<6) {
				System.out.println ("제거할 카드를 적게 입력하였습니다. 이번 사건과 관련 없는 카드를 6개 입력해야 합니다.");
				userAnswerCount = 0;
			}else if(userAnswerCount>6){
				System.out.println ("제거할 카드를 많이 입력하였습니다. 이번 사건과 관련 없는 카드를 6개 입력해야 합니다.");
				userAnswerCount = 0;
			}else {//선택한 카드가 6장인 경우 
				reasoningProcess(userAnswerCriminal, userAnswerMotivation, userAnswerTool, totalflag);
				break;
			}
		}
	}
	
	//사용자가 입력한 값이 제시된 카드 목록에 유효한지 검사하는 메서드
	boolean reasoningInputChecker(String[] userInput,String type){
		boolean[] flag = new boolean[userInput.length];
		if(type.equals ("Criminal")) {
			for(int i = 0 ; i < userInput.length ; i++) {
				for(int j = 0 ; j < Card.criminal.length ; j++) {
					if(userInput[i].equals (Card.criminal[j])) {
						flag[i] = true;
						break;
					}else {
						flag[i] = false;
					}
				}
			}
		}else if(type.equals ("Motivation")) {
			//Card.motivation
			for(int i = 0 ; i < userInput.length ; i++) {
				for(int j = 0 ; j < Card.motivation.length ; j++) {
					if(userInput[i].equals (Card.motivation[j])) {
						flag[i] = true;
						break;
					}else {
						flag[i] = false;
					}
				}
			}
		}else if(type.equals ("Tool")) {
			//Card.tool
			for(int i = 0 ; i < userInput.length ; i++) {
				for(int j = 0 ; j < Card.tool.length ; j++) {
					if(userInput[i].equals (Card.tool[j])) {
						flag[i] = true;
						break;
					}else {
						flag[i] = false;
					}
				}
			}
		}
		
		//최종 결과 확인
		System.out.println (Arrays.toString (flag));
		boolean result = false;
		for(int i = 0 ; i < userInput.length-1 ; i++) {
			for(int j = i ; j < userInput.length ; j++) {
				if(flag[i]&&flag[j]) {
					result = true;
				}else {
					result = false;
				}
			}
		}
		return result;
	}
	
	
	
	void userSuccess() {
		Scanner sc = new Scanner(System.in);
		System.out.println ("정답을 입력하세요. [정답입력형식] : '범인,범행동기,범행도구'");
		System.out.print ("정답을 입력하세요 >> ");
		String[] userInputAnswer = sc.nextLine ().split (",");
		if(userInputAnswer[0].equals (Card.round_answer[0]) && userInputAnswer[1].equals (Card.round_answer[1]) && userInputAnswer[2].equals (Card.round_answer[2]) ) {
			System.out.println ("userInputAnswer[0].equals (Card.round_answer[0]) 결과 : " + userInputAnswer[0].equals (Card.round_answer[0]));
			System.out.println ("userInputAnswer[1].equals (Card.round_answer[1]) 결과 : " + userInputAnswer[1].equals (Card.round_answer[1]));
			System.out.println ("userInputAnswer[2].equals (Card.round_answer[2]) 결과 : " + userInputAnswer[2].equals (Card.round_answer[2]));
			
			System.out.println ("추리에 성공하였습니다.");
			System.out.println ("게임을 종료합니다.");
			System.exit (0);
		}else {
			System.out.println ("userInputAnswer[0].equals (Card.round_answer[0]) 결과 : " + userInputAnswer[0].equals (Card.round_answer[0]));
			System.out.println ("userInputAnswer[1].equals (Card.round_answer[1]) 결과 : " + userInputAnswer[1].equals (Card.round_answer[1]));
			System.out.println ("userInputAnswer[2].equals (Card.round_answer[2]) 결과 : " + userInputAnswer[2].equals (Card.round_answer[2]));
			System.out.println ("추리에 실패하였습니다.");
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
