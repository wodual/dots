package lastday;

class Outer{
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num =100;
		
		class MyRunnable implements Runnable{
			int localNum = 10;
			
			public void run() {
				System.out.println("i =" + i);
				System.out.println("num ="+ num);
				System.out.println("localNum=" + localNum);
				System.out.println("outNum = "+ outNum +"(외부클래스 인스턴스 변수)");
				System.out.println("Outer.sNum="+Outer.sNum+"(외클 정적변수)");
			}
		}
	return new MyRunnable();
	}
}

public class LocallnnerTest {

	public static void main(String[] args) {
		Outer out = new Outer();
		Runnable runner = out.getRunnable(10);
		runner.run();

	}

}
