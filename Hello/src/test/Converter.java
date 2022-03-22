package test;

import java.util.Scanner;


public class Converter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int won, mrate, usd, change;
		
		System.out.print("원화를 입력하세요 : ");
		won = sc.nextInt();
		
		System.out.print("환율을 입력하세요 : ");
		mrate = sc.nextInt();
		
		usd = won / mrate; // 정수 나눗셈. 고정형 연산
		change = won % mrate;
		
		System.out.println("달러 : " + usd + "USD");
		System.out.println("잔액 : " + change + "WON");
		
		

	}

}
