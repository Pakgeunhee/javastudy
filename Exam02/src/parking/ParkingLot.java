package parking;

import java.util.Scanner;

public class ParkingLot {
	
	private String name;
	private Car[] cars;  // cars[idx] = new Car("","");
	private int idx;	 // idx++; (idx는 자동차가 들어갈 자리이면서 실제로 주차된 자동차 수)
	private Scanner sc;
	
	
	// constructor
	// 매개변수로 주차장이름을 전달 받아서 필드를 초기화하고, 
	// 길이가 10인 cars 배열을 생성하고, 
	// 키보드로부터 정보를 입력 받을 수 있는 sc 인스턴스(객체)를 생성한다.
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() {
		// public void addCar()
		// (1) 가장 먼저 "현재 등록된 차량 0대"와 같은 메시지를 출력한다.
		// (2) 주차장이 가득찬 경우 "더 이상 차량 등록이 불가능합니다." 메시지를 출력하고 addCar() 메소드를 종료한다.
		// (3) sc 인스턴스를 이용해서 차량번호와 모델명을 입력 받은 뒤 cars 배열에 순차적으로 저장한다.
		// (4) 차량번호와 모델명은 공백 없는 문자열로 처리한다. 
		// (5) 차량번호가 "288러1111"과 같은 차량 등록이 성공하면 "차량번호 288러1111 차량이 등록되었습니다." 메시지를 출력한다.
		// (6) 기타 명시되지 않은 예외는 발생하지 않는 것으로 가정한다.
		
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		
		
		System.out.println("차량번호 >>> ");
		String carNo = sc.next();
		
		System.out.println("모델 >>> ");
		String model = sc.next();
		
		/*
		아래 방법으로 진행해도 위와 같은 내용
		System.out.println("차량번호와 모델명을 순서대로 입력하세요.");
		Car car = new Car(sc.next(), sc.next()))
		 */
		
		
		cars[idx++] = new Car(carNo, model);
		
		System.out.println("차량번호" + carNo + "차량이 등록되었습니다.");		
		
	}	

	public void deleteCar() {
		// 차량이 없을 경우
		if(idx == 0) {
			System.out.println("차량이 없습니다.");
			return;
		}
		
		// 주차장에서 차량이 나갈 경우
		System.out.println("현재 등록된 차량 : " + idx + "대");
		System.out.println("차량번호 >>> ");
		String carNo = sc.next();
				
		for(int i = 0; i < idx; i++) {
			if(cars[i].getCarNo().equals(carNo)) {
				cars[i] = cars[--idx];
				System.out.println("차량번호 " + carNo + "의 정산이 완료되었습니다.");
				break;
			} else {
				System.out.println("등록된 차량이 아닙니다.");
				return;
			}
		}
	}
	
	public void printAllCars() {
		// 현재 있는 차량의 총 대수, 등록된 차량 정보
		
		System.out.println("등록된 차량은 총 " + idx + "대입니다.");
		for(int i = 0; i < idx; i++) {
			System.out.println("현재 등록된 차량 번호는 " + cars[i].getCarNo() + "이며, 차량 모델은 " + cars[i].getModel() + "입니다.");
		}
		System.out.println("대박주차장을 이용해주셔서 감사합니다.");
		
		
	}
	
	public void manage() {
		
		while(true) {			
			System.out.println("1.추가 2.삭제 3.전체 0.종료 >>> ");
			
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
