
public abstract class Cassette {
	final int MAX_VOLUMN = 10;
	final int MIN_VOLUMN = 0;
	
	boolean power;
	int volume;
	
	void powerMsg(int msgNumber) {
		if(msgNumber==0) {
			Msg.prodMsg ("Alert");
			System.out.print ( "전원이 켜집니다. ### \n");
		}else if(msgNumber==1) {
			Msg.prodMsg ("Alert");
			System.out.print ( "전원이 꺼집니다. ### \n");
		}
	}
	
	void setVolumeUp() {
		Msg.prodMsg ("Alert");
		System.out.print ( "볼륨을 올립니다. ### \n");
		volume++;
		if(volume > MAX_VOLUMN) {
			Msg.prodMsg ("Warning");
			volume--;
			System.out.print ( "볼륨이 최대치 입니다. 볼륨을 더이상 올릴 수 없습니다. ### \n");
		}
		
		for(int i = MIN_VOLUMN ; i < MAX_VOLUMN; i++) {
			if(i < volume) {
				System.out.print("■");
			}else {
				System.out.print("□");
			}
		}
		System.out.println ();
	}
	
	void setVolumeDown() {
		Msg.prodMsg ("Alert");
		System.out.print ( "볼륨을 내립니다. ### \n");
		volume--;
		if(volume < MIN_VOLUMN) {
			Msg.prodMsg ("Warning");
			volume++;
			System.out.print ( "볼륨이 최저치 입니다. 볼륨을 더이상 내릴 수 없습니다. ### \n");
		}

		for(int i = MIN_VOLUMN ; i < MAX_VOLUMN; i++) {
			if(i < volume) {
				System.out.print("■");
			}else {
				System.out.print("□");
			}
		}
		System.out.println ();
	}
	
	abstract void currentStatus();
	
}
