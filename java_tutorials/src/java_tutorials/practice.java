package java_tutorials;

import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		int count = 0;
		boolean run = true;
		int user = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("살까말까?! 종료를 입력하면 끝나요.");
		while (run) {
			count++;
			int random = (int) (Math.random() * 2) + 1;
			System.out.print("1과 2중 입력하세요:");
			String dodo = scanner.nextLine();
			if (dodo.equals("종료")) {
				System.out.println("프로그램을 종료 하겠습니다.");
				run = false;
			} else {
				user = Integer.parseInt(dodo);
				if (random == user) {
					System.out.println("고민하지말고 사세요!");
				} else if (random != user && user <= 2) {
					System.out.println("당신은 쇼핑이 금지 된 사람...");
				}
			}

		}
	}

}
