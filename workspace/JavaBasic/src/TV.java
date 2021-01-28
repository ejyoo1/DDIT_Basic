import java.util.Scanner;

public class TV {
	//과제. TV를 대상으로 클래스를 만들어주세요.
	//대상이 가지고 잇는 속성을 변수로 만들어라.
	//TV라는 대상에서 여러가지 속성이 있음.
	//전원을 껏다 켯다하는 전원 속성
	//채널이라는 속성
	//보고싶은 채널로 변경
	//소리 크기 변경 속성
	
	// 속성들을 변경할 수 있도록 메서드를 만들어야함.
	// 전원 메서드, 채널 올리는 메서드, 채널을 내리는 메서드, 소리크기 올리는 메서드,소리크기 내리는 메서드, 채널 한번에 이동 조정 메서드
	//메서드 만드는 기준 : 리모콘 버튼 메서드가 된다 생각하면 됨
	
	
	//변수 생성하기
	//채널(1~100), 전원(ON/OFF), 볼륨(1~100)
	int channel;
	int volume;
	boolean power;
	
	
	//제한값 세팅(최대 최소값)
	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME  = 1;
	final int MAX_VOLUMN  = 100;
	
	
	
	//메서드 생성하기
	
	
	
	//생성자
	TV(){
		power = false;
		channel = 1;
		volume = 10;
	}
	
	public static void main(String[] args) {
		TV t = new TV();
		Scanner sc = new Scanner(System.in);
		
		System.out.print ("TV를 켜시겠습니까?(YES/NO)");
		String userInput = sc.nextLine();
		t.channelOnOffMethod(userInput);
		if(t.power) {
			System.out.println("=======================================");
			System.out.println("[채널 : " + t.channel + " ]");
			System.out.println("=======================================");
			t.userChoice();
		}
		System.exit (0);//프로그램 종료
		
	}
	
	
	
	
	
	
	
	
	void userChoice() {
		String userEvent = "";
		boolean flag = true;
		while(flag) {
			System.out.println ("어떤 작업을 수행하시겠습니까? (번호입력)");
			System.out.println ("1 : 현재채널 + 1");
			System.out.println ("2 : 현재채널 - 1");
			System.out.println ("3 : 원하는 채널 이동");
			System.out.println ("4 : 볼륨 증가");
			System.out.println ("5 : 볼륨 감소");
			System.out.println ("0 : 조작 종료");
			System.out.println ("HOME : 현재 상태 전체 보기");
			
			System.out.print ("입력>");
			Scanner sc = new Scanner(System.in);
			userEvent = sc.nextLine();
			
			
			switch(userEvent) {
				case "1" :
					channelUp();
					break;
				case "2" : 
					channelDown();
					break;
				case "3" :
					System.out.print ("이동할 채널 입력>");
					int userChannelInput = sc.nextInt();
					System.out.println ("사용자 입력 : "+userChannelInput);
					channelChange(userChannelInput);
					break;
				case "4" :
					volumeUp ();
					break;
				case "5" :
					volumeDown ();
					break;
				case "0" :
					System.out.println ("##알림## TV를 종료합니다.");
					flag = false;
					break;
				case "HOME" :
					System.out.println ("##알림## 현재 상태입니다. [채널 : " + channel + " ] [ 소리 : " + volume + " ] ###");
					break;
			}
		}
		
	}
	
	
	boolean channelOnOffMethod(String userInput) {
		//System.out.println(power?"TV켜짐" : "TV꺼짐");
		if(userInput.equals ("YES")) {
			System.out.println("TV를 켭니다======================================");
			power = true;
		}else if(userInput.equals ("NO")){
			System.out.println("TV를 종료합니다======================================");
			power = false;
		}else {
			System.out.println("TV를 종료합니다======================================");
			power = false;
		}
		return power;
	}

	int channelUp() {
		//파워가 켜져 잇을 때, 동작하도록 제어 필요(내 코드는 추후 예외처리가 필요할듯)
//		System.out.println ("채널을 +1 합니다.");
		channel++;
		if(channel>MAX_CHANNEL) {
			System.out.println ("##알림## 100번이 마지막 채널이므로 1번 채널로 이동합니다.");
			channel = MIN_CHANNEL;
		}
//		System.out.println("채널 증가 : " + channel);
		System.out.println("##알림## \n채널 : " + channel + " (으)로 이동하였습니다.");
		return channel;
	}
	
	int channelDown() {
//		System.out.println ("채널을 -1 합니다.");
		channel--;
		if(channel < MIN_CHANNEL) {
			System.out.println ("##알림## 1번이 마지막 채널이므로 100번 채널로 이동합니다.");
			channel = MAX_CHANNEL;
		}
//		System.out.println("채널 감소 : " + channel);
		System.out.println("##알림## \n채널 : " + channel + " (으)로 이동하였습니다.");
		return channel;
	}
	
	int channelChange(int userInput) {
		if(userInput < MIN_CHANNEL) {
			System.out.println(userInput+" 번 채널이 없습니다. 이동할 수 없습니다.");
		}else if(userInput > MAX_CHANNEL) {
			System.out.println(userInput+" 번 채널이 없습니다. 이동할 수 없습니다.");
		}else {	
			channel = userInput;
			System.out.println("##알림## \n채널 : " + channel + " (으)로 이동하였습니다.");
		}
		
		return channel;
	}
	
	
	int volumeUp() {
		volume++;
		if(volume>MAX_VOLUMN) {
			System.out.println ("##알림## 소리가 최대치입니다.");
			volume--;
		}
		volumnDesign();
		System.out.println();
		System.out.println("##알림## \n소리 : [ " + volume + " ] ");
		return volume;
	}
	
	int volumeDown() {
		volume--;
		if(volume<MIN_VOLUME) {
			userPrintMessage("volumeDown_msg");
			volume++;
		}
		volumnDesign();
		System.out.println();
		System.out.println("##알림## \n소리 : [ " + volume + " ] ");
		return volume;
	}
	
	void volumnDesign() {
		for(int i = MIN_VOLUME; i <= MAX_VOLUMN ; i++) {
			System.out.print (volume);
			if(i<=volume) {
					System.out.print ("■");
			}else {
				System.out.print("□");
			}
		}
	}
	
	void userPrintMessage(String message) {
		if(message.equals ("volumeDown_msg")) {
			System.out.println ("##알림## 소리가 최저치입니다.");
		}
	}
	
	
}
