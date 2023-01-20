package usedItemProject;

import java.sql.*;
import java.util.Scanner;

public class SoldItemDB {
  // columns: num, id, name, price, address, date
  Connection conn;
  Statement stmt;
  ResultSet rs;
  Scanner sc = new Scanner(System.in);
  String sql;


  SoldItemDB() throws ClassNotFoundException, SQLException {
    // connection part
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usedItemProject", "root2",
        "mysql");
    System.out.println("soldItemDB ���� ����");
  }

  // ��ü select, �򰹼���, ��Ͻð���, �����ð��� ����
  // select���� order by ��Ʈ�� �߰��ϴ� ������� ����



  // ����Ʈ�����ʹ� ��ȣ �ȿ� �ִ� ���� ���� ���� order by�� �߰���. �ִ� 3������ ���� ����


  // �޼ҵ� �����ε�
  String searchData(String column) throws SQLException {
    stmt = conn.createStatement();
    String sql = "select * from soldItemDB where name like '%" + column + "%'";
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


      str += String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like);
    }
    return str;
  }

  String selectData() throws SQLException {
    // executeQuery�� �������� ResultSet ��ü�� ���� ��ȯ�Ѵ�.
    stmt = conn.createStatement();
    sql = "select * from soldItemDB";
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


      str += String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like);
    }
    return str;
  }

  String selectData(String column) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from soldItemDB order by %s;", column);
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


      str += String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like);
    }
    return str;
  }

  String selectData(String column, String column2) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from soldItemDB order by %s, %s;", column, column2);
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


      str += String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like);
    }
    return str;
  }

  String selectData(String column, String column2, String column3) throws SQLException {
    stmt = conn.createStatement();
    sql = String.format("select * from soldItemDB order by %s, %s, %s;", column, column2, column3);
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


      str += String.format("[%s] %s %d %s %s %s %d \n", id, name, price, address, content,
          transaction, like);
    }
    return str;
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
        String.format("insert into soldItemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
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


  // �Ǹŵ� soldItemDB�� �� soldsoldItemDB�� �߰� > soldItemDB �� ����
  void moveData() {

    // addActionListener�� Ŭ�� �ν�. this



  }

}

