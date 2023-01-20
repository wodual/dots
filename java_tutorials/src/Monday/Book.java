package Monday;

public class Book {
	private String bookName;
	private String author;
	
	public Book() {} //디폴트생성자
	
	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author; //책이름과 저자 이름을매개변수로 받는 생성자
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public void showBookInfo() {//책정보를 출력해주는 메소드
		System.out.println(bookName + "," + author);
	}
	
	}
