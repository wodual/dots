package lastday;

class OutClass {// 외부클래스
	private int num = 10;// 외부클래서 private 변수
	private static int sNum = 20; // 외부클래스 정적변수
	
	static class InStaticClass{
		int inNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			
		}
		static void sTest() {
			
		}
	}
}

	

//	private InClass inClass;// 내부클래스 자료형 변수를 먼저 선언
//
//	public OutClass() {
//		inClass = new InClass(); // 외부클래스 디폴트 생성자.외부클래스가 생성된 후에 내부클래스 생성가능
//	}
//
//	class InClass {// 인스턴스 내부클래스
//		int inNum = 100; // 내부 클래스의 인스턴스 변수
//
//		void inTest() {
//			System.out.println("OutClass num=" + num + "(외부클래스인스턴수변수)");
//			System.out.println("OutClass sNum=" + sNum + "(외부클래스인스턴수변수)");
//		}
//	}
//	public void usingClass() {
//		inClass.inTest();
//	}
//}
//
public class InnerTest {
	public static void main(String[] args) {
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		System.out.println("외부클래스 이용하여 내부클래스 기능 호출");
		sInClass. inTest();
		OutClass.InStaticClass.sTest();
	}
		

	}
	


