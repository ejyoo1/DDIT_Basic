import java.util.Scanner;

public class WordScrambleEx1 {
	public static void main (String[] args) {
		//타자 맞추기 게임
		String[] strArr = {"CHANGE", "LOVE", "HOPE", "VIEW"};
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			String answer = getAnswer(strArr);
			String question;
//			question = getScrambledWord(answer);
			char[] hint = new char[answer.length()];
			
			for(int i = 0 ; i < hint.length; i++) {
				hint[i] = '_';
			}
			
			while(true) {
//				System.out.println("Question : " + question);
				System.out.println ("Your answer is : ");
				
				String input = sc.nextLine();
				
				if(input.equalsIgnoreCase("q"))
					System.exit (0);
				
				if(input.equalsIgnoreCase (answer)) {
					System.out.println ("정답입니다.");
					System.out.println ();
					break;
				}else {
					System.out.println (input + "은/는 정답이 아닙니다.다시 시도해보세요.");
					System.out.println ("Hint : " + getHint(answer,hint));
				}
			}
		}
	}
	
	public static String getAnswer(String[] strArr) {
		//목록 중 임의의 답 설정하기
		int idx = (int)(Math.random() * strArr.length);
		return strArr[idx];
	}
	
	/*
	public static String getScrambledWord(String str) {
		char[] chArr = str.toCharArray ();
		
		for(int i = 0 ; i < str.length () ; i++) {
			int idx = (int)(Math.random () * str.length ());
			
			char tmp = chArr[i];
			chArr[i] = chArr[idx];
			chArr[idx] = tmp;
		}
		
		return new String(chArr);
	}
	*/
	
	public static String getHint(String answer, char[] hint) {
		int count = 0;
		
		for(int i = 0 ; i < hint.length ; i++) {
			if(hint[i] == '_') {
				count++;
			}
		}
		
		if(count > 2) {
			while(true) {
				int idx = (int)(Math.random() * answer.length ());
				
				if(hint[idx] == '_') {
					hint[idx] = answer.charAt (idx);
					break;
				}
			}
		}
		return new String(hint);
	}
	
}
