package f_game;

import java.util.Arrays;

import e_oop.ScanUtil;

public class MyGame {
	
	Character c;
	
	Item[] items;
	
	MyGame(){
		
	}
	MyGame(String userName){
		c = new Character(userName, 100, 50, 20, 10);
		items = new Item[10];
		items[0] = new Item("무한의대검", 0, 0, 10, 0);
		items[1] = new Item("가시갑옷", 0, 0, 0, 10);
		items[2] = new Item("test1", 0, 0, 0, 10);
	}
	
	
	public static void main (String[] args) {
		
		System.out.print("사용자 명 입력 >>");
		String userName = ScanUtil.nextLine ();
		new MyGame(userName).start();
		

	}
	
	void start() {
		int input = 0;
		while(true) {
			System.out.println ("1. 내정보 \t 2. 사냥 \t 3. 종료 \t 4. 상점");
			input	= ScanUtil.nextInt ();
			
			switch(input) {
				case 1 :
					c.showInfo ();
					break;
				case 2 : 
					hunt();
					break;
				case 3 : 
					System.out.println ("종료되었습니다.");
					System.exit (0);
				case 4 : 
					System.out.println ("상점메서드 호출");
					market ();
			}
		}
	}
	
	void hunt() {
		Monster m = new Monster("고블린", 20, 10, 15, 10, new Item[] {items[0], items[1], items[2]});
		System.out.println (m.name + "를 만났습니다. 전투를 시작합니다.");
		
		int input = 0;
		battle : while(true) {
			System.out.println ("1. 공격 \t 2. 도망");
			input = ScanUtil.nextInt ();
			switch (input) {
				case 1:
					c.attack(m);
					if(m.hp <= 0) {
						System.out.println (m.name + "을 처치하였습니다.");
						c.getExp (150);
						c.getItem (m.itemDrop ());
						break battle;
					}
					m.attack(c);
					break;
				case 2:
					break battle;
			}
		}
	}
	
	void market() {
		System.out.println ("상점에 들어왔습니다.");
		int input = 0;
		buy : while(true) {
			System.out.println ("1. 대여 \t 2. 반납 \t 3. 돌아가기");
			input = ScanUtil.nextInt ();
			switch(input) {
				case 1:
					Market mr = new Market();
					System.out.println ("무엇을 대여하시겠습니까?");
					System.out.println ("1. " + mr.items[0].name);
					System.out.println ("2. " + mr.items[1].name);
					System.out.println ("3. " + mr.items[2].name);
					input = ScanUtil.nextInt ();
					if(input == 1) {
						c.getItem(mr.items[0]);
					}else if(input == 2) {
						c.getItem (mr.items[1]);
					}else if(input == 3) {
						c.getItem (mr.items[2]);
					}
					break;
				case 2:
					//반납할 아이템이 없는 경우 이전단게로 돌아가야함
					while(true) {
						System.out.println ("무엇을 반납하시겠습니까?");
						int count = 0;
						for(int i = 0 ; i < c.items.length; i++) {
							if(c.items[i] != null) {
								System.out.println ((i+1)+". " + c.items[i].name);
								count++;
							}
						}
						input = ScanUtil.nextInt ();
						if(input>count){
							System.out.println ("재입력 하세요.");
						}else {
							break;
						}
					}
					
					NO : while(true) {
						System.out.println ("정말로 " + c.items[input-1].name + " 을 반납하시겠습니까?(YES/NO 입력)");
						String input2 = ScanUtil.nextLine ();
						if(input2.equals ("YES")) {
							String delItem = c.items[input-1].name;
							for(int i = 0 ; i < c.items.length; i++) {
								if(c.items[i] != null) {
									System.out.println (i+ ": " + c.items[i].name);
									if(c.items[i].name.equals (delItem)) {
										c.items[i] = null;
									}else {
										System.out.println ("다름");
									}
								}
							}
							break NO;
						}else if(input2.equals ("NO")){
							
						}else {
							System.out.println ("잘못된 입력입니다.");
							break NO; 
						}
					}
					break;
				case 3:
					System.out.println ("상점을 나갑니다.");
					break buy;
			}
		}
	}
}
