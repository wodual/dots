package Monday;

public class StudentArray {

	public static void main(String[] args) {
		Student[] list = new Student[3];
		
		list[0] = new Student("1001","김");
		list[1] = new Student("1002", "모");
		list[2] = new Student("1003", "두");
		
		for(int i = 0; i<list.length; i++) {
			list[i].showStudentInfo();
		}

	}

}
