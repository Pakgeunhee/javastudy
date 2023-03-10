package re_exam;

import java.util.Arrays;

public class MainClass {
	
	// 문제1. 절대값 구하기
	// 예시) 5
	public static void ex01() {
		int number = -5;
		
		/*
		int absNumber;
		if(number >= 0) {
			absNumber = number;
		} else {
			absNumber = number;;      // absNumber = number * -1; (둘 다 가능)
		}
		*/
		
		int absNumber = (number >= 0) ? number : -number;
		
		System.out.println(absNumber);
	}

	// 문제2. 나이에 따른 구분하기
	// 0 ~ 7    : 미취학아동
	// 8 ~ 13   : 초등학생
	// 14 ~ 16  : 중학생
	// 17 ~ 19  : 고등학생
	// 20 ~ 100 : 성인
	// 나머지   : 잘못된 나이
	// 예시) 성인
	public static void ex02() {
	
		String strAge = "30";
		int age = Integer.parseInt(strAge);
		
		if(age < 0 || age > 100) {
			System.out.println("잘못된 나이");
		} else if(age <= 7) {
			System.out.println("미취학아동");
		} else if(age <= 13) {
			System.out.println("초등학생");
		} else if(age <= 16) {
			System.out.println("중학생");
		} else if(age <= 19) {
			System.out.println("고등학생");
		} else {
			System.out.println("성인");
		}		
	}
	
	// 문제3. 삼각형 넓이 구하기
	// 예시) 삼각형 넓이 : 4.5
	public static void ex03() {
		int width = 3;
		int height = 3;
		
		/*
		double area = (double)width * height / 2;
		double area = width * (double)height / 2;
		double area = (double)width * (double)height / 2;
		double area = width * height / 2.0;
		*/
		double area = width * height * 0.5;
		
		System.out.println("삼각형 넓이 : " + area);
	}
	
	// 문제4. 월 -> 계절과 마지막 일 출력하기
	// 12월~2월 겨울, 3월~5월 봄, 6월~8월 여름, 9월~11월 가을
	// 1월~12월이 아닌 경우, "13월은 잘못된 입력입니다."
	// 예시) 1월은 겨울입니다.
	//       1월은 31일까지 있습니다.
	public static void ex04() {
		/*
		 	month % 12 /3
		 	겨울 : 0
		 	봄 : 1
		 	여름 : 2
		 	겨울 : 3
		 */
		
		int month = 1;
		String[] season = {"겨울", "봄", "여름", "가을"};
		int[] lastDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  // 0은 dummy node(아무것도 안함)
		// int[] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
		
		if(month < 0 || month > 12) {
			System.out.println(month + "월은 잘못된 입력입니다.");
			return;
		}
		System.out.println(month + "월은 " + season[month % 12 / 3] + "입니다.");
		System.out.println(month + "월은 " + lastDay[month] + "일까지 있습니다.");
		// System.out.println(month + "월은 " + lastDay[month - 1] + "일까지 있습니다.");
				
	}
	
	// 문제5. 10과 가까운 수 찾기
	// 예시) 10과 가까운 수는 11입니다.
	public static void ex05() {
		int a = 8;
		int b = 11;
		int diff1 = (a > 10) ? a - 10 : 10 - a;
		int diff2 = (b > 10) ? b - 10 : 10 - b;
		System.out.println("10과 가까운 수는 " + (diff1 < diff2 ? a : b) + "입니다.");
	}
	
	// 문제6. money 분리하기
	// 예시) 50000원권 : 1개
	//       10000원권 : 3개
	//       ...
	//       1원권     : 4개
	public static void ex06() {
		int money = 87654;
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};  // 1원은 생략가능
		int[] count = new int[unit.length];
		
		/*
		count[0] = money / unit[0];
		money = money % unit[0];
		
		count[1] = money / unit[1];
		money = money % unit[1];
		...
		*/
		
		for(int i = 0; i < unit.length; i++) {
			count[i] = money / unit[i];
			money %= unit[i];
			System.out.println(unit[i] + "원권 : " + count[i] + "개");
		}	
		
		System.out.println(Arrays.toString(unit));   // 참고
		System.out.println(Arrays.toString(count));  // 참고
	}
		
	// 문제7. 2차원 배열에 구구단 결과 저장하기
	// 예시) 2 4 6 8 ... 18
	//       3 6 9 12 ... 27
	//       ...
	//       9 18 27 36 ... 81
	public static void ex07() {
		
		int[][] arr = new int[8][9];
		
		// 밑의 for문은 사실 상 합쳐서 작성해야하지만, 계산하고 출력하는 걸 보여주기 위해 따로 작성
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (i + 2) * (j + 1);
			}
		}	
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(String.format("%3d", arr[i][j]));
			}
			System.out.println();
		}
		
		System.out.println("-----------");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}		
		
		System.out.println("-----------");
		
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		
		/*
		 arr[0][0] = 2 * 1;
		 arr[0][1] = 2 * 2;
		 arr[0][2] = 2 * 3;
		 arr[0][3] = 2 * 4;
		 
		 arr[1][0] = 3 * 1;
		 arr[1][1] = 3 * 2;
		 arr[1][2] = 3 * 3;
		 arr[1][3] = 3 * 4;
		 
		 arr[2][0] = 4 * 1;
		 arr[2][1] = 4 * 2;
		 arr[2][2] = 4 * 3;
		 arr[2][3] = 4 * 4;
		 
		 arr[i][j] = (i + 2) * (j + 1);
		 */
	}
	
	public static void main(String[] args) {
		
		System.out.println("=====문제1=====");
		ex01();
		System.out.println("=====문제2=====");
		ex02();
		System.out.println("=====문제3=====");
		ex03();
		System.out.println("=====문제4=====");
		ex04();
		System.out.println("=====문제5=====");
		ex05();
		System.out.println("=====문제6=====");
		ex06();
		System.out.println("=====문제7=====");
		ex07();
	}

}
