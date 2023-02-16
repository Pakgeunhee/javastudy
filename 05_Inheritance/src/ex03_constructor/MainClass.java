package ex03_constructor;

public class MainClass {
	
	public static void main(String[] args) {
		
		Student student = new Student();
		

	
	/*******************************************/
	
	Student studetn2 = new Student("정숙", "가산중학교");
	System.out.println(studetn2.getName());
	System.out.println(studetn2.getSchool());
	
	Alba alba = new Alba("상철", "가산대학교", "맥도날드");
	System.out.println(alba.getName());
	System.out.println(alba.getSchool());
	System.out.println(alba.getCompany());
	}
}
