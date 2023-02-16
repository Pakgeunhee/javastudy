package practice04_Shape;

public class Circle implements Shape {

	// 필드
	private double redius;
	
	
	// 생성자
	public Circle(double redius) {
		super();
		this.redius = redius;
	}

	@Override
	public double getArea() {
		return PI * redius * redius;

	}

}
