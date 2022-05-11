import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Scanner;


public class RainDataMain {
	private static RainDataManager rdm = new RainDataManager();
	private static Scanner r = new Scanner(System.in);
	
	private static void getData() {			// csv 파일 데이터 받아오기
		String file = "raindata.csv";
		try {
		   FileReader reader = new FileReader(file);
		   BufferedReader buf = new BufferedReader(reader);
		   String line;
		   while((line = buf.readLine()) != null) {
			   StringTokenizer tokenizer = new StringTokenizer(line, ",");
			   String yearmonth = tokenizer.nextToken();
			   String citycode = tokenizer.nextToken();
			   String rain = tokenizer.nextToken();
			   System.out.println(yearmonth + " : " + citycode + " : " + rain);
			   RainData rdata = new RainData(yearmonth, citycode, rain);
			   rdm.getRainData(rdata);
			   
		   } 
		   buf.close();
		} catch (FileNotFoundException e) {
		   System.out.println("File open error : "+file+"을 찾을 수 없습니다.");
		   e.printStackTrace();
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}
	
	private static int menu() {				// 메뉴
		System.out.println("[[[[ 도시별 월별 강수량 데이터 ]]]]");
		System.out.println(" 1. 도시별 월간 강수량 검색");
		System.out.println(" 2. 도시별 최대 강수량 검색");
		System.out.println(" 3. 강수량 데이터 등록");
		System.out.println(" 4. 강수량 데이터 삭제");
		System.out.println(" 0. 종료");
		return r.nextInt();
	}
	public static void main(String[] args) throws ParseException {
		rdm.showAllData();
		
		getData();							// 데이터 넣기
		
		while(true) {						// 메뉴 실행
			int menu = menu();
			if(menu != 0) {
				switch(menu) {
				case 1 -> {
					System.out.println("강수량 검색 : ");
					System.out.println("***************************");
					System.out.println("검색할 도시명 : ");
					String cityname = r.next();
					System.out.println("시작년월 : ");
					String start = r.next();
					System.out.println("종료년월 : ");
					String end = r.next();
					
					rdm.monthlyRainData(cityname, start, end);
				}
				case 2 -> {
					System.out.println("최대 강수량 검색 : ");
					System.out.println("***************************");
					System.out.println("검색할 도시명 : ");
					String cityname = r.next();
					System.out.println("년도 : ");
					String yearmonth = r.next();
					
					rdm.maxRainData(cityname, yearmonth);
				}
				case 3 -> {
					System.out.println("강수량 데이터 등록 : ");
					System.out.println("***************************");
					System.out.println("도시명 : ");
					String cityname = r.next();
					System.out.println("년-월 : ");
					String yearmonth = r.next();
					System.out.println("강수량 : ");
					String rain = r.next();
					
					rdm.addRainData(cityname, yearmonth, rain);
				}
				
				case 4 -> {
					System.out.println("데이터 삭제 : ");
					System.out.println("***************************");
					System.out.println("도시명 : ");
					String cityname = r.next();
					System.out.println("년-월 : ");
					String yearmonth = r.next();
					
					rdm.delRainData(cityname, yearmonth); 
				}
				
				}
				
			} else {
				System.out.println("종료되었습니다 . . .");
				break;
			}
		}

		/*
		RainDataManager manager = new RainDataManager();
		if(manager.loadData() == -1) return;
		manager.showAllData();
		while() {
		// 도시별 월간 강수량 검색 : 도시명, 시작년월, 종료년월 입력받고 강수량 검색 출력
		// 도시별 최대 강수량 검색 : 도시명, 년도 입력받고 최대 강수량의 년월과 강수량 검색 출력
		// 강수량 데이터 등록 : 도시명, 년월, 강수량 입력받고 추가한다. 이때 이미 등록된 데이터가 있으면 변경할지 물어보고 예를 선택한 경우 데이터를 교체한다.
		// 강수량 데이터 삭제 : 도시명, 년월 입력받고 해당 데이터를 삭제한다.
		 }
		}
		*/
	}


}


