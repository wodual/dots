package aa;

public class ProductVO {
	// 캡슐화 처리 

	    // [멤버변수]
		private int pnum; // PK
		private String pName; // 상품명
		private int price; // 가격
		private int cnt; // 재고
		
	    // [getter, setter]
		public int getPnum() {
			return pnum;
		}
		public void setPnum(int pnum) {
			this.pnum = pnum;
		}
		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getCnt() {
			return cnt;
		}
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
	    // toString 오버라이딩
		@Override
		public String toString() {
			return "ProductVO [pnum=" + pnum + ", pName=" + pName + ", price=" + price + ", cnt=" + cnt + "]";
		}
		public ProductVO(int pnum, String pName, int price, int cnt) {
			super();
			this.pnum = pnum;
			this.pName = pName;
			this.price = price;
			this.cnt = cnt;
		}	
		
	}


