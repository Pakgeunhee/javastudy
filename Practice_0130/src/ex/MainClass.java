package ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainClass {

	public static void ex01() {
		// List<E> : E(Element, 요소) → 문자열은 String
		
		List<String> list1 = new ArrayList<String>();  // 1.7 이후로 생성자는 타입 명시를 생략할 수 있다.
		List<Integer> list2 = new ArrayList<Integer>();  // int는 기본타입이라 불가능, Integer로 변경해야 사용 가능
		List<Car> list3 = new ArrayList<>();
		
		// add 메소드는 마지막 요소로 추가한다. new ArrayList는 계속해서 추가 가능하지만, 하나씩만 저장이 가능함(add만 기억하면 좋음)
		list1.add("봄");
		list1.add("여름");
		list1.add("가을");
		list1.add("겨울");
		
		list2.add(10);
		list2.add(20);
		list2.add(30);
		list2.add(40);
		
		list3.add(new Car("벤츠", 100));
		list3.add(new Car("BM@", 200));
		
		System.out.println(list1);  // ArrayList는 toString이 이미 만들어져 있었다. -> 따로 toString 처리하지 않아도 출력
		System.out.println(list2);
		System.out.println(list3);	// Car는 toString을 따로 해줘야지 참조값이 아니라, 값으로 확인 가능함
	}
	
	public static void ex02() {
		
		List<String> list1 = Arrays.asList("봄", "여름", "가을", "겨울");
		List<Integer> list2 = Arrays.asList(10, 20, 30, 40);
		List<Car> list3 = Arrays.asList(new Car("벤츠", 100), new Car("BMW", 200));
		
		// list1.add("암튼계절");  (why?) static 메소드 → 고정값 → 데이터 추가 불가(추가,삭제 등 불가)
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}
	
	public static void ex03() {
		
		List<String> list = Arrays.asList("봄", "여름", "가을", "겨울");  // asList가 ArrayList를 해주는데, 다만 값을 못 바꿀 뿐
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		System.out.println(list.size());
		
		for(int i = 0, length = list.size(); i < length; i++) {  // length와 size는 그냥 정해진 거라서 분류 방법은 없음
			System.out.println(list.get(i));
		}
		
		for(String str : list) {
			System.out.println(str);
		}
		
		List<Car> list3 = Arrays.asList(
				new Car("벤츠", 100),
				new Car("BMW", 200)
		);
		
		for(int i = 0, length = list3.size(); i < length; i++) {
			System.out.println(list3.get(i));
		}
		
		for(Car car : list3) {
			System.out.println(car);
		}
				
	}
	
	public static void ex04() {
		
		Map<Integer, Car> map = new HashMap<Integer, Car>();
		
		// 추가
		map.put(1, new Car("벤츠", 100));
		map.put(2, new Car("BMW", 200));
		
		// Value 확인
		System.out.println(map.get(1));  // Key가 1인 Value 가져오기
		System.out.println(map.get(2));  // Key가 2인 Value 가져오기
	}
	
	public static void ex05() {
		
		Map<Integer, Car> map = new HashMap<Integer, Car>();
		
		map.put(1, new Car("벤츠", 100));  // Key가 1, Value가 new Car("벤츠", 100)인 Entry가 등록
		map.put(2, new Car("BMW", 200));   // Key가 2, Value가 new Car("BMW", 200)인 Entry가 등록
		
		for(Entry<Integer, Car> entry : map.entrySet()) {  // Entry 단위로 만들어져 있는 경우가 더 많음			
			System.out.println("Key는" + entry.getKey() + "이고, Value는 " + entry.getValue() + "이다.");
		}		
		
		for(Integer key : map.keySet()) {
			System.out.println("Key는" + key + "이고, Value는 " + map.get(key) + "이다.");
		}
	}
	
	public static void ex06() {
		
		Map<Integer, Car> home1 = new HashMap<>();
		home1.put(1, new Car("벤츠", 100));
		home1.put(2, new Car("BMW", 200));
		
		Map<Integer, Car> home2 = new HashMap<>();
		home2.put(1, new Car("테슬라", 300));
		home2.put(2, new Car("람보르기니", 400));
		
		List<Map<Integer, Car>> list = new ArrayList<>();
		list.add(home1);
		list.add(home2);
		
		/*
		Map<Integer, Car> map1 = list.get(0);
		System.out.println(map1);
		System.out.println(map1.get(1));
		System.out.println(map1.get(2));
		Map<Integer, Car> map2 = list.get(1);
		System.out.println(map2);
		System.out.println(map2.get(1));
		System.out.println(map2.get(2));
		*/
		
		for(Map<Integer, Car> map : list) {  // 여기에서의 map은 home1과 home2
			Set<Integer> keys = map.keySet();  // Set 순서 없음 -> 인덱스를 이용해서는 못구하기 때문에 향상 for문만 가능
			for(Integer key : keys) {
				System.out.println(map.get(key));
			}
		}
		
	}
	
	public static void ex07() {
		
		Map<String, Object> product1 = new HashMap<String, Object>();		
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		Map<String, Object> product2 = new HashMap<String, Object>();		
		product2.put("model", "냉장고");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		Map<String, Object> product3 = new HashMap<String, Object>();		
		product3.put("model", "TV");
		product3.put("maker", "삼성");
		product3.put("price", 300);
		
		List<Map<String, Object>> products = Arrays.asList(product1, product2, product3);
		
		for(Map<String, Object> product : products) {
			System.out.println("모델 :" + product.get("model"));
			System.out.println("제조사 :" + product.get("maker"));
			System.out.println("가격 :" + product.get("price"));
		}
	}
	
	public static void ex08() {
		
		FileWriter fw = null;
		
		FileReader fr = null;
		
		try {
			
			fw = new FileWriter("sample.txt");  // 경로를 따로 잡지 않는 경우, 자동으로 프로젝트에 제작됨
			fr = new FileReader("sample.txt");  // FileNotFoundException도 IOException 종류 중 하나이기 때문에 따로 예외로 잡지않음
			fw.close();
			fr.close();
			
		} catch(FileNotFoundException e) {  // catch가 여러 개일 경우, 순차적으로 왔다가 아닌 경우 다음 거로 넘어감
			e.printStackTrace();
		} catch(IOException e) { // IOException이 위로 갈 경우, File~로 넘어갈 수 없기 때문에 오류가 발생함(Unreachable catch block)
			e.printStackTrace();
		}
	}
	
	public static void ex09() throws FileNotFoundException, IOException {
		
		FileWriter fw = new FileWriter("sample.txt");
		FileReader fr = new FileReader("sample.txt");
		
		BufferedReader br = null;
		if(br == null) {
			throw new RuntimeException();  // Unchecked Exception(문법을 꼭 적어야되는 건 아니라서, throws에 꼭 입력할 필요는 없음)
		}
		
		fr.close();
		fw.close();
	}
	
	public static void ex10() {
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("sample.txt");
			fw.write(1);
			// fw.close();  예외가 발생하면 close를 못할 수 있어서 finally로 이동시킴
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {  // 예외가 발생해도 언제나 무조건 실행되는 메소드
			try {
				fw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		ex10();
		
		/*
		try { 
			ex09();			
		} catch(FileNotFoundException e) {  // 왜 에러가 일어나는지 정확한 사유를 확인하기 위해 예외 종류별로 구분하여 처리함
			System.out.println("sample.txt 파일이 없음"); 
		} catch(IOException e) {
			System.out.println("sample.txt 파일을 생성할 수 없음");
		} catch(RuntimeException e) {
			System.out.println("RuntimeException 발생");
		}
		*/

	}

}
