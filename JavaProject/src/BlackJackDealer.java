import java.util.ArrayList;

public class BlackJackDealer implements DealerInterface {
	ArrayList<String> hand = new ArrayList<>();
	
	@Override
	public int start() {
		hand.add(cardlist[random.nextInt(51)]);
		while(true) {
			int num = 0;
			int countA = 0;
			hand.add(cardlist[random.nextInt(51)]);
			for(int i = 0; i < hand.size(); i++) {
				if(hand.get(i).substring(2).equals("J") || hand.get(i).substring(2).equals("Q") || hand.get(i).substring(2).equals("K")) {
					num += 10;
				} else if (hand.get(i).substring(2).equals("A")) {
					countA++;
				} else {
					num += Integer.parseInt(hand.get(i).substring(2));
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
				return 0;
			} else if (num == 21) {
				return num;
			} else {
				if(num > 16) {
					return num;
				}
			}
		}
	}

}
