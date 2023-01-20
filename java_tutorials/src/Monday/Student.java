package Monday;

public class Student {
	private String studentID;
	private String name;
	
	public Student() {}
	
	public Student(String studentID, String name) {
		this.studentID=studentID;
		this.name=name;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
	
	public void showStudentInfo() {
		System.out.println(studentID + "," + name);
	}
}
