import java.io.IOException;

public class User {
	private User() {}
	private UserManager um = UserManager.getInstance();
	private static User u = null;
	private String user;
	private int money;
	private int bat;
	
	public static User getInstance() {
		if(u == null) {
			u = new User();
		}
		return u;
	}
	
	public void logIn(String[] userinfo) {
		System.out.println("로그인된 사용자 : " + userinfo[0]);
		this.user = userinfo[0];
		System.out.println("남은 돈 : " + userinfo[2]);
		this.money = Integer.parseInt(userinfo[2]);
	}
	
	
	public void showUserInfo() {
		System.out.println("사용자 : " + user);
		System.out.println("남은 돈 : " + money);
		System.out.println("---------------------------------------------");
	}
	
	public void batting(int bat) {
		if(bat > money) {
			System.out.println("가진 돈보다 많이 배팅하셨습니다.");
		}
		System.out.println("배팅된 금액 : " + bat);
		System.out.println("-----------------------------------------------");
		this.money -= bat;
		this.bat = bat;
	}
	
	public int showBatting() {
		System.out.println("배팅금 : " + this.bat);
		return this.bat;
	}
	
	public void win() throws IOException {
		System.out.println("획득한 금액 : " + bat*2);
		money += bat*2;
		um.saveUserInfo(user, money);
		this.bat = 0;
	}

	public void lose() throws IOException {
		System.out.println("읽은 금액 : " + bat);
		money -= bat;
		um.saveUserInfo(user, money);
		if(money <= 0) {
			System.out.println("파산하셨습니다...\n" + "계정을 삭제합니다.");
			um.delUser(user);
		}
		this.bat = 0;
	}

	public void draw() {
		this.bat = 0;
	}
}



