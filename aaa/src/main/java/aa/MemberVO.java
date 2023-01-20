package aa;

public class MemberVO {
	// 캡슐화 처리 

	    // [멤버변수]
		private int mnum; // PK
		private String userID; // ID
		private String userPW; // PW
		private String userName; // NAME
		
	    // [getter, setter]
		public int getMnum() {
			return mnum;
		}
		public void setMnum(int mnum) {
			this.mnum = mnum;
		}
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		public String getUserPW() {
			return userPW;
		}
		public void setUserPW(String userPW) {
			this.userPW = userPW;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
	    // toString 오버라이딩
		@Override
		public String toString() {
			return "MemberVO [mnum=" + mnum + ", userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + "]";
		}
		public MemberVO(int mnum, String userID, String userPW, String userName) {
			super();
			this.mnum = mnum;
			this.userID = userID;
			this.userPW = userPW;
			this.userName = userName;
		}
		
		
	}


