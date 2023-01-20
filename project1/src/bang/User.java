package bang;

public class User {
	private String id;
    private String password;
    private String nickname;
    private int point;

    User() {} //기본 생성자
    User(String name,String phonnumber,String nickname,int point) {
        this.id = name;
        this.password = phonnumber;
        this.nickname = nickname;
        this.point = point;
    }
    //각 필드의 Getter, Setter
    void setId(String name) { this.id = name; }
    void setPassword(String phonnumber) { this.password = phonnumber; }
    void setNickname(String nickname) { this.nickname = nickname; }
    void setpoint(int point) { this.point = point; }
    String getId() { return id;}
    String getPassword() { return password;}
    String getNickname() { return nickname;}
    int getPoint() { return point;}
}
   //로그인페이지를 사용하기 위한 클래스 
   


