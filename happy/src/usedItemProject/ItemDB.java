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
    System.out.println("itemDB 연결 성공");
  }

  // 전체 select, 찜갯수별, 등록시간순, 낮은시간순 정렬
  // select문에 order by 멘트를 추가하는 방식으로 구현



  // 셀렉트데이터는 괄호 안에 있는 값을 쿼리 끝에 order by로 추가함. 최대 3개까지 적용 가능


  // 메소드 오버로딩
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
    // executeQuery는 수행결과로 ResultSet 객체의 값을 반환한다.
    stmt = conn.createStatement();
    sql = "select * from itemDB";
    rs = stmt.executeQuery(sql);
    String str = null;

    // for문으로 바꿔서 한 줄씩 출력되게 만들어야
    while (rs.next()) {
      String id = rs.getString("id");
      String name = rs.getString("name");
      int price = rs.getInt("price");
      String address = rs.getString("address");
      String content = rs.getString("content");
      String transaction = rs.getString("transaction");
      int like = rs.getInt("like");


      // 기존 리턴
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


  // insertData만 만들어둠
  void insertData() throws SQLException {
    // executeUpdate는 반영된 레코드의 건수를 반환한다.(바로 insert, update, delete하면 되니까 rs를 리턴받을 필요가 없다)
    // 날짜 칸은 입력 안하면 오늘자가 자동으로 입력된다는데 확인해보자.

    System.out.println("ID를 입력하세요.");
    String inputId = sc.nextLine();
    System.out.println("제품명을 입력하세요.");

    String inputName = sc.nextLine();
    System.out.println("희망가격을 입력하세요.");
    String inputPrice = sc.nextLine();
    System.out.println("주소를 입력하세요.");
    String inputAddress = sc.nextLine();
    System.out.println("제품 설명을 추가해주세요.");
    String description = sc.nextLine();
    String inputContent = description;
    System.out.println("배송형태를 골라 주세요.");
    String inputTransaction = sc.nextLine();
    int intPrice = Integer.parseInt(inputPrice);
    stmt = conn.createStatement();

    String sql =
        String.format("insert into itemDB values(0,'%s','%s', %d,'%s', '%s', '%s',0,now())",
            inputId, inputName, intPrice, inputAddress, inputContent, inputTransaction);
    int result = stmt.executeUpdate(sql);

    System.out.println(result + " 건의 데이터를 처리했습니다.");
  }

  // 뭘 매개변수로 넣어서 delete를 실행하는 게 좋을까?
  void deleteData(String name) throws SQLException {
    stmt = conn.createStatement();
    String sql = String.format("delete from student where name=%s", name);
    int result = stmt.executeUpdate(sql);
    System.out.println(result + " 건의 데이터가 삭제되었습니다.");
  }



  // update 필요하면 구현


  void updateData() {}


  // 판매된 itemDB의 행 soldItemDB에 추가 > itemDB 행 삭제
  void moveData() {
	  
    // String column = null;
    // soldItemDB.insertData(column);

    // 특정한 행의 데이터를 가져와서 복제하고 기존 행을 삭제.

//	  select * from ItemDB_table where SoldItem_name = '';
//	  Insert Into destination_table (column_a, column_b) (select a, b from source_table) 
//	  
//	  insert into 테이블명1 (select * from 테이블명2)
//	  -- value()대신 서브쿼리가 들어갔다고 생각하면 된다.
//	   
//	  Insert Into destination_table (column_a, column_b) (select a, b from source_table) 
//	  -- 원하는 필드의 부분 데이터만 복사가 가능
	  
	

  }

}

