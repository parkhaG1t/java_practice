import java.util.Scanner;
import java.util.Random;

public class Loop2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Random r = new Random();
	
		// 창고에 보관된 물품들의 수량을 입력받고 총 합계를 구하자.
		// 종료 조건은 -99 입력.
		
		int sum = 0;
		int num;
		// num = in.nextInt();		// 반복제어변수 초기화
		/*
		while((num = in.nextInt()) != -99) {
			sum += num;			// 수량 누적
			// num = in.nextInt();
		}
		*/
		while(true) {
			if((num = in.nextInt()) == 0- 99) break;
			sum += num;
		}
		
		System.out.println("총 수량 = " + sum);
	}
}