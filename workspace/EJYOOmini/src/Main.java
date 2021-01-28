import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		modeChoice();
	}
	
	static void modeChoice() {
		Scanner sc = new Scanner(System.in);
		Radio radioOdj = new Radio();
		Msg.prodMsg ("Alert");
		System.out.print ("카세트 모드를 선택하세요. (1 : 라디오 / 2. 테이프 플레이어) >>>>>");
		int cassetteMode = sc.nextInt ();
		if(cassetteMode==1) {
			radioOdj.radioOnoff ();
		}else if(cassetteMode==2) {
			System.out.println ("Tapeplay 호출 (미구현)");
		}
	}
}
