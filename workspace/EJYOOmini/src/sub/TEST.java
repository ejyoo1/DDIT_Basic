package sub;

import java.util.Arrays;
import java.util.Scanner;

public class TEST {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] userAnswerCriminal = sc.nextLine ().split (",");
		
		System.out.println (Arrays.toString (userAnswerCriminal));
		for(int i = 0 ; i < userAnswerCriminal.length ; i++) {
			if(userAnswerCriminal[i].equals (null)) {
				System.out.println (userAnswerCriminal[i] + "NULL입니다.");
			}else if(userAnswerCriminal[i].equals ("")) {
				System.out.println (userAnswerCriminal[i] + "은 공백입니다.");
			}else if(userAnswerCriminal[i].equals (" ")) {
				System.out.println (userAnswerCriminal[i] + "공백 띄어쓰기입니다.");
			}else {
				System.out.println (userAnswerCriminal[i]);
			}
		}
	}
}
