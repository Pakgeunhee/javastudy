package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot1 {
	
	private String name;
	private List<Car> cars;
	private Scanner sc;
	private int max;
	
	public ParkingLot1(String name, int max) {
		super();
		this.name = name;
		this.max = max;
		cars = new ArrayList<Car>();
		sc = new Scanner(System.in);
	}
	
	public void addCar() {
		
		System.out.println("현재 등록된 차량 : " + cars.size() + "대");
		if(cars.size() == max) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
		
		System.out.print("모델 >>> ");
		String model = sc.next();
		
		cars.add(new Car(carNo, model));
		System.out.println("차량번호" + carNo + "차량이 등록되었습니다.");
		
	}
	
	public void deleteCar() {
		
		if(cars.size() == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
		
		for(Car car : cars) {
			if(carNo.equals(car.getCarNo())) {
				cars.remove(car);
				System.out.println("차량번호 " + carNo + "인 차량이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("대상 차량이 존재하지 않습니다.");
	}
	
	public void printAllCars() {
		
		if(cars.size() == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		
		System.out.println(name + "차량 목록");
		for(Car car : cars) {
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
