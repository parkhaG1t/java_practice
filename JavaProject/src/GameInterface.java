import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public interface GameInterface {
	User u = User.getInstance();
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	
	
	String[] cardlist = {"♠ 2", "♠ 3", "♠ 4", "♠ 5", "♠ 6", "♠ 7", "♠ 8",
			"♠ 9", "♠ 10", "♠ K", "♠ Q", "♠ J", "♠ A",
			"♥ 2", "♥ 3", "♥ 4", "♥ 5", "♥ 6", "♥ 7", "♥ 8", "♥ 9", "♥ 10", "♥ K",
			"♥ Q", "♥ J", "♥ A",
			"♦ 2", "♦ 3", "♦ 4", "♦ 5", "♦ 6", "♦ 7", "♦ 8", "♦ 9", "♦ 10", "♦ K",
			"♦ Q", "♦ J", "♦ A",
			"♣ 2", "♣ 3", "♣ 4", "♣ 5", "♣ 6", "♣ 7", "♣ 8", "♣ 9", "♣ 10", "♣ K",
			"♣ Q", "♣ J", "♣ A"};
	
	
	void showrules();


	boolean startGame() throws IOException;
	
}
	

