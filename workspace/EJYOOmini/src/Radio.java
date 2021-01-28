import java.util.Scanner;

public class Radio extends Cassette{
	final String[] RADIOMHZ = {"97.5MHz", "96.5MHz", "95.7MHz"}; //0 1 2
	final int MIN_RADIONUM = 0;
	
	int radionum;
	
	
	Radio(){
		power = false;
		radionum = 0;
		volume = 5;
	}
	
	void radioOnoff() {
		String userOnOff = null;
		while(!power) {
			Scanner sc = new Scanner(System.in);
			Msg.prodMsg ("Question");
			System.out.print ("라디오를 켜시겠습니까? (0입력 시 이전단계로 이동) (YES/NO 중 입력) >>>>>");
			userOnOff = sc.nextLine ();
					
			if(userOnOff.equals ("YES")) {
				powerMsg(0);
				power = true;
				initRadio();
			}else if(userOnOff.equals ("NO")) {
				powerMsg(1);
				System.exit (0);
			}else if(userOnOff.equals ("0")) {
				System.out.println ("이전 단계로 이동합니다.");
				break;
				
			}else {
				System.out.println ("잘못된 입력입니다.");
			}
		}
		if(userOnOff.equals ("0")) {
			Main.modeChoice ();
		}
	}
	
	void initRadio() {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			Msg.prodMsg ("Question");
			System.out.println ("어떤 작업을 하시겠습니까? (아래 목록 중 수행할 번호를 입력하시오.)");
			System.out.print (" 1. 주파수 위로 조절 \n 2. 주파수 아래로 조절\n 3. 볼륨 위로 조절 \n 4. 볼륨 아래로 조절 \n 0. 시스템종료\n");
			System.out.print ("입력 >>>>>");
			int userStatus = sc.nextInt ();
			if(userStatus==1) {
				setRadionumUp();
				currentStatus ();
			}else if(userStatus==2) {
				setRadionumDown();
				currentStatus ();
			}else if(userStatus==3) {
				setVolumeUp ();
				currentStatus ();
			}else if(userStatus==4) {
				setVolumeDown ();
				currentStatus ();
			}else if(userStatus==0) {
				flag = false;
				Msg.prodMsg ("Alert");
				System.out.print ("시스템을 종료합니다. \n");
				System.exit (0);
			}
		}
	}
	
	
	
	void setRadionumUp() {
		Msg.prodMsg ("Alert");
		System.out.print ( "주파수를 올립니다. ### \n");
		radionum++;
		if(radionum >= RADIOMHZ.length) {
			Msg.prodMsg ("Warning");
			radionum = 0;
			System.out.print ( "주파수가 최대치 입니다. " + RADIOMHZ[radionum] + "로 되돌립니다. ### \n\n");
		}
	}
	
	void setRadionumDown() {
		Msg.prodMsg ("Alert");
		System.out.print ( "주파수를 내립니다. ### \n");
		radionum--;
		if(radionum < MIN_RADIONUM) {
			Msg.prodMsg ("Warning");
			radionum = RADIOMHZ.length - 1;
			System.out.print ( "마지막 주파수 입니다. " + RADIOMHZ[radionum] + "로 되돌립니다. ### \n");
		}
	}
	
	
	
	void currentStatus() {
		Msg.prodMsg ("Alert");
		System.out.println ("현재 상태 입니다. [주파수 : " + RADIOMHZ[radionum] + " ]," + " [라디오 볼륨 : " + volume + " ]");
		System.out.println ();
	}
	
}
