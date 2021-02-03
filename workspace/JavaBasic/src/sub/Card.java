package sub;

public class Card {
	static String[] round_answer = {"복서", "협박", "화분"};
	int USER_VIEW_CARD 	= 9;
	
	static String[] criminal 	= { "복서", "시인", "건축가", "미용사", "의사", "아이돌", "사기꾼", "가수", "군인" };
	static String[] motivation	= { "협박", "재미", "빚", "불륜", "시기", "유산", "배신", "스토킹", "강도" };
	static String[] tool		= { "화분", "가방", "휴지통", "곰인형", "세탁기", "냉장고", "변기", "코트", "쇼핑백" };
	
	void cardPrintln(String cardType) {//카드 출력 관련 메서드
		for(int i = 0 ; i < USER_VIEW_CARD ; i++) {
			if(cardType.equals ("criminal")) {
				System.out.print ("  " + criminal[i]);
			}else if(cardType.equals ("motivation")) {
				System.out.print ("  " + motivation[i]);
			}else if(cardType.equals ("tool")) {
				System.out.print ("  " + tool[i]);
			}
		}
		System.out.println ();
	}
		
	boolean cardCheckerCriminal(String[] userAnswerCriminal){//카드 정답 판별 메서드 1
		boolean flag = true;
		for(int i = 0 ; i < userAnswerCriminal.length ; i++ ) {
			if(userAnswerCriminal[i].equals (round_answer[0])) {
				flag = false;
				break;
			}
		}
		return flag;
	}
		
	boolean cardCheckerMotivation(String[] userAnswerMotivation){// 카드 정답 판별 메서드 2
		boolean flag = true;
		for(int i = 0 ; i < userAnswerMotivation.length ; i++ ) {
			if(userAnswerMotivation[i].equals (round_answer[1])) {
				flag = false;
				break;
			}
		}
		return flag;
	}
				
	boolean cardCheckerTool (String[] userAnswerTool) {// 카드 정답 판별 메서드 3
		
		boolean flag = true;
		for(int i = 0 ; i < userAnswerTool.length ; i++ ) {
			if(userAnswerTool[i].equals (round_answer[2])) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	void cardDel(String[] userAnswerCriminal, String[] userAnswerMotivation, String[] userAnswerTool) {//추리완료된 카드 삭제 메서드
		boolean flag = false;
		
		if(userAnswerCriminal!=null) {
			for(int i = 0 ; i < userAnswerCriminal.length ; i++ ) {
				for(int j = 0 ; j < criminal.length ; j++ ) {
					if(userAnswerCriminal[i].equals (criminal[j])) {
						criminal[j] = "■■■";
						break;
					}
				}			
			}
		}
		
		if(userAnswerMotivation!=null) {
			for(int i = 0 ; i < userAnswerMotivation.length ; i++ ) {
				for(int j = 0 ; j < motivation.length ; j++ ) {
					if(userAnswerMotivation[i].equals (motivation[j])) {
						motivation[j] = "■■■";
						break;
					}
				}			
			}
		}
		
		if(userAnswerTool!=null) {
			for(int i = 0 ; i < userAnswerTool.length ; i++ ) {
				for(int j = 0 ; j < tool.length ; j++ ) {
					if(userAnswerTool[i].equals (tool[j])) {
						tool[j] = "■■■";
						break;
					}
				}			
			}
		}
		
	}

}
