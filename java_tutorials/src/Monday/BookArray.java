package Monday;

public class BookArray {

	public static void main(String[] args) {
		Book[] library = new Book[5]; //Book 클래스형으로 객체배열생성
		
		for(int i = 0; i< library.length; i++) {
			System.out.println(library[i]);
		}
	}

}
