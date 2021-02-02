package g_oop2;

import java.util.Scanner;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public int getHour () {
		return hour;
	}
	public void setHour (int hour) {//세터를 통해서 잘못된 값이 넘어올 때, 방지하는 로직을 짤 수 잇음.
		if(hour < 0) {
			this.hour = 0;
		}else if(23 < hour) {
			this.hour = 23;
		}else {
			this.hour = hour;
		}
	}
	public int getMinute () {
		return minute;
	}
	public void setMinute (int minute) {
		if(minute < 0) {
			this.minute = 0;
		}else if(59 < minute) {
			this.minute = 59;
		}else {
			this.minute = minute;
		}
	}
	public int getSecond () {
		return second;
	}
	public void setSecond (int second) {
		if(second < 0) {
			this.second = 0;
		}else if(59 < second) {
			this.second = 59;
		}else {
			this.second = second;
		}
	}
	
	
	String getTime() {
		return hour + " : " + minute + " : " + second;
	}
	
	void clock() {
		while(true) {
			System.out.println (getTime());
			stop(1000);
			setSecond(second + 1);
		}
	}
	
	private void stop(int interval) {//현 클래스에서 clock()메서드에서만 사용하기 위한 메서드. 다른 클래스에서는 사용할 필요가 없음.
		try {//예외처리
			Thread.sleep (interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
