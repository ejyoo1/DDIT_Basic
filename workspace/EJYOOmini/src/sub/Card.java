package sub;

import java.util.Arrays;

public class Card {
	static String[] round_answer = {"복서", "협박", "화분"};
	int USER_VIEW_CARD 	= 9;
	
	static String[] criminal 	= { "복서", "시인", "건축가", "미용사", "의사", "아이돌", "사기꾼", "가수", "군인" };
	static String[] motivation	= { "협박", "재미", "빚", "불륜", "시기", "유산", "배신", "스토킹", "강도" };
	static String[] tool		= { "화분", "가방", "휴지통", "곰인형", "세탁기", "냉장고", "변기", "코트", "쇼핑백" };
	
	void cardPrintln(String cardType) {//카드 출력을 위한 메서드
		for(int i = 0 ; i < USER_VIEW_CARD ; i++) {
			if(cardType.equals ("criminal")) {//범인을 출력하고자 하는 경우
				System.out.print ("  " + criminal[i]);
			}else if(cardType.equals ("motivation")) {//살해동기를 출력하고자 하는 경우 
				System.out.print ("  " + motivation[i]);
			}else if(cardType.equals ("tool")) {//살해 도구를 출력하고자 하는 경우
				System.out.print ("  " + tool[i]);
			}
		}
		System.out.println ();
	}
	
	//범인이 아닌 카드 체크 : 사용자 입력 중 범인인 사람이 잇으면 false(추리실패)/ 범인이 없으면 true(추리성공)
	boolean cardCheckerCriminal(String[] userAnswerCriminal){//사용자 입력값이 범인이 아닌 사람이 존재하는지 확인하기위한 메서드
		boolean flag = true;
		for(int i = 0 ; i < userAnswerCriminal.length ; i++ ) {
			if(userAnswerCriminal[i].equals (round_answer[0])) {//정답과 같은것이 하나라도 있으면
				flag = false;//같음. 추리실패
				break;//반복문을 빠져나감.
			}
		}
		return flag;//if문 조건이 true이면 실패 false면 추리 성공
	}
	
	//살해동기가 아닌 카드 체크 : 사용자 입력 중 정답인 살해동기가 있으면 false(추리실패)/ 정답인 살해동기가 없으면 true(추리성공)
	boolean cardCheckerMotivation(String[] userAnswerMotivation){
		//System.out.println (Arrays.toString (userAnswerMotivation));
		boolean flag = true;
		for(int i = 0 ; i < userAnswerMotivation.length ; i++ ) {
			if(userAnswerMotivation[i].equals (round_answer[1])) {//정답과 같은것이 잇다면
				flag = false;//같음. 추리실패
				break;//반복문을 빠져나감.
			}
		}
		return flag;//if문 조건이 true이면 실패 false면 추리 성공
	}
		
	//살해도구가 아닌 카드 체크 : 사용자 입력 중 정답인 살해도구가 있으면 false(추리실패)/ 정답인 살해도구가 없으면 true(추리성공)	
	boolean cardCheckTool (String[] userAnswerTool) {
		//System.out.println ("사용자가 입력한 살해도구 " + Arrays.toString (userAnswerTool));
		boolean flag = true;
		for(int i = 0 ; i < userAnswerTool.length ; i++ ) {
			if(userAnswerTool[i].equals (round_answer[2])) {//만약에 정답과 같은것이 있으면 추리 실패
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	
	void cardDel(String[] userAnswerCriminal, String[] userAnswerMotivation, String[] userAnswerTool) {
		//System.out.println ("cardDel호출");
		//System.out.println (Arrays.toString (userAnswerCriminal));
		//System.out.println (Arrays.toString (userAnswerMotivation));
		//System.out.println (Arrays.toString (userAnswerTool));
		boolean flag = false;
		
		if(userAnswerCriminal!=null) {
		//기본 목록에 같은 범인이 있는경우 " "로 변경
			for(int i = 0 ; i < userAnswerCriminal.length ; i++ ) {//사용자 정답 비교
				for(int j = 0 ; j < criminal.length ; j++ ) {
					if(userAnswerCriminal[i].equals (criminal[j])) {//정답과 같은것이 하나라도 있으면
						criminal[j] = "■■■";
						break;
					}
				}			
			}
		}
		
		if(userAnswerMotivation!=null) {
			//기본 목록에 같은 살해 동기가 있는경우 " "로 변경
			for(int i = 0 ; i < userAnswerMotivation.length ; i++ ) {//사용자 정답 비교
				for(int j = 0 ; j < motivation.length ; j++ ) {
					if(userAnswerMotivation[i].equals (motivation[j])) {//정답과 같은것이 하나라도 있으면
						motivation[j] = "■■■";
						break;
					}
				}			
			}
		}
		
		if(userAnswerTool!=null) {
			//기본 목록에 같은 살해 도구가 있는경우 " "로 변경
			for(int i = 0 ; i < userAnswerTool.length ; i++ ) {//사용자 정답 비교
				for(int j = 0 ; j < tool.length ; j++ ) {
					if(userAnswerTool[i].equals (tool[j])) {//정답과 같은것이 하나라도 있으면
						tool[j] = "■■■";
						break;
					}
				}			
			}
		}
		
	}

	
}
