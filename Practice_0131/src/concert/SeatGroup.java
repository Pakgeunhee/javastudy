package concert;

import javax.swing.JOptionPane;

public class SeatGroup {

	// 각 좌석 타입마다 좌석의 개수가 다르다는 걸 기본으로 함
	
	private String seatType;  // "S", "R", "A"
	private Seat[] seats;	  // 배열의 선언
	
	// new SeatGroup("S", 30) : "S"석이 30개 있다.
	public SeatGroup(String seatType, int length) {  // 좌석의 개수는 배열의 길이로 가져옴
		this.seatType = seatType;			// 좌석 타입 설정
		seats = new Seat[length];			// 배열의 생성
		for(int i = 0; i < length; i++) {
			seats[i] = new Seat();  		// 점유되지 않은 빈 좌석을 배열의 길이만큼 만들기(더 이상 new Seat()는 안해도 됨)
		}
	}
	
	// 예매 상황
	public void info() {
		
		System.out.println("[" + seatType + "]");
		for(int i = 0; i < seats.length; i++) {
			
			System.out.print((i < 9 ? "0" : "") + (i + 1));  // (1~9까지는 0을 붙이고 번호 달기)
			
			if(seats[i].isOccupied() == false) {			   // false = 비어있는 좌석이라면?
				System.out.print("      ");					   // 예약자 없음(공백 출력) 
			} else {
				System.out.print(seats[i].getName());		   // 예약자 출력
			}
			
			// 인덱스의 일의 자리가 9이면 줄을 바꾸고, 아니면 공백을 준다.
			if(i % 10 == 9) {
				System.out.println();
			} else {
				System.out.print(" ");
			}
			
		}
		
	}
	
	// 예약하기
	public boolean reserve() {  // boolean 값으로 받기 때문에 return true/false로 받음
		
		info();  // 예매 상황 보여주기
		
		// Scanner 대신 사용할 수 있는 대화상자(input은 입력받기, message는 보여주기)
		String strNo = JOptionPane.showInputDialog("예약할 시트번호를 입력하세요.");  // 대화상자로 입력 받는 경우, 무조건 String 타입
		int seatNo = Integer.parseInt(strNo);  
		
		if(seatNo < 1 || seatNo > seats.length) {
			JOptionPane.showMessageDialog(null, seatNo + "번 좌석은 없는 좌석입니다.");  // null은 추후 배울 내용(사용법으로만 이해하기)
			return false;  // 예약하기 실패
		}
		
		if(seats[seatNo - 1].isOccupied()) {  // 인덱스는 0 ~ 29, seatNo는 1 ~ 30
			JOptionPane.showMessageDialog(null, seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false;  // 예약하기 실패
		}
		
		String name = JOptionPane.showInputDialog("예약자 성함을 입력하세요.");
		seats[seatNo - 1].reserve(name);  // seat 클래스로 setName값 전달
		JOptionPane.showMessageDialog(null, seatNo + "번 좌석 예약이 성공했습니다.");
		return true;  // 예약하기 성공
	}
	
	// 예약 취소하기
	public boolean cancel() {
		
		info();
		String name = JOptionPane.showInputDialog("취소자 성함을 입력하세요.");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied() && seats[i].isMatched(name)) {  // 예약자 중 같은 이름은 없다는 가정으로 풉니다.
				seats[i].cancel();
				JOptionPane.showMessageDialog(null, "예약자 " + name + "의 예약이 취소되었습니다.");
				return true;
			}
		}
		
		// 동일한 이름이 입력되지 않은 경우(for문 밖에서 입력해야함)
		JOptionPane.showMessageDialog(null, "입력된 이름 " + name + "은 존재하지 않습니다.");
		return false;
	}
		
}

/*
	// 좌석 전체 훑어주는 메소드(seats[i] 값 확인용)
	public void info() {
		for(int i = 0; i < seats.length; i++) {
			System.out.println(seats[i].isOccupied());
			// Seat seat = seats[i];
			// System.out.println(seat.isOccupied());
			// 모두 false 값 나와야함 (모두 점유되지 않았다는 의미 = null) -> 하지만, null.isOcuupied -> NullpointException 오류 발생
			// SeatGroup 메소드의 for문을 통해서 점유여부만 확인할 수 있도록 변환함
		}
	}
	public static void main(String[] args) {
		SeatGroup seatGroup = new SeatGroup("S", 30);
		seatGroup.reserve();
		seatGroup.cancel();
		seatGroup.info();
	}
*/