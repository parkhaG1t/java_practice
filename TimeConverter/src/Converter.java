import java.util.Scanner;


public class Converter {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int hour, min, sec;
		
		System.out.print("초를 입력해주세요 : ");
		sec = sc.nextInt();
		
		hour = sec / 3600;
		sec -= hour * 3600;
		
		min = sec / 60;
		sec -= min * 60;
		
		System.out.println(hour + "시간 "
		+ min +"분 " + sec + "초 입니다. ");

	}

}