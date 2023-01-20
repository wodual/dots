package usedItemProject;

import java.sql.*;
import java.util.*;

public class ItemDB {
  // columns: num, id, name, price, address, date
  Connection conn;
  Statement stmt;
  ResultSet rs;
  Scanner sc = new Scanner(System.in);
  String sql;
  SoldItemDB soldItemDB = new SoldItemDB();
  public ArrayList itemList = new ArrayList();

  ItemDB() throws ClassNotFoundException, SQLException {
    // connection part
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usedItemProject", "root2",
        "mysql");
    System.out.println("itemDB ���� ����");
  }

  // ��ü select, �򰹼���, ��Ͻð���, �����ð��� ����
  // select���� order by ��Ʈ�� �߰��ϴ� ������� ����



  // ����Ʈ�����ʹ� ��ȣ �ȿ� �ִ� ���� ���� ���� order by�� �߰���. �ִ� 3������ ���� ����


  // �޼ҵ� �����ε�
  ArrayList searchData(String column) throws SQLException {
    stmt = conn.createStatement();
    String sql = "select * from itemDB where name like '%" + column + "%'";
    rs = stmt.executeQuery(sql);
    String str = null;

    while (rs.next()) {
      String id = rs.getString("id");
      String name = rs.getString("name");
      int price = rs.getInt("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      int like = rs.getInt("like");


      itemList.add(String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like));
    }
    return itemList;
  }

  ArrayList selectData() throws SQLException {
    // executeQuery�� �������� ResultSet ��ü�� ���� ��ȯ�Ѵ�.
    stmt = conn.createStatement();
    sql = "select * from itemDB";
    rs = stmt.executeQuery(sql);
    String str = null;

    // for������ �ٲ㼭 �� �پ� ��µǰ� ������
    while (rs.next()) {
      String id = rs.getString("id");
      String name = rs.getString("name");
      int price = rs.getInt("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      int like = rs.getInt("like");


      // ���� ����
      // str += String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
      // transaction, like);
      itemList.add(String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, likes));
    }
    return itemList;
  }

  ArrayList selectData(String column) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB order by %s;", column);
    rs = stmt.executeQuery(sql);
    String str = null;

    while (rs.next()) {
      String id = rs.getString("id");
      String name = rs.getString("name");
      int price = rs.getInt("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      int like = rs.getInt("like");


      itemList.add(String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like));
    }
    return itemList;
  }

  ArrayList selectData(String column, String column2) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB order by %s, %s;", column, column2);
    rs = stmt.executeQuery(sql);
    String str = null;

    while (rs.next()) {
      String id = rs.getString("id");
      String name = rs.getString("name");
      int price = rs.getInt("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      int like = rs.getInt("like");


      itemList.add(String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like));
    }
    return itemList;
  }

  ArrayList selectData(String column, String column2, String column3) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from itemDB order by %s, %s, %s;", column, column2, column3);
    rs = stmt.executeQuery(sql);
    String str = null;

    while (rs.next()) {
      String id = rs.getString("id");
      String name = rs.getString("name");
      int price = rs.getInt("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      int like = rs.getInt("like");

      itemList.add(String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like));
    }
    return itemList;
  }


  // insertData�� ������
  void insertData() throws SQLException {
    // executeUpdate�� �ݿ��� ���ڵ��� �Ǽ��� ��ȯ�Ѵ�.(�ٷ� insert, update, delete�ϸ� �Ǵϱ� rs�� ���Ϲ��� �ʿ䰡 ����)
    // ��¥ ĭ�� �Է� ���ϸ� �����ڰ� �ڵ����� �Էµȴٴµ� Ȯ���غ���.

    System.out.println("ID�� �Է��ϼ���.");
    String inputId = sc.nextLine();
    System.out.println("��ǰ���� �Է��ϼ���.");

    String inputName = sc.nextLine();
    System.out.println("��������� �Է��ϼ���.");
    String inputPrice = sc.nextLine();
    System.out.println("�ּҸ� �Է��ϼ���.");
    String inputAddress = sc.nextLine();
    System.out.println("��ǰ ������ �߰����ּ���.");
    String description = sc.nextLine();
    String inputContent = description;
    System.out.println("������¸� ��� �ּ���.");
    String inputTransaction = sc.nextLine();
    int intPrice = Integer.parseInt(inputPrice);
    stmt = conn.createStatement();

    String sql =
        String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
            inputId, inputName, intPrice, inputAddress, inputContent, inputTransaction);
    int result = stmt.executeUpdate(sql);

    System.out.println(result + " ���� �����͸� ó���߽��ϴ�.");
  }

  // �� �Ű������� �־ delete�� �����ϴ� �� ������?
  void deleteData(String name) throws SQLException {
    stmt = conn.createStatement();
    String sql = String.format("delete from student where name=%s", name);
    int result = stmt.executeUpdate(sql);
    System.out.println(result + " ���� �����Ͱ� �����Ǿ����ϴ�.");
  }



  // update �ʿ��ϸ� ����


  void updateData() {}


  // �Ǹŵ� itemDB�� �� soldItemDB�� �߰� > itemDB �� ����
  void moveData() {
	  
    // String column = null;
    // soldItemDB.insertData(column);

    // Ư���� ���� �����͸� �����ͼ� �����ϰ� ���� ���� ����.

//	  select * from ItemDB_table where SoldItem_name = '';
//	  Insert Into destination_table (column_a, column_b) (select a, b from source_table) 
//	  
//	  insert into ���̺��1 (select * from ���̺��2)
//	  -- value()��� ���������� ���ٰ� �����ϸ� �ȴ�.
//	   
//	  Insert Into destination_table (column_a, column_b) (select a, b from source_table) 
//	  -- ���ϴ� �ʵ��� �κ� �����͸� ���簡 ����
	  
	

  }

}

