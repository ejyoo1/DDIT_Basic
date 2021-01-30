package f_game;

public class Item {
	String name;	//아이템 명
	int hp;			//체력
	int mp;			//마나
	int att;		//공격력
	int def;		//방어력
	
	
	Item(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
	}
	
	String itemInfo() {
		String info = name + " :";
		if(0 < hp) info += " 체력+" + hp;
		if(0 < mp) info += " 체력+" + mp;
		if(0 < att) info += " 체력+" + att;
		if(0 < def) info += " 체력+" + def;
		return info;
	}
}
