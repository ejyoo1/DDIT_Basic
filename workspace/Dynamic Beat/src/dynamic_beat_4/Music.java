package dynamic_beat_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;


//인트로 뮤직을 삽입하기 위한클래스
//프로젝트 우클릭 - Build Path - Configuration Build Path - Add External JARs에서 라이브러리 추가한다.
//추가한 라이브러리는 'Referenced Libraries'에 삽입된다.
//프로그램 안의 하나의 작은 프로그램이라고 생각하면 된다.
public class Music extends Thread{
	private Player player;//받은 라이브러리 중 하나임.
	private boolean isLoop;//현재 곡이 무한반복인지 한번만 재생되어 꺼지는지 그에대한 설정임.
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop){//곡의 제목과 그곡의 반복 타입을 설정하기위한 값을 받음.
		try{
			this.isLoop = isLoop; //변수초기화
			file = new File(Main.class.getResource("../music/"+ name).toURI());//뮤직이라는 폴더 안에있는 해당파일을 실행시킨다. toURL로 해당파일의 위치를 가져올 수 있도록 한다.
			fis = new FileInputStream(file);//파일을 파일 스트림으로 가져와서
			bis = new BufferedInputStream(fis);//파일 스트림을 버퍼에 담아서 읽어올 수있도록 한다.
			player =new Player(bis);//플레이어가 해당 파일을 담을 수 있게 한다.
		} catch(Exception e){//try문에서 오류가 발생하면 이곳으로 넘어옴
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime(){//현재 실행되고 있는음악이 현재 어떤위치에서 실행되고 있는지 알려줌 0.001초까지 알려주는 것임. 이것을 맞춰서 시간을 분석하는 것임.
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close(){//음악이 시작되는 중간에도 게임이 종료될 수 있게함.
		isLoop = false;
		player.close();
		this.interrupt();//해당 스레드를 중지상태로 만든다.(스레드는 작은 프로그램 게임과 별도로 곡 재생을 해주는 프로그램이 따로있는데 그 곡을 종료해주는것이다.)
	}
	
	@Override
	public void run(){//스레드를 상속받으면 무조건 사용해야 하는함수 음악을 실행하는 곳
		try{
			//여기가 중요
			//곡을 실행
			do{
				player.play();//곡을 실행
				fis = new FileInputStream(file);//파일을 파일 스트림으로 가져와서
				bis = new BufferedInputStream(fis);//파일 스트림을 버퍼에 담아서 읽어올 수있도록 한다.
				player =new Player(bis);//플레이어가 해당 파일을 담을 수 있게 한다.
			}while(isLoop);//isLoop값이 트루이면 do 안에로직이 실행되고 do 안에 있는 로직은 음악이 실행되는 로직이다.
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
