package g_oop2;

public class Store {
	public static void main (String[] args) {
		Desktop d1 = new Desktop("삼성 컴퓨터",100000);
		Desktop d2 = new Desktop("LG 컴퓨터",100000);
		
		AirCon	ac1 = new AirCon("삼성 에어컨",200000);
		AirCon	ac2 = new AirCon("LG 에어컨",200000);
		
		TV tv1 = new TV("삼성TV", 3000000);
		TV tv2 = new TV("LGTV", 3000000);
		
		Customer c = new Customer ();
		
		System.out.println (d1.getInfo ());
		System.out.println (d2.getInfo ());
		c.buy (d1);//c.buy((Product)d1); 공통되는 변수만 사용하기 때문에 이렇게 쓰긴함.
		
		System.out.println (ac1.getInfo ());
		System.out.println (ac2.getInfo ());
		c.buy (ac2);
		
		System.out.println (tv1.getInfo ());
		System.out.println (tv2.getInfo ());
		c.buy (tv2);
		
		c.showItem ();
		
	}
}


class Product{
	String name; //이름
	int price; //가격
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	//상품의 정보를 반환하는 메서드
	String getInfo() {
		return name + "(" + price + "원)";
	}
}

class Desktop extends Product{
	//desktop 클래스에 부모 클래스 상속 시 product의 생성자를 호출해야함.
	Desktop (String name, int price) {
		super (name, price);
	}
	
	void programming() {
		System.out.println ("프로그램을 만듭니다.");
	}
}

class AirCon extends Product{
	AirCon (String name, int price) {
		super (name, price);
	}
	
	void setTemperature() {
		System.out.println ("온도를 설정합니다.");
	}
}

class TV extends Product{
	TV (String name, int price) {
		super (name, price);
	}
	
	void setChannel() {
		System.out.println ("채널을 변경합니다.");
	}
}

class Customer{
	int money = 10000000;
	
	Product[] item = new Product[100];//다형성 특성 이용(장바구니)
	//Product[] item = new Product[100];이것을 사용하지 않는 경우
	//각 객체에 대해서 개별적으로 제품을 관리할 인스턴스를 생성해주어야 함.
	//TV[] tv = new TV();
	//AirCon[] aircon = new AirCon();
	//Desktop[] desktop = new Desktop();
	
	//그리고 다형성을 이용하지 않는 경우 buy 메서드도 배열별로 생성을 해서 관리해야한다.
	//void buy(TV t){}
	//void AirCon(AirCon ac){}
	//void Desktop(Desktop dt){}
	void buy(Product p) {
		if(money < p.price) {
			System.out.println ("찬돈이 부족하다.");
			return;
		}
		
		money -= p.price;
		
		for(int i = 0 ; i < item.length ; i++) {
			if(item[i] == null) {
				item[i] = p;
				break;
			}
		}
		System.out.println (p.getInfo ()+"를 구매했다.");
	}
	
	void showItem() {
		System.out.println ("=============장바구니=============");
		for(int i = 0 ; i < item.length ; i++) {
			if(item[i] == null) {
				break;
			}else {
				System.out.println (item[i].getInfo ());
			}
		}
		System.out.println ("===============================");
	}
}