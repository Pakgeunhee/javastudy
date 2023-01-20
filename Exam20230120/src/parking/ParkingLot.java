package parking;

// 문제3. 주차장을 의미하는 ParkingLot 클래스를 구현하시오.

import java.util.Scanner;

public class ParkingLot {
	
// 1) field
//    (1) String name : 주차장이름
//    (2) Car[] cars : Car 인스턴스를 저장할 수 있는 배열
//    (3) int idx : 배열의 인덱스
//    (4) Scanner sc : 키보드 입력을 처리하는 인스턴스
	
	private String name;
	private Car[] cars;  // cars[idx] = new Car("","");
	private int idx;	 // idx++; (idx는 자동차가 들어갈 자리이면서 실제로 주차된 자동차 수)
	private Scanner sc;
	
	
// 2) constructor
// 매개변수로 주차장이름을 전달 받아서 필드를 초기화하고, 
// 길이가 10인 cars 배열을 생성하고, 
// 키보드로부터 정보를 입력 받을 수 있는 sc 인스턴스(객체)를 생성한다.
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
// 3) public void addCar() {}
//    (1) 가장 먼저 "현재 등록된 차량 0대"와 같은 메시지를 출력한다.
//    (2) 주차장이 가득찬 경우 "더 이상 차량 등록이 불가능합니다." 메시지를 출력하고 addCar() 메소드를 종료한다.
//    (3) sc 인스턴스를 이용해서 차량번호와 모델명을 입력 받은 뒤 cars 배열에 순차적으로 저장한다.
//    (4) 차량번호와 모델명은 공백 없는 문자열로 처리한다. 
//    (5) 차량번호가 "288러1111"과 같은 차량 등록이 성공하면 "차량번호 288러1111 차량이 등록되었습니다." 메시지를 출력한다.
//    (6) 기타 명시되지 않은 예외는 발생하지 않는 것으로 가정한다.
	
	public void addCar() {
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		
		
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
		
		System.out.print("모델 >>> ");
		String model = sc.next();
		
		/*
		아래 방법으로 진행해도 위와 같은 내용
		System.out.println("차량번호와 모델명을 순서대로 입력하세요.");
		Car car = new Car(sc.next(), sc.next()))
		 */
		
		// (+) 만약 동일한 차량번호라면?
		

		for(int i = 0; i < idx; i++) {
			if(cars[i].getCarNo().equals(carNo) && cars[i].getModel().equals(model)) {
				System.out.println("이미 등록된 차량입니다.");
				break;
			} else {
				cars[idx++] = new Car(carNo, model);
				System.out.println("차량번호" + carNo + "차량이 등록되었습니다.");	
			}				
		}
	
		
	}	
	
// 4) public void deleteCar() {}
//	  (1) 주차장이 비어 있는 경우 "등록된 차량이 없습니다." 메시지를 출력하고 deleteCar() 메소드를 종료한다.
//	  (2) sc 인스턴스를 이용해서 제거할 차량번호를 입력 받은 뒤 해당 차량번호와 일치하는 정보를 삭제한다.
//	  (3) 차량번호가 "288러1111"인 차량을 삭제한 경우 "차량번호 288러1111 차량이 삭제되었습니다." 메시지를 출력한다.
//	  (4) 입력된 차량번호와 일치하는 정보가 없는 경우 "대상 차량이 존재하지 않습니다." 메시지를 출력한다.

	public void deleteCar() {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
				
		for(int i = 0; i < idx; i++) {
			if(cars[i].getCarNo().equals(carNo)) {
				cars[i] = cars[--idx];
				System.out.println("차량번호 " + carNo + "차량이 삭제되었습니다.");
				break;
			} else {
				System.out.println("대상 차량이 존재하지 않습니다.");
				return;
			}
		}
	}
	
// 5) public void printAllCars() {}
// 	  (1) 주차장이 비어 있는 경우 "등록된 차량이 없습니다." 메시지를 출력하고 printAllCars() 메소드를 종료한다.
//	  (2) 가장 먼저 주차장이름을 출력한다.
//	  (3) 저장된 모든 차량(cars) 정보를 System.out.println() 메소드를 이용해서 출력한다.
	
	public void printAllCars() {
		// 현재 있는 차량의 총 대수, 등록된 차량 정보
		
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		
		System.out.println(name + " 차량 목록");
		for(int i = 0; i < idx; i++) {
			Car car = new Car(cars[i].getCarNo(), cars[i].getModel());
			System.out.println(car);
		}
	}
		
// 6) public void manage() {}
//	  (1) "1.추가 2.삭제 3.전체 0.종료" 메뉴를 운용한다.
//	  (2) 무한루프 내부에서 사용자 입력(1,2,3,0)에 따라서 적절한 메소드를 호출한다.
//	  (3) 잘못된 메뉴를 입력하는 경우 "존재하지 않는 메뉴입니다." 메시지를 출력한다.
	
	public void manage() {
		
		while(true) {			
			System.out.print("1.추가 2.삭제 3.전체 0.종료 >>> ");
			
			// int choice = sc.nextInt();  같은 방식 int 1인지 String "1"인지 -> int를 쓰면 문자를 입력했을 때 치명적인 오류가 발생함
			String choice = sc.next(); 
			
			switch(choice) {
			case "1" :
				addCar();  // addCar 호출
				break;
			case "2" :
				deleteCar(); // deleteCar 호출
				break;
			case "3" :
				printAllCars(); // printAllCars 호출
				break;
			case "0" :
				return;  // manage 메소드 종료
			default :
				System.out.println("존재하지 않는 메뉴입니다.");
			}
			
		}
	}
	
}
