package concert;

import javax.swing.JOptionPane;

public class ConsertHall {

	private SeatGroup[] seatGroups;  // 배열의 선언
	private String[] seatTypes = {"S", "R", "A"};
	private int[] seatCount = {30, 40, 50};
	
	
	// new ConcertHall()
	public ConsertHall() {
		seatGroups = new SeatGroup[seatTypes.length];  // 배열의 생성 (배열은 생성했을 때 null 값을 가지고 있음), 길이는 seatTypes/seatCount 상관없음
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i] = new SeatGroup(seatTypes[i], seatCount[i]);  // seatGroup의 생성자는 1개이기 때문에 가능함
		}
	}
	
	public void info(){
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i].info();			
			System.out.println("------------------------------");
		}
	}
	
	// 예약하기 (SeatGroup의 reserve 메소드와 함께 보면서 진행해야함)
	// ConsertHall의 예약 > SeatGroup의 예약 > Seat의 예약
	public void reserve() {
		String seatType = JOptionPane.showInputDialog("좌석 타입을 입력하세요.");
		for(int i = 0; i < seatTypes.length; i++) {
			if(seatType.equals(seatTypes[i])) {
				seatGroups[i].reserve();
				return;  // 예약 종료하기
			}
		}
		// 잘못 입력한 경우(for문 밖에서 구현하기)
		JOptionPane.showMessageDialog(null, "입력한 " + seatType + "은 존재하지 않습니다.");
	}
	
	// 예약취소하기
	public void cancel() {
		String seatType = JOptionPane.showInputDialog("좌석 타입을 입력하세요.");
		for(int i = 0; i < seatTypes.length; i++) {
			if(seatType.equals(seatTypes[i])) {
				seatGroups[i].cancel();
				return;  // 예약취소 종료하기
			}
		}
		// 잘못 입력한 경우(for문 밖에서 구현하기)
		JOptionPane.showMessageDialog(null, "입력한 " + seatType + "은 존재하지 않습니다.");
	}
	
	public static void main(String[] args) {
		ConsertHall hall = new ConsertHall();
		hall.reserve();
		hall.cancel();
		hall.info();
	}
}
