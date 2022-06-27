import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean logged = false;
		User u = User.getInstance();
		UserManager um = UserManager.getInstance();
		Scanner sc = new Scanner(System.in);
		int select;
		
		while(!logged) {	// before login
			System.out.println("--------------------BlackJack--------------------");
			
			System.out.println("1. 로그인 \n" + "2. 회원가입");
			System.out.print("입력 : ");
			select = sc.nextInt();
			
			if(select == 1) {
				// 로그인
				while(true) {
					System.out.println("---------------------로그인---------------------");
					System.out.println("ID : ");
					String id = sc.next();
					System.out.println("PWD : ");
					String pwd = sc.next();
					if(um.signIn(id, pwd) != null) {
						u.logIn(um.signIn(id, pwd));
						logged = true;
						break;
					}
					break;
				}
			} else if(select == 2) {
				// 회원가입
				System.out.println("--------------------회원 가입--------------------");
				System.out.println("ID : ");
				String id = sc.next();
				System.out.println("PWD : ");
				String pwd = sc.next();
				um.signUp(id, pwd);
			} else {
				System.out.println("잘못된 값을 입력하셨습니다");
			}
		}
		
		select = 0;
		while(true) {	// after login

			System.out.println("--------------------StartGame--------------------");
	
			System.out.println("---------------------블랙잭---------------------");
			u.showUserInfo();
			BlackJack bj = new BlackJack();
			System.out.println("1. 게임 룰 확인");
			System.out.println("2. 게임 시작");
			select = sc.nextInt();
			
			switch(select) {
			case 1 -> {
				bj.showrules();
			}
			case 2 -> {
				bj.startGame();
				break;
			}
			}
		}
	}
	
	}
	
