package backup;
import java.util.Scanner;

public class Main2 {
	public static void main (String[] args) {
		Radio2 radioOdj = new Radio2();
		Scanner sc = new Scanner(System.in);
		while(!radioOdj.power) {
			Msg2.prodMsg ("Question");
			System.out.print ("라디오를 켜시겠습니까? (YES/NO 중 입력) >>>>>");
			String userOnOff = sc.nextLine ();
			
			
			radioOdj.radioOnoff(userOnOff);
		}
		radioOdj.currentStatus ();
		
		boolean flag = true;
		
		while(flag) {
			Msg2.prodMsg ("Question");
			System.out.println ("어떤 작업을 하시겠습니까? (아래 목록 중 수행할 번호를 입력하시오.)");
			System.out.print (" 1. 주파수 위로 조절 \n 2. 주파수 아래로 조절\n 3. 볼륨 위로 조절 \n 4. 볼륨 아래로 조절 \n 0. 시스템종료\n");
			System.out.print ("입력 >>>>>");
			int userStatus = sc.nextInt ();
			if(userStatus==1) {
				radioOdj.setRadionumUp();
			}else if(userStatus==2) {
				radioOdj.setRadionumDown();
			}else if(userStatus==3) {
				radioOdj.setVolumeUp ();
			}else if(userStatus==4) {
				radioOdj.setVolumeDown ();
			}else if(userStatus==0) {
				flag = false;
				Msg2.prodMsg ("Alert");
				System.out.print ("시스템을 종료합니다. \n");
				System.exit (0);
			}
		}
		
		
	}
}
