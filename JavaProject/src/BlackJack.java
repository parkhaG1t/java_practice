import java.io.IOException;
import java.util.ArrayList;

public class BlackJack implements GameInterface {

	int bat = 0;;
	ArrayList<String> userhand = new ArrayList<>();
	
	
	@Override
	public void showrules() {
		System.out.println("1. 랜덤으로 카드 2 장을 얻습니다.\n"
				+ "2. 카드의 숫자가 J, Q, K 이면 10으로 A이면 1이나 11로 숫자를 셉니다\n"
				+ "3. 숫자의 합이 21인 경우 블랙잭이고 이하라면 계속해서 더 카드를 받을 수 있습니다.\n"
				+ "4. 만약 카드의 합이 21보다 커지면 Burst로 패배합니다\n"
				+ "5. 카드를 뽑지 않고 멈추면 딜러의 카드가 공개되고 딜러의 카드보다 21에 가까우면 승리합니다.");
	}

	@Override
	public boolean startGame() throws IOException {
		userhand.add(cardlist[random.nextInt(51)]);
		System.out.println("--------------------게임 시작--------------------");
		System.out.println("배팅금을 입력하세요 : ");
		System.out.println("입력 : ");
		bat = sc.nextInt();
		u.batting(bat);
		
		int num;
		while(true) {
			num = 0;
			int countA = 0;
			userhand.add(cardlist[random.nextInt(51)]);
			for(int i = 0; i < userhand.size(); i++) {
				System.out.println("받은 패 : ");
				System.out.println(userhand.get(i));
				if(userhand.get(i).substring(2).equals("J") || userhand.get(i).substring(2).equals("Q") || userhand.get(i).substring(2).equals("K")) {
					num += 10;
				} else if (userhand.get(i).substring(2).equals("A")) {
					countA++;
				} else {
					num += Integer.parseInt(userhand.get(i).substring(2));
				}
			}
			
			if(countA > 0) {	// A 값 정하기
				if(num  + 11 + (countA-1)  <= 21) {
					num += 11 + (countA-1);
				} else {
					num += countA;
				}
			}
			
			if(num > 21) {
				System.out.println("숫자 : " + num);
				System.out.println("-----------------------------------------------");
				System.out.println("BUSRST !!!");
				u.lose();
				return false;
			} else if (num == 21) {
				System.out.println("숫자 : " + num);
				System.out.println("-----------------------------------------------");
				System.out.println("BlakcJack !!!");
				break;
			} else {
				System.out.println("숫자 : " + num);
				System.out.println("-----------------------------------------------");
				System.out.println("카드를 더 받으시겠습니까? Y/N");
				String select = sc.next();
				if(select.equals("Y")) {
					System.out.println("HIT");
				} else {
					System.out.println("STAY");
					break;
				}
			}
		}
		// 컴퓨터
		BlackJackDealer bjd = new BlackJackDealer();
		int com = bjd.start();
		
		if(num < com) {
			System.out.println("-----------------------------------------------");
			System.out.println("딜러 : " + com);
			System.out.println("졌습니다 ...");
			u.lose();
			return false;
		} else if(num == com) {
			System.out.println("-----------------------------------------------");
			System.out.println("딜러 : " + com);
			System.out.println("비겼습니다 ...");
			u.draw();
			return false;
		} else if(num > com) {
			System.out.println("-----------------------------------------------");
			System.out.println("딜러 : " + com);
			System.out.println("이겼습니다 !!!");
			u.win();
			return true;
		}
		return false;
	}


	
}
