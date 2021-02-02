package sub;

import java.util.Arrays;
import java.util.Scanner;

public class User {
	boolean criminalVerification(String[] userAnswer) {//유효성 검사 추가
		boolean flag = false;
		boolean result = reasoningInputChecker(userAnswer,"Criminal");//true : 유효성검사 성공, false : 유효성 검사 실패
			//System.out.println ("result : " + result);
		if(result) {
			flag = criminalCardCheck(userAnswer);//true ; 추리 성공 false : 추리 실패
		}else {
			System.out.println ("올바른 '범인' 카드를 입력해주세요.");
			reasoningInput(DyingMessage.hintcount);
		}
		System.out.println ("criminalVerification 메서드 종료");
		return flag;
	}
	
	boolean criminalCardCheck(String[] userAnswer) {//제거할 값이 추리 성공인지 확인
		Card card = new Card();
		boolean criminalflag = card.cardCheckerCriminal(userAnswer);
		return criminalflag;
	}
	
	boolean motivationVerification(String[] userAnswer) {//유효성 검사 추가
		boolean flag = false;
		boolean result = reasoningInputChecker(userAnswer,"Motivation");//true : 유효성검사 성공, false : 유효성 검사 실패
			//System.out.println ("result : " + result);
		if(result) {
			flag = motivationCardCheck(userAnswer);//true ; 추리 성공 false : 추리 실패
		}else {
			System.out.println ("올바른 '살해동기' 카드를 입력해주세요.");
			reasoningInput(DyingMessage.hintcount);
		}
		System.out.println ("motivationVerification 메서드 종료");
		return flag;
	}
	
	boolean motivationCardCheck(String[] userAnswer) { 
		Card card = new Card();
		boolean motivationflag = card.cardCheckerMotivation(userAnswer);
		return motivationflag;
	}
	
	
	boolean toolVerification(String[] userAnswer) {//유효성 검사 추가
		boolean flag = false;
		boolean result = reasoningInputChecker(userAnswer,"Tool");//true : 유효성검사 성공, false : 유효성 검사 실패
		//System.out.println ("result : " + result);
		if(result) {
			flag = toolCardCheck(userAnswer);
		}else {
			System.out.println ("올바른 '살해도구' 카드를 입력해주세요.");
			userAnswer = inputTool();
		}
		System.out.println ("toolVerification 메서드 종료");
		return flag;
	}
	
	boolean toolCardCheck(String[] userAnswer) {
		Card card = new Card();
		boolean toolflag = card.cardCheckerTool(userAnswer);
		return toolflag;
	}
	
	String[] reasoningInputCriminal(int hintcount) {
		String[] userAnswerCriminal = null;
		DyingMessage.criminalflag = true;
		userAnswerCriminal = inputCriminal();
		
		if(!userAnswerCriminal[0].equals ("NO")) {
			DyingMessage.criminalflag = criminalVerification(userAnswerCriminal);
			System.out.println ("■ criminalflag : " + DyingMessage.criminalflag);
			DyingMessage.userAnswerCount += userAnswerCriminal.length;
		}else {
			userAnswerCriminal = null;
		}
		return userAnswerCriminal;
	}
	
	String[] reasoningInputMotivation(int hintcount) {
		String[] userAnswerMotivation = null;
		DyingMessage.motivationflag = true;
		userAnswerMotivation = inputMotivation();
		
		if(!userAnswerMotivation[0].equals ("NO")) {
			DyingMessage.motivationflag = motivationVerification(userAnswerMotivation);
			System.out.println ("■ motivationflag : " + DyingMessage.motivationflag);
			DyingMessage.userAnswerCount += userAnswerMotivation.length;
		}else {
			userAnswerMotivation = null;
		}
		return userAnswerMotivation;
	}
	
	String[] reasoningInputTool(int hintcount) {
		String[] userAnswerTool = null;
		DyingMessage.toolflag = true;
		userAnswerTool = inputTool();
		
		if(!userAnswerTool[0].equals ("NO")) {
			DyingMessage.toolflag = toolVerification(userAnswerTool);
			System.out.println ("■ toolflag : " + DyingMessage.toolflag);
			DyingMessage.userAnswerCount += userAnswerTool.length;
		}else {
			userAnswerTool = null;
		}
		return userAnswerTool;
	}
	
	void reasoningInput(int hintcount) {//힌트를 본 후 관련없는 카드를 제거하기 위한 메서드
		//System.out.println ("reasoningInput 호출");
		DyingMessage.userAnswerCount = 0;
		
		String[] userAnswerCriminal = null;
		String[] userAnswerMotivation = null;
		String[] userAnswerTool = null;
		
		while(true) {//카드가 6장이 아닌경우에 계속 반복 : 6장이면 반복을 하지 않음.
			userAnswerCriminal = reasoningInputCriminal(hintcount);
			System.out.println ("■ userAnswerCriminal 입력 완료.");
			
			userAnswerMotivation = reasoningInputMotivation(hintcount);
			System.out.println ("■ userAnswerMotivation 입력 완료.");
			
			
			userAnswerTool = reasoningInputTool(hintcount);	
			System.out.println ("■ userAnswerTool 입력 완료.");
				
			//추리 최종결과
			boolean totalflag = DyingMessage.criminalflag&&DyingMessage.motivationflag&&DyingMessage.toolflag;
			System.out.println ("totalflag 결과 : " + totalflag);
			
			
			
			
			if(DyingMessage.userAnswerCount<6) {
				System.out.println ("제거할 카드를 적게 입력하였습니다. 이번 사건과 관련 없는 카드를 6개 입력해야 합니다.");
				DyingMessage.userAnswerCount = 0;
			}else if(DyingMessage.userAnswerCount>6){
				System.out.println ("제거할 카드를 많이 입력하였습니다. 이번 사건과 관련 없는 카드를 6개 입력해야 합니다.");
				DyingMessage.userAnswerCount = 0;
			}else {//선택한 카드가 6장인 경우 
				reasoningProcess(userAnswerCriminal, userAnswerMotivation, userAnswerTool, totalflag, hintcount);
				break;
			}
		}
	}
	
	void reasoningProcess(String[] userAnswerCriminal, String[] userAnswerMotivation, String[] userAnswerTool, boolean totalflag, int hintcount){//추리 시 try 관련 질문
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
				reasoningInput(hintcount);
			}
		}else if(userInput.equals ("NO")) {
			System.out.println ("제거할 6장의 카드를 다시 입력해주세요.");
			reasoningInput(hintcount);
		}else {
			System.out.println ("잘못입력하였습니다. 대소문자 구별하며 공백없이 입력해주세요.");
			reasoningProcess(userAnswerCriminal,userAnswerMotivation,userAnswerTool,totalflag,hintcount);
		}
	}
	
	String[] inputCriminal() {//범인을 입력하여 쪼개는 메서드
		Scanner sc = new Scanner(System.in);
		boolean flag = false;//사용자 입력에 널이 있다고 가정
		
		String[] userAnswerCriminal = null;//반복으로 인하여 초기화코드 추가
		while(!flag) {
			System.out.println ("[제거] 범인이 아닐 것 같은 직업이 있습니까? 있다면 입력하세요. 없으면 'NO'를 입력");
			userAnswerCriminal = sc.nextLine ().split (",");
			//System.out.println (userAnswerCriminal[0]);
			//System.out.println ("inputCriminl 데이터" + userAnswerCriminal[0]+userAnswerCriminal[1]);
			if(userAnswerCriminal[0].equals ("NO")) {
				
				//System.out.println ("조건문에 맞음");
				break;
			}else {
			//System.out.println (userAnswerCriminal.length);
			//공백 검사
				//System.out.println ("inputCriminl 데이터" + userAnswerCriminal[0]+userAnswerCriminal[1]);
				flag = inputNullCheck(userAnswerCriminal);
				//System.out.println ("inputCriminl 데이터 후" + userAnswerCriminal[0]+userAnswerCriminal[1]);
			}
		}
		//System.out.println ("최종 넘겨주는 데이터 : " + userAnswerCriminal[0]+userAnswerCriminal[1]);
		return userAnswerCriminal;
	}
	
	String[] inputMotivation() {//살해동기를 입력하여 쪼개는 메서드
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String[] userAnswerMotivation = null;
		while(!flag) {
			System.out.println ("[제거] 적합하지 않는 살해 동기가 있습니까? 있다면 입력하세요. 없으면 'NO'를 입력");
			userAnswerMotivation = sc.nextLine ().split (",");
			//System.out.println (userAnswerMotivation.length);
			if(userAnswerMotivation[0].equals ("NO")) {
				break;
			}
			//공백 검사
			flag = inputNullCheck(userAnswerMotivation);
		}
		return userAnswerMotivation;
	}
	
	String[] inputTool() {//살해도구를 입력하여 쪼개는 메서드
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String[] userAnswerTool = null;
		while(!flag) {
			System.out.println ("[제거] 적합하지 않는 살해 도구가 있습니까? 있다면 입력하세요. 없으면 'NO'를 입력");
			userAnswerTool = sc.nextLine ().split (",");
			//System.out.println (userAnswerTool.length);
			if(userAnswerTool[0].equals ("NO")) {
				break;
			}
			//공백 검사
			flag = inputNullCheck(userAnswerTool);
		}
		return userAnswerTool;
	}
	
	boolean inputNullCheck(String[] checkUserInput) {//사용자 입력값 null체크
		//System.out.println("사용자 입력값 널 체크 : " + Arrays.toString (checkUserInput));
		boolean flag = true;//사용자 입력에 널이 없음.
		for(int i = 0 ; i < checkUserInput.length ; i++) {
			if(checkUserInput[i].equals ("")) {
				System.out.println ("다시 입력하세요.");
				flag = false;//사용자 입력에 널이 있음
			}
		}
		return flag;
	}
	
	//사용자가 입력한 값이 제시된 카드 목록에 유효한지 검사하는 메서드
		boolean reasoningInputChecker(String[] userInput,String type){
			//System.out.println (Arrays.toString (userInput));
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
			//System.out.println (Arrays.toString (flag));
			boolean result = false;
			if(flag.length>1) {
				for(int i = 0 ; i < userInput.length-1 ; i++) {
					for(int j = i ; j < userInput.length ; j++) {
						if(flag[i]&&flag[j]) {
							result = true;
						}else {
							result = false;
						}
					}
				}
			}else if(flag.length==1) {
				result = flag[0];
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
			System.out.println ("추리에 실패하였습니다. 추리토큰 하나가 차감됩니다.");
			DyingMessage.hintcount++;
			DyingMessage.userMenu();
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
