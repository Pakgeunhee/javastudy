package ex03_date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04_SimpleDataFormat {
	
	/*
	 	형식
	 	01. yy	 : 23
	 	02. yyyy : 2023
	 	03. M	 : 1 (1 ~ 12)
	 	04. MM	 : 01 (01 ~ 12)
	 	05. MMM  : 1월
	 	06. d	 : 17 (1 ~ 31)
	 	07. dd   : 17 (01 ~ 31)
	 	08. E    : 화
	 	09. a	 : 오후
	 	10. h	 : 2 (1 ~ 12)
	 	11. hh	 : 02 (01 ~ 12)
	 	12. H	 : 14 (0 ~ 23)
	 	13. HH	 : 14 (00 ~ 23)
	 	14. m	 : 8 (0 ~ 59)
	 	15. mm	 : 08 (00 ~ 59)
	 	16. s	 : 30 (0 ~ 59)
	 	17. ss	 : 30 (00 ~ 59) 
	 */

	public static void main(String[] args) {
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String strNow = sdf.format(now);
		System.out.println(strNow);		
		
	}

}
