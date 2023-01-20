package bang;

import java.util.Scanner;

public class Pos {
	static User aaa;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		boolean run = true;
		String orderList[] = new String[5];
		int total = 0;
		int cupon = 0;

		while (run) {
			System.out.println("☆★☆★중앙 반점☆★☆★");
			System.out.println("0.쿠폰뽑기");
			System.out.println("1.주문하기");
			System.out.println("2.취소하기");
			System.out.println("3.결제하기");
			System.out.println("4.포인트 적립");
			System.out.println("5.종료");
			System.out.println("입력:");
			int num = sc.nextInt();

			if (num == 0) {
				cupon = (int) (Math.random() * 16 + 1);
				System.out.println("쿠폰 할인율: " + cupon + "%"); 
			}

			else if (num == 1) {
				String menuName = "";
				int menuPrice = 0;
				System.out.println("1. 짜장면\t5000원");
				System.out.println("2. 짬뽕\t6000원");
				System.out.println("3. 탕수육\t10000원");
				System.out.println("4. 볶음밥\t6000원");
				System.out.println("5. 짬짜면\t7000원");
				System.out.println("주문할 메뉴번호:");
				int menuNum = sc.nextInt();
				if (menuNum == 1) {
					menuName = "짜장면";
					menuPrice = 5000;
				} else if (menuNum == 2) {
					menuName = "짬뽕";
					menuPrice = 6000;
				} else if (menuNum == 3) {
					menuName = "탕수육";
					menuPrice = 10000;

				} else if (menuNum == 4) {
					menuName = "볶음밥";
					menuPrice = 6000;
				} else if (menuNum == 5) {
					menuName = "짬짜면";
					menuPrice = 7000;
				} else {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
				total += menuPrice;
				orderList[count] = menuName;
				count++;
				System.out.println("주문한 메뉴는 " + menuName + " 입니다.");
				System.out.println("가격은" + menuPrice + "입니다.");

			} else if (num == 2) {
				for (int i = 0; i < count; i++) {
					System.out.println(i + 1 + "," + orderList[i]);
				}

				System.out.print("취소할 메뉴번호: ");

				int cancelNum = sc.nextInt();
				if (1 <= cancelNum && cancelNum <= count) {
					String delMenu = orderList[cancelNum - 1];
					System.out.println(delMenu + "메뉴삭제!");
					for (int i = cancelNum - 1; i < count; i++) {
						orderList[i] = orderList[i + 1];
					}
					if (delMenu.equals("짜장면")) {
						total -= 5000;
					} else if (delMenu.equals("짬뽕")) {
						total -= 6000;
					} else if (delMenu.equals("탕수육")) {
						total -= 10000;
					} else if (delMenu.equals("볶음밥")) {
						total -= 6000;
					} else if (delMenu.equals("짬짜면")) {
						total -= 7000;
					}
					count--;
				}

			} else if (num == 3) {
				System.out.println("원래 결제 금액:" + total + "원");
				System.out.println("쿠폰적용가 금액:" + (total - (total / 100 * cupon)) + "원");

				System.out.println("지불할 금액:");
				int money = sc.nextInt();
				if (money < total - (total / 100 * cupon)) {
					System.out.println("지불할 금액이 부족합니다.");
					continue;
				} else {
					System.out.println("거스름 돈은 " + (money - total + (total / 100 * cupon)) + "원입니다.");
				} // 수중에 있는 금액 - 내야할 음식의 총 가격 + ( 쿠폰을 적용을 적용해서 받는 혜택금액)

			} else if (num == 4) {
				int totalPrice = total - (total / 100 * cupon); // 지불금액
				int point = 0; // 포인트 적립량
				int totalpoint = 0;
				new LoginApplication();
				aaa = LoginApplication.start(args);

				System.out.println("포인트 적립금:" + (totalPrice / 100 * 5) + "원");

//				System.out.println(aaa.getNickname());
				totalPrice = total - (total / 100 * cupon);
				point = (totalPrice / 100 * 5) + aaa.getPoint();
				totalpoint += point;
				System.out.println("--------------------------");
				System.out.println("총 결제 가격 : " + totalPrice + "원");
				System.out.println("--------------------------");
				System.out.println("적립후 포인트 : " + totalpoint + "포인트");
				System.out.println("--------------------------");

			} else if (num == 5) {
				System.out.println("결제완료!");
				run = !run;
			} else {
				System.out.println("잘못 입력하셨습니다.");
				total = 0;
				for (int i = 0; i < 5; i++) {
					orderList[i] = "";
				}
				count = 0;
			}

		}

	}

}
