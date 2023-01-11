package exam01;

public class Ex02 {
	
	public static void ex01() {
		// 문제1. int serial의 첫 번째 글자가 1,3,5이면 "남자", 2,4,6이면 "여자"를 출력하시오.
		// int serial의 첫 번째 글자는 항상 1 ~ 6 사이의 정수라고 가정한다.
		// 예시
		// 남자입니다.
		
		int serial = 123456;		
		
		while(serial >= 10) {
			serial = serial / 10;
		}
		
		if(serial % 2 == 0) {
			System.out.println("여자입니다.");
		}
		else {
			System.out.println("남자입니다.");
		}					
	}
	
	public static void ex02() {
		// 문제3. 구구단을 모두 출력하지 말고 5 x 5 = 25까지만 출력하시오.
		// 예시
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		// 5 x 5 = 25
		
		for(int dan = 2; dan <= 5; dan++) {
			for(int n = 1; n <= 9; n++) {
				if(dan == 5 && n == 6) {
					break;
				}
				System.out.println(dan + " X " + n + " = " + (dan * n));
			}						
		} 
	}
	
	public static void ex03() {
		// 문제5. 1부터 100 사이의 모든 짝수와 홀수를 각각 더한 결과를 모두 출력하시오.
		// 예시
		// 짝수 합은 2550입니다.
		// 홀수 합은 2500입니다.	
		
		int evenSum = 0;
		int oddSum = 0;
		
		for(int a = 1; a <= 100; a++) {
			if(a % 2 == 0) {
				evenSum += a;
			}
			else {
				oddSum += + a;				
			}
		}
		
		System.out.println("짝수 합은 " + evenSum + "입니다.");
		System.out.println("홀수 합은 " + oddSum + "입니다.");
		
	}	
	

	public static void main(String[] args) {

		ex01();
		ex02();
		ex03();

	}

}
