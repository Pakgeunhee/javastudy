package practice03_Watch;

public class Watch {
	
	// 필드
		private int hour;  // 0 ~ 23
		private int minute;  // 0 ~ 59
		private int second;  // 0 ~ 59
		
		// 생성자
		public Watch(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		
		// 메소드
		public void addHour(int hour) {
			if(hour >= 24) {
				this.hour += (hour % 24);
			}
			else {
				this.hour += hour;				
			}
			
			System.out.println(hour + "시간 후(" + (hour % 24) + "시간)");
		}		

		public void addMinute(int minute) {
			if(minute > 60) {
				this.hour += (minute / 60);
				this.minute += (minute % 60);
			}
			else {
				this.minute += minute;
			}
			System.out.println(minute + "분 후(" + (minute / 60) + "시간 " + (minute % 60) + "분)");
		}
		
		public void addSecond(int second) {
			if(second > (60*60)) {
				this.hour += (second / 60 / 60);
				this.minute += (second / 60 % 60);
				this.second += (second % 60);						
			}
			else if(second > 60) {
				this.minute += (second / 60);
				this.second += (second % 60);
			}
			else {
				this.second += second;
			}
			System.out.println(second + "초 후(" + (second / 60 / 60) + "시간 " + (second / 60 % 60) + "분 " + (second % 60) + "초)");
		}
		
		public void see() {		
			System.out.println(hour + "시 " + minute + "분 " + second + "초");
		}
		
}
