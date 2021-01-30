package f_game;

public class Market {
	Item[] items = new Item[10];
	
	Market(){
		items[0] = new Item("무한의대검", 0, 0, 10, 0);
		items[1] = new Item("가시갑옷", 0, 0, 0, 10);
		items[2] = new Item("test1", 0, 0, 0, 10);
	}
}
