package parking;

import java.util.Scanner;

public class ParkingLot {
	
	private String name;
	private Car[] cars;  
	private int idx;	
	private Scanner sc;
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
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
		
		
		cars[idx++] = new Car(carNo, model);
		
		System.out.println("차량번호" + carNo + "차량이 등록되었습니다.");		
		
	}	

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
	
	
	
	public void printAllCars() {

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
	
	public void manage() {
		
		while(true) {			
			System.out.print("1.추가 2.삭제 3.전체 0.종료 >>> ");
			
			String choice = sc.next(); 
			
			switch(choice) {
			case "1" :
				addCar();  
				break;
			case "2" :
				deleteCar(); 
				break;
			case "3" :
				printAllCars(); 
				break;
			case "0" :
				return;  
			default :
				System.out.println("존재하지 않는 메뉴입니다.");
			}
			
		}
	}
	
}
