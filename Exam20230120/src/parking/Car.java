package parking;

// 롬복(lonbok) 실행

import lombok.ToString;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class Car {

// 문제1. 다음 구성요소를 가지는 Car 클래스를 구현하시오.
// 1) field
//	  (1) String carNo : 차량번호
//    (2) String model : 차량모델
	
	private String carNo;
	private String model;
	
// 2) constructor
// 모든 필드 값을 매개변수로 전달 받아서 필드 초기화를 진행하는 생성자
	
// 3) method
//    (1) getter
//    (2) setter
//    (3) toString()
	
// 문제2. Car 클래스의 생성자와 메소드는 롬복 라이브러리를 이용해서 생성하시오.
// 롬복(lombok) 라이브러리 설치 및 설정에 실패하는 경우
// 롬복(lombok) 라이브러리가 지원하는 애너테이션을 사용하지 말고 일반 코드로 작업을 수행하시오.
}
