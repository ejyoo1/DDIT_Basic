package sub;

public class Card {
	static String[] round_answer = {"복서", "협박", "화분"};
	int USER_VIEW_CARD 	= 9;
	
	static String[] criminal 	= { "복서 ", "시인 ", "건축가", "미용사", "의사 ", "아이돌", "사기꾼", "가수 ", "군인 " };
	static String[] motivation	= { "협박 ", "재미 ", "빛   ", "불륜 ", "시기  ", "유산 ", "배신 ", "스토킹", "강도 " };
	static String[] tool		= { "화분 ", "가방 ", "휴지통", "곰인형", "세탁기", "냉장고", "변기 ", "코트 ", "쇼핑백" };
	
	
	void cardCriminalPrintin() {
		for(int i = 0 ; i < USER_VIEW_CARD ; i++) {
			System.out.print ("  " + criminal[i]);
		}
		System.out.println ();
	}
	
	void cardMotivationPrintin() {
		for(int i = 0 ; i < USER_VIEW_CARD ; i++) {
			System.out.print ("  " + motivation[i]);
		}
		System.out.println ();
	}
	
	void cardToolPrintin() {
		for(int i = 0 ; i < USER_VIEW_CARD ; i++) {
			System.out.print ("  " + tool[i]);
		}
		System.out.println ();
	}
}
