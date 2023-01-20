package usedItemProject;

import java.sql.SQLException;
import java.util.*;

public class projectEx {



  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Scanner sc = new Scanner(System.in);
    int selectNum = 0;
    boolean run = true;
    ArrayList itemList = new ArrayList();
    ItemDB itemDB = new ItemDB();
    SoldItemDB soldItemDB = new SoldItemDB();
    // �� ��ȣ �Է¹޾� CRUD �����ϰ� �����ص�.


    while (run) {
      System.out.println("1.select(+����) 2.insert 3.delete 4.search");
      selectNum = sc.nextInt();
      if (selectNum == 1) {
        System.out.println("��ü �����͸� ����մϴ�.");
        itemDB.selectData();


        int inputSelect1;
        int inputSelect2;
        int inputSelect3;
        String inputColumn1;
        String inputColumn2;
        String inputColumn3;


        System.out.println("�Է��� �Ű����� ������� ����(�ִ� 3��)");
        System.out.println("�Է��Ͻðڽ��ϱ�? y=1, n=0");
        inputSelect1 = sc.nextInt();

        if (inputSelect1 == 1) {
          System.out.println("�÷����� �ϳ� �Է��ϼ���.");
          inputColumn1 = sc.next();
          System.out.println("�ϳ� �� �Է��Ͻðڽ��ϱ�? y/n");
          inputSelect2 = sc.nextInt();
          if (inputSelect2 == 1) {
            inputColumn2 = sc.next();
            System.out.println("�ϳ� �� �Է��Ͻðڽ��ϱ�? y/n");
            inputSelect3 = sc.nextInt();
            if (inputSelect3 == 1) {
              inputColumn3 = sc.next();
              System.out.println("3������ �����ؼ� ����մϴ�.");
              System.out.println(itemDB.selectData(inputColumn1, inputColumn2, inputColumn3));


            } else if (inputSelect3 == 0) {
              itemList = itemDB.selectData(inputColumn1, inputColumn2);
              for (int i = 0; i < itemList.size(); i++) {
                System.out.println(itemList.get(i));
              }
            }
          } else if (inputSelect2 == 0) {
            itemList = itemDB.selectData(inputColumn1);
            for (int i = 0; i < itemList.size(); i++) {
              System.out.println(itemList.get(i));
            }
          }

          // ������
        } else if (inputSelect1 == 0) {
          // System.out.println(itemList);

          itemList = itemDB.selectData();
          // itemList = itemDB.selectData();

          for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
          }

        }
      }



    }
    if (selectNum == 2) {
      itemDB.insertData();
    }
    if (selectNum == 3) {
      itemDB.deleteData(null);

    }
    if (selectNum == 4) {
      System.out.println("�˻�� �Է��ϼ���.");
      String name = sc.next();
      System.out.println(itemDB.searchData(name));

    }
    // itemDB.selectAll();
    // itemDB.deleteData(null);
  }


}

