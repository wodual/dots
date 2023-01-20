package usedItemProject;

public class Order {
	private String id;
	private String name;
	private int price;
	
	public Order() {}
	
	public Order(String id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	// get 메소드
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setId(String newId) {
		this.id = newId;
	}
	public void setName(String newName) {
		this.id = newName;
	}
	public void setPrice(String newPrice) {
		this.id = newPrice;
	}
	
	// toString() : 주문정보 객체 정보 출력
	public String toString() {
		return id + " " + name + " " + price;
	}
	
}

