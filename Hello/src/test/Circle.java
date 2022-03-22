package test;

import java.util.Scanner; // Scanner 클래스가 입력 기능 제공

public class Circle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rad;
		double size;
		final double PHI = 3.1415;

		System.out.print("반지름 : ");
		rad = sc.nextInt(); // 정수 입력
		size = rad * PHI;
		System.out.println("면적 = " + size);
		System.out.printf("면적 = %.1f\n", size);
		
		sc.close();

	}
}