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
			System.out.println("[ �ɼ� ��ȣ�� �������ּ��� ]");
			System.out.println("1. ��ǰ����Ʈ 2.���� 3. ���� ���� Ȯ��");

			int selectOption = scan.nextInt();
			scan.nextLine();
			
			if (selectOption == 1) {
				//itemList ���̺� 
				public void itemList() {
					// 1. �������޼��� ȣ��
						
					try {
						setConn();
						// 2. Statement ��ü ���� (Connection ==> Statement)
						stmt = con.createStatement();
						String sql = "SELECT * FROM EMP";
						// 3. ResultSet ��ü ����.sql�� ���
						rs = stmt.executeQuery(sql);
						// 4. while()�� ���� ��� ���� ó�� sql�� ����� ó��
						// rs.next() ������� �̵��ϰ� ó��..
						int rowNum = 1;
						while(rs.next()) {
							System.out.print(rowNum+++"��"+"\t");
							// rs.get����������("�÷���/alias��");
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
						// 5. �ڿ� ����
						rs.close();
						stmt.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						// 6. ���� ó��..
						System.out.println("����:"+e.getMessage());
						if(rs!=null) rs = null; // ������ �ڿ�����..
						if(stmt!=null) stmt = null; // ������ �ڿ�����..
					}

				}
				
			} else if (selectOption == 2) {
				//����
			} else if (selectOption == 3){
				//soldItem 	����
				
				
			}
	
		}
		
	}

}