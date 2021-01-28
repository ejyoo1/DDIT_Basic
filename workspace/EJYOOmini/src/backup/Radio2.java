package backup;

public class Radio2 {
	final String[] RADIOMHZ = {"97.5MHz", "96.5MHz", "95.7MHz"}; //0 1 2
	final int MIN_RADIONUM = 0;
	final int MAX_VOLUMN = 10;
	final int MIN_VOLUMN = 0;
	
	boolean power;
	int radionum;
	int volume;
	
	Radio2(){
		power = false;
		radionum = 0;
		volume = 5;
	}
	
	void radioOnoff(String userOnOff) {
		if(userOnOff.equals ("YES")) {
			radioMsg(0);
			power = true;
		}else if(userOnOff.equals ("NO")) {
			radioMsg(1);
			System.exit (0);
		}else {
			System.out.println ("잘못된 입력입니다.");
		}
	}
	
	void radioMsg(int msgNumber) {
		if(msgNumber==0) {
			Msg2.prodMsg ("Alert");
			System.out.print ( "라디오 전원이 켜집니다. ### \n");
		}else if(msgNumber==1) {
			Msg2.prodMsg ("Alert");
			System.out.print ( "라디오 전원이 꺼집니다. ### \n");
		}
	}
	
	void setRadionumUp() {
		currentStatus();
		Msg2.prodMsg ("Alert");
		System.out.print ( "주파수를 올립니다. ### \n");
		radionum++;
		if(radionum >= RADIOMHZ.length) {
			Msg2.prodMsg ("Warning");
			radionum = 0;
			System.out.print ( "주파수가 최대치 입니다. " + RADIOMHZ[radionum] + "로 되돌립니다. ### \n\n");
		}
		currentStatus();
	}
	
	void setRadionumDown() {
		currentStatus();
		Msg2.prodMsg ("Alert");
		System.out.print ( "주파수를 내립니다. ### \n");
		radionum--;
		if(radionum < MIN_RADIONUM) {
			Msg2.prodMsg ("Warning");
			radionum = RADIOMHZ.length - 1;
			System.out.print ( "마지막 주파수 입니다. " + RADIOMHZ[radionum] + "로 되돌립니다. ### \n");
		}
		currentStatus();
	}
	
	void setVolumeUp() {
		currentStatus();
		Msg2.prodMsg ("Alert");
		System.out.print ( "볼륨을 올립니다. ### \n");
		volume++;
		if(volume > MAX_VOLUMN) {
			Msg2.prodMsg ("Warning");
			volume--;
			System.out.print ( "볼륨이 최대치 입니다. 볼륨을 더이상 올릴 수 없습니다. ### \n");
		}
		currentStatus();
	}
	
	void setVolumeDown() {
		currentStatus();
		Msg2.prodMsg ("Alert");
		System.out.print ( "볼륨을 내립니다. ### \n");
		volume--;
		if(volume < MIN_VOLUMN) {
			Msg2.prodMsg ("Warning");
			volume++;
			System.out.print ( "볼륨이 최저치 입니다. 볼륨을 더이상 내릴 수 없습니다. ### \n");
		}
		currentStatus();
	}
	
	void currentStatus() {
		Msg2.prodMsg ("Alert");
		System.out.println ("현재 상태 입니다. [주파수 : " + RADIOMHZ[radionum] + " ]," + " [라디오 볼륨 : " + volume + " ]");
		System.out.println ();
	}
	
}
