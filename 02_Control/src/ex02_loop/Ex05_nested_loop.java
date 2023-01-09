package ex02_loop;

public class Ex05_nested_loop {
	
	public static void ex01() {
		
		for(int day = 1; day <= 5; day++) {
			for(int hour = 1; hour <= 8; hour++) {
				System.out.println(day + "일차 " + hour + "교시 수업");
			}
		}
		
	}
	
	public static void ex02() {
		
		int day = 1;		
		while(day <= 5) {
			
			int hour = 1;			
			while(hour <= 8) {
				System.out.println(day + "일차 " + hour + "교시 수업");
				hour++;
			}
			
			day++;
		}
	}
	
	public static void ex03() {  // 연습
		
		// 전체 구구단 출력하기
		// 2 X 1 = 2
		// ...
		// 9 X 9 = 81
		
		for(int dan = 2; dan <= 9; dan++) {
			for(int n = 1; n <= 9; n++) {
				System.out.println(dan + " X " + n + " = " + (dan * n));
			}
		}
				
	}
	
	public static void ex04() {  // 연습
		
		// 전체 구구단 출력하기
		// 2X1=2 3X1=3 4X1=4 ... 9X1=9
		// ...
		// 2X9=18 3X9=27 4X9=36 ... 9X9=81
		
		for(int n = 1; n <= 9; n++) {
			for(int dan = 2; dan <= 9; dan++) {
				System.out.print(dan + "X" + n + "=" + (dan * n) + "\t");
			}
			System.out.println();
			
		}
				
	}

	public static void main(String[] args) {
		
		ex04();	

	}

}
