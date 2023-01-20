package usedItemProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		while (true) {
			Scanner scan = new Scanner(System.in);
			private Connection con;
			private Statement stmt;
			private ResultSet rs;
			System.out.println("[ 옵션 번호를 선택해주세요 ]");
			System.out.println("1. 상품리스트 2.구매 3. 구매 내역 확인");

			int selectOption = scan.nextInt();
			scan.nextLine();
			
			if (selectOption == 1) {
				//itemList 테이블 
				public void itemList() {
					// 1. 연결공통메서드 호출
						
					try {
						setConn();
						// 2. Statement 객체 생성 (Connection ==> Statement)
						stmt = con.createStatement();
						String sql = "SELECT * FROM EMP";
						// 3. ResultSet 객체 생성.sql의 결과
						rs = stmt.executeQuery(sql);
						// 4. while()을 통해 결과 내용 처리 sql의 결과는 처리
						// rs.next() 행단위로 이동하게 처리..
						int rowNum = 1;
						while(rs.next()) {
							System.out.print(rowNum+++"행"+"\t");
							// rs.get데이터유형("컬럼명/alias명");
							System.out.print(rs.getInt("empno")+"\t");
							System.out.print(rs.getString("ename")+"\t");
							System.out.print(rs.getString("job")+"\t");
							System.out.print(rs.getInt("mgr")+"\t");
							System.out.print(rs.getDate("hiredate")+"\t");
							System.out.print(rs.getDouble("sal")+"\t");
							System.out.print(rs.getDouble("comm")+"\t");
							System.out.print(rs.getInt("deptno")+"\t");
							System.out.println();
						}
						// 5. 자원 해제
						rs.close();
						stmt.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						// 6. 예외 처리..
						System.out.println("오류:"+e.getMessage());
						if(rs!=null) rs = null; // 강제로 자원해제..
						if(stmt!=null) stmt = null; // 강제로 자원해제..
					}

				}
				
			} else if (selectOption == 2) {
				//구매
			} else if (selectOption == 3){
				//soldItem 	테이
				
				
			}
	
		}
		
	}

}