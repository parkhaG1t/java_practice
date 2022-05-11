import java.util.ArrayList;
import java.util.Random;

public class Assignment1 {

	public static void main(String[] args) {
		Random r= new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num;
		int i, j, k, m;
		
		list.add(r.nextInt(10, 51));	// 첫 번째 값 넣기
		
		for(i=1; i<10; i++) {			// 나머지 값 넣기
			num = r.nextInt(10, 51);
			
			while(true) {				// 중복되는 값 제거
				if(list.contains(num)) {
					num = r.nextInt(10, 51);
				} else {
					break;
				}
			}
			System.out.println("------------------" + num);
			
			
			if(i == 1) {				// 두 번째 값 넣기
				if(num < list.get(0)) {
					list.add(0, num);
				} else {
					list.add(1, num);
				}
			} else {					// 비교해서 값 넣기
				for(j=0; j<i; j++) {
					if(num < list.get(j)) {
						list.add(j, num);
						break;
					}
				}
			}
			
			

			
			System.out.println("현재 값");
			for (Integer ㅣ : list) {			// 값 출력
				System.out.println(ㅣ);
			
			}
		}
		System.out.println("전체 값 출력");
		for (Integer ㅣ : list) {			// 값 출력
			System.out.println(ㅣ);
		}
	}
}

