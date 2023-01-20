package lastday;
	class Outer2{
		Runnable getRunnable(int i) {
			int num = 100;
			
			return new Runnable() { //익명내부클래스 러너블 인터페이스생성

				@Override
				public void run() {
					System.out.println(i);
					System.out.println(num);
					
				}
				
			};
		}
		Runnable runner = new Runnable() {

			@Override
			public void run() {
				System.out.println("Runnable이 구현된 익명 클래스 변수");
				
			}
		};
	}
public class AnonymousInnerTest {

	public static void main(String[] args) {
		Outer2 out = new Outer2();
		Runnable runnerble = out.getRunnable(10);
		runnerble.run();
		out.runner.run();

	}

}
