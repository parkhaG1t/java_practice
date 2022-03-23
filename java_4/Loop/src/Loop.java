import java.util.Scanner;
import java.util.Random;

public class Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		
		System.out.print("타일 수: ");
		int tiles = in.nextInt(); 	// 바닥에 깔린 타일 수
		
		int jump = 0;				// 이동한 타일 수
		int count = 0;				// 시도한 횟수
		boolean isBroken = false;	// 플래그(깃발) 변수
		// 타일 번호가 8 배수 자리는 아웃
		while(jump <= tiles) {
			// 주사위 던지고 이동하기
			jump += r.nextInt(6) + 1;
			if(jump % 8 ==0) {
				isBroken = true;
				break;
			}
			count++;
		}
		
		if(!isBroken)System.out.println("점프한 횟수 : " + count + "번");
		else System.out.println("아웃되었습니다. " + count + "번");
	}

}
