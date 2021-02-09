package i_api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapClass {
	public static void main (String[] args) {
		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다.
		 * 
		 * */
		
		
		HashMap<String, Object> map = new HashMap<>();
		map.put ("a", "test1");
		map.put ("number", 10);
		map.put ("c", "test2");
		map.put ("name", "홍길동");
		map.put ("b", "test3");
		map.put("scanner", new Scanner(System.in));
		
//		Scanner object = (Scanner)map.get ("scanner");
//		object.nextLine();
		
		System.out.println (map);
		
		map.put ("name","이순신"); //덮어씀
		
		System.out.println (map);
		
		map.remove ("number");
		
		System.out.println (map);
		
		Object value = map.get ("name");
		System.out.println (value);
		
		System.out.println (((String)value).substring(0,1));
		
		Set<String> keys = map.keySet ();
		
		for(String key : keys) {
			System.out.println (key + " : " + map.get (key));
		}
		
		
		ArrayList<HashMap<String, Object>> table = new ArrayList<>();
		
		HashMap<String,Object> row = new HashMap<>();
		row.put ("cart_member",	"a001");
		table.add (row);
		System.out.println (table.get (0).get ("cart_member"));
		
		
		//회원 테이블
		//아이디, 비밀번호, 이름, 전화번호
		ArrayList<HashMap<String, Object>> users = new ArrayList<>();
		
		HashMap<String, Object> user = new HashMap<>();
		user.put ("id", "admin");
		user.put ("password", "admin123");
		user.put ("name", "관리자");
		user.put ("tel", "010-1234-5678");
		
		HashMap<String, Object> user2 = new HashMap<>();
		user2.put ("id", "user1");
		user2.put ("password", "user123");
		user2.put ("name", "사용자");
		user2.put ("tel", "010-1234-5678");
		
		
		
		users.add (user);
		users.add (user2);
		
		
		
		for(int i = 0 ; i < users.size () ; i++) {
			HashMap<String, Object> li = users.get (i);
			for(int j = 0 ; j < users.size () ; j++) {
				System.out.print (li.get ("id"));
				System.out.print (li.get ("password"));
				System.out.print (li.get ("name"));
				System.out.print (li.get ("tel"));
			}
			System.out.println ();
		}
		
		
		
		Set<String> keys1 = user.keySet ();
		
		for(String key : keys1) {
			System.out.print ("key : " + user.get (key));
		}
		
		System.out.println ();
		
		Set<String> keys2 = user2.keySet ();
		for(String key : keys2) {
			System.out.print ("key : " + user2.get (key));
		}
		
		System.out.println ();
		
		
		for(int i = 0 ; i < users.size () ; i++) {
			HashMap<String, Object> li = users.get (i);
			for(String key : li.keySet ()) {
				System.out.println (key + " : " + li.get(key));
			}
			System.out.println ();
		}
		
		
		//arraylist에 저장된 hashmap 목록들을 불러옴.
		//hashmap에 있는 키를 key 변수에 저장
		for(HashMap<String, Object> li : users) {
			for(String key : li.keySet ()) {
				System.out.println (key + " : " + li.get(key));
			}
			System.out.println ();
		}
		
	}
}
