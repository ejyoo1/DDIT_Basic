package i_api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class ArrayListClass {
	public static void main (String[] args) {
		//List, Map, Set
		
		/*
		 * boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 * void add(int index, Object obj) : 지정된 위치에 객체를 추가한다.
		 * Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 * Object get(int index) : 지정된 위치의 객체를 반환한다.
		 * int size() : 저장된 객체의 수를 반환한다.
		 * boolean remove(int index) : 지정된 위치의 객체를 제거한다.
		 *  
		 */
		
		ArrayList sample = new ArrayList();
		
		sample.add ("abc");
		sample.add (100);
		sample.add (new Scanner(System.in));
		
		//제네릭을 지정하지 않으면 넣을때는 편하나 꺼낼때는 타입을 예측하기 힘들다.
		//따라서 제네릭의 사용이 권장된다.
		ArrayList<Integer> list = new ArrayList<>();
		list.add (10);
//		list.add ("d");
		list.add (20);
		System.out.println (list.add (30));
		System.out.println (list);
		
		list.add (1,40);//1번 인덱스부터 뒤로 밀고 값을 저장한다.
		System.out.println (list);
		
		Integer before = list.set (2, 50);//2번 인덱스에 값을 저장하고 
		System.out.println ("before : " + before);
		System.out.println ("after : " + list.get (2));
		System.out.println (list);
		
		Integer integer = list.get (2);
		System.out.println (integer);
		
		//원래는 앞에서부터 제거하는 것으로 생각할 수 있지만. 실제로는 다 지워지지 않는다.
		//다 지우려면 for문을 뒤에서부터 차레대로 지워야한다.
		/*
		for(int i = 0 ; i < list.size () ; i++) {
			System.out.println (i + " : " + list.get(i));
			list.remove(i);
		}
		System.out.println (list);
		*/
		for(int i = list.size() - 1 ; 0 <= i ; i--) {
			System.out.println (i + " : " + list.get(i));
			list.remove(i);
		}
		System.out.println (list);
		
		//list에 1부터 100까지 랜덤값을 10개 저장해주세요
		
		
		ArrayList<Integer> arrList = new ArrayList<>();
		for(int i = 0 ; i < 10 ; i++) {
			int random = (int)(Math.random() * 101);
			arrList.add (random);
		}
		System.out.println (arrList);
		
		//list에 저장된 값을 합계와 평균을 구해주세요
		int sum = 0;
		double avg = 0;
		for(int i = 0 ; i < arrList.size () ; i++) {
			sum += arrList.get (i);
		}
		avg = Math.round ((double)sum / arrList.size() * 100) / 100.0;
		System.out.println ("합계 : " + sum + ", 평균 : " + avg);
		
		//list에서 최소값과 최대값을 구해주세요
		
		
		int max = arrList.get (0);
		int min = arrList.get (0);
		for(int i = 1 ; i < arrList.size () ; i++) {
			if(max < arrList.get (i)) {
				max = arrList.get (i);
			}else if(min > arrList.get (i)) {
				min = arrList.get(i);
			}
		}
		System.out.println ("최대값 : " + max + ", 최소값 : " + min);
		
		//list를 오름차순으로 정렬해주세요.
		System.out.println("변경전 : " + arrList);
		
		for(int i = 0 ; i < arrList.size()-1; i++){//8보다 작을때까지
			int subKey = i;//최소값이 있는 위치를 알아야함.
			for(int j = i+1 ; j < arrList.size() ; j++){//9보다작을때까지
				if(arrList.get (subKey) > arrList.get (j)){ //비교 대상인것을 찾아야함.
					subKey = j; //최소값 인덱스 저장됨.
				}
			}
			int temp = arrList.get (i);
			arrList.set (i, arrList.get (subKey));
			arrList.set (subKey, temp);
			
		}
		System.out.println("변경후 : " + arrList);
		
		
		//2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		
		list = new ArrayList<>();
		list.add (10);
		list.add (20);
		list.add (30);
		list2.add (list);
		
		//초기화
		list = new ArrayList<>();
		list2.add (list);
		list.add (40);
		list.add (50);
//		Collection.sort(list2);
		
		System.out.println (list2);
		
		for(int i = 0 ; i < list2.size () ; i++) {
			ArrayList<Integer> li = list2.get (i);
			for(int j = 0 ; j < li.size () ; j++) {
				System.out.println (li.get(j) + "\t");
			}
			System.out.println ();
		}
		
		for(int i = 0 ; i < list2.size () ; i++) {
			for(int j = 0 ; j < list2.get (i).size() ; j++) {
				System.out.println (list2.get(i).get (j));
			}
		}
	}
}
