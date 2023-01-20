package com.auto.stock;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] 	acno 		= new int[100];		// 계좌번호
	static int[] 	acnotPw		= new int[100];		// 계좌비밀번호
	static int[] 	amount		= new int[100];		// 예치금액
	
	static int 		acnoNum;					// 계좌번호 배열 순번
	static int 		inAmountNum;				// 입금계좌에 대한 금액 배열 순번
	static int 		outAmountNum;				// 출금계좌에 대한 금액 배열순번
	static boolean	acnoPwChk 		= false;	// 계좌정보 삭제(비밀번호 검증여부)
	static boolean	accountPwChk 	= false;	// 입출금 비밀번호(비밀번호 검증여부)
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("--------------중앙은행-----------------");
			System.out.println("1.계좌생성 | 2.출금 | 3.입금 | 4.잔액확인 | 5.종료 | 6.전체 계좌정보 조회");
			System.out.println("------------------------------------");
			System.out.println("원하는 번호를 눌러주세요>>");

			int selectNum = scan.nextInt();
			
			// 계좌생성
			if (selectNum == 1) {
				Account(selectNum);	
			} 
			// 출금
			else if (selectNum == 2) {
				AmountProcess(selectNum);	
			} 
			// 입금
			else if (selectNum == 3) {
				AmountProcess(selectNum);		
			} 
			// 잔액정보
			else if (selectNum == 4) {
				AccountList(selectNum);	
			} 
			// 시스템 종료
			else if (selectNum == 5) {
				return;	
			} 
			// 계좌 리스트 정보
			else if (selectNum == 6) {
				accnoList();
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}

		}
	}

	// main에서 불러오기 위해 객체화 했다.
	private static void Account(int selectNum) {

		int inputAcno;		// 계좌번호

		System.out.println("계좌생성은 1번 \n 계좌 삭제는 0번을 눌러주세요.");
		
		Scanner sc = new Scanner(System.in);
		selectNum = sc.nextInt();
		
		// 계좌생성
		if (selectNum == 1) {
			
			// 첫번째 계좌생성시 배열의 index 지정
			if(acno[0] != 0) {
				acnoNum = acnoNum + 1;
			}
						
			// 계좌번호 생성
			inputAcno = acnoMake(selectNum);
			
			// 비밀번호 생성
			inputAcnoPw(selectNum);
			
			System.out.println("고객님의 계좌번호는" + inputAcno + "입니다.");
			
		}
		// 계좌삭제
		else if (selectNum == 0) {
			// 계좌번호 삭제
			acnoDel();
		}
	}

	// 입금, 출금 처리
	private static void AmountProcess(int selectNum) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계좌번호를 입력하세요.");
		int inputAcno = sc.nextInt();

		if(acnoSerch(inputAcno, selectNum)	// 계좌번호 체크
			&& accountPwChk == true) {		// 비밀번호 체크
			
			System.out.println("계좌번호를 확인 후 재진행 해주세요. \n 처음화면으로 돌아갑니다.");
			return;
		}
		else {
			
			System.out.println("비밀번호를 입력해주세요");
			int inputPw = sc.nextInt();
			
			// 비밀번호 검증
			acnoPw(selectNum, inputPw, 0);

			// 비밀번호 검증 체크
			if(!accountPwChk) {
				System.out.println("비밀번호를 확인 후 재진행 해주세요.");
				AmountProcess(selectNum);	// 입출금 재호출
			}
			// 예금액 입출금
			else {
				
				// switch 문 이해를 돕기 위하여 사용을 위한 테스트 로직 추가 (출력 내용 수정하면, 미사용해도 상관없음)
				String message = "";
						
				switch (selectNum) {
				case 2:
					message = "출금";
					break;
				case 3:
					message = "입금";
					break;
				default:
					break;
				}
				
				System.out.println(message + " 금액을 입력해주세요");
				int inputAmount = sc.nextInt();
				
				// 출금
				if(selectNum == 2) {
					if(amount[acnoNum] == 0) {
						System.out.println("출금잔액이 부족합니다.");
						return;
					}
					
					amount[acnoNum] -= inputAmount;	// 출금
				}
				// 입금
				else if (selectNum == 3) {
					amount[acnoNum] += inputAmount;	// 입금
				}
				
				accountPwChk = false;	// 계좌비밀번호 검증 초기화
				
				System.out.println("정상적으로 " + message + " 처리 되었습니다.");
			}
		}
	}
	
	// 계좌잔액확인
	private static void AccountList(int selectNum) { 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("계좌를 입력해주세요.");
		int inputAcno = sc.nextInt();
		
		// 계좌정보 조회
		acnoSerch(inputAcno, selectNum);
		
		System.out.println("조회 하신 '" + acno[acnoNum] + "' 계좌번호의 잔액은 " + amount[acnoNum] + "원 입니다.");
		
	}
	
	/*
	 * 전체계좌정보 조회
	 *  등록여부 확인
	 * */
	public static void accnoList() {
		
		System.out.println("계좌번호 리스트 정보 :: " + Arrays.toString(acno));
		System.out.println("비밀번호 리스트 정보 :: " + Arrays.toString(acnotPw));
		System.out.println("예금액 리스트 정보 :: " + Arrays.toString(amount));
	}
	
	
	/* 계좌번호 조회
	 * 	조회시 계좌번호 존재시 true 반환
	 * 	입출금 계좌번호에 대한 배열 index 저장
	 * selectNum (1: 생성, 2:입금, 3:출금, 4:잔액정보, 5:종료)
	 * */
	public static boolean acnoSerch(int inputAcno, int selectNum) {
		
		boolean acnoCheck = false;	// 중복여부 (true: 중호계좌번호, flase:신규계좌번호)

		// 입력된 계좌정보 추출
		for(int i = 0; i < acno.length; i++) {
			if(acno[i] == inputAcno) {
				acnoCheck = true;	// 중복계좌번호
				
				// 계좌생성 및 종료가 이난경우 index 값 세팅
				if(selectNum != 1) {
					acnoNum = i;	// 계좌의 index 저장
				}
				break;
			}
			
			// 계좌생성시에 처리
			else if(selectNum == 1) {
				// 계좌 정보가 삭제된 경우 
				if(acno[i] == 0){
					// 배열의 빈 index 정보 추출
					acnoNum = i;	// 계좌의 index 저장
					break;
				}	
			}
			
		}
		
		return acnoCheck;
	}
	
	/* 
	 * 계좌번호 생성
	 * */
	public static int acnoMake(int selectNum) {
		
		int acnoMake = (int) ((Math.random() + 1) * 10000);	// 계좌번호 생성
		
		// 계좌번호 중복 조회
		boolean acnoCheck = acnoSerch(acnoMake, selectNum);
		
		// 중복 계좌번호 존재시 중복 계좌발급이 안되도록 재생성
		if(acnoCheck) {
			acnoMake = acnoMake(selectNum);
		}

		acno[acnoNum] = acnoMake;	// 계좌번호 배열에 저장
		return acnoMake;
	}

	/* 
	 * 계좌번호에 대한 정보(계좌번호, 비밀번호, 예금액) 삭제
	 * */
	public static void acnoDel() {
		
		int 	inputAcno; 		// 계좌번호
		int 	acnoPW;			// 계좌비밀번호
		
		Scanner sc = new Scanner(System.in);
		System.out.println("test");
		// 삭제 계좌번호 검증 
		if(!acnoPwChk) {
			System.out.println("삭제할 계좌번호를 입력해 주세요");
			inputAcno = sc.nextInt();
			
			// 입력 받은 계좌번호 정보 조회
			boolean acnoCheck = acnoSerch(inputAcno, 0);
			
			// 계좌정보가 존재하는 경우 비밀번호 입력
			if(acnoCheck) {
				System.out.println("비밀번호를 입력해주세요");
				acnoPW = sc.nextInt();
				
				// 비밀번호 검증
				acnoPw(0, acnoPW, 0);
				
			}else {
				System.out.println("계좌번호를 확인 후 재진행 해주세요. \n 처음화면으로 돌아갑니다.");
				return;
			}			
		}
		// 삭제 비밀번호 재검증
		else {
			
			System.out.println("비밀번호를 재입력해주세요");
			acnoPW = sc.nextInt();
			
			// 비밀번호 검증
			acnoPw(0, acnoPW, 0);
		}
		
		// 계좌정보가 삭제된 경우
		if(acnoPwChk) {
			
			acno[acnoNum]		= 0;	// 계좌번호 삭제
			acnotPw[acnoNum]	= 0;	// 계좌비밀번호 삭제
			amount[acnoNum]		= 0;	// 예치금액 삭제
			
			System.out.println("계좌번호가 삭제 되었습니다");	
		}
		
		return;
	}
	
	/* 
	 * 비밀번호 입력
	 * selectNum (1: 생성, 2:입금, 3:출금, 4:잔액정보, 5:종료)
	 * */
	public static boolean inputAcnoPw(int selectNum) {
		
		int 	password1; // 첫번째 입력 비밀번호
		int 	password2; // 두번째 입력 비밀번호
		
		Scanner sc = new Scanner(System.in);
		
		// 계좌생성시 비밀번호 생성
		if(selectNum == 1) {
			
			System.out.println("고객님의 계좌번호에 사용할 비밀번호를 입력해주세요.");
			password1 = sc.nextInt();
			System.out.println("비밀번호를 한번 더 입력해주세요");
			password2 = sc.nextInt();
			
			// 비밀번호 유효성 체크 호출
			acnoPw(selectNum, password1, password2);

			// 계좌비밀번호 입력 및 비밀번호 이중 입력 체크
			if(acnoPwChk) {
				inputAcnoPw(selectNum);	// 비밀번호 재입력
			}else {
				acnotPw[acnoNum] = password1;	// 비밀번호 배열에 저장				
			}
		}
		
		return acnoPwChk;
	}
	
	/* 
	 * 비밀번호 검증
	 * selectNum (1: 생성, 2:입금, 3:출금, 4:잔액정보, 5:종료)
	 * password1 : 첫번쨰 입력받은 비밀번호, 삭제시 계좌비밀번호
	 * password2 : 두번째 입력받은 비밀번호
	 * selectNum : 1 인경우 두개의 비밀번호크 동일한지 유무 체크 
	 * */
	public static void acnoPw(int selectNum, int password1, int password2) {
		
		// 계좌생성 비밀번호 유효성 체크
		if(selectNum == 1) {
			if(password1 != password2) {
				acnoPwChk = true;	// 입력받은 계좌의 비밀번호가 다름
			}
		}
		// 계좌정보 삭제 비밀번호 검증
		else if(selectNum == 0) {
			// 계좌비밀번호 재검증 요청
			if(acnotPw[acnoNum] != password1) {
				acnoPwChk = false;	// 비밀번호 불일치 
				acnoDel();			// 계좌정보삭제 재요청
			}else {
				acnoPwChk = true;	// 비밀번호 일치
			}
		}
		// 입금, 출금 비밀번호 검증
		else if(selectNum == 2 || selectNum == 3) {
			// 계좌비밀번호 재검증 요청
			if(acnotPw[acnoNum] != password1) {
				accountPwChk = false;	// 입출금 비밀번호 불일치 
			}else {
				accountPwChk = true;	// 입출금 비밀번호 일치
			}
		}
	}
}
