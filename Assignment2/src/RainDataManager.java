import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class RainDataManager {

	private String[][] cities = {{"108", "서울"}, {"159", "부산"}, {"133", "대전"}, 
			 {"184", "제주"}, {"112", "인천"}, {"119", "수원"}, {"156", "광주"}, {"143", "대구"}};
	private ArrayList<RainData> data;
	
	public RainDataManager() {
		data = new ArrayList<RainData>();
	}
	
	public void getRainData(RainData rdata) {	// csv 파일에서 받은 데이터 넣기
		data.add(rdata);
		for(int i=0; i<data.size(); i++) {		// citycode로 city 찾기
			for(int j=0; j<8; j++) {
				if(data.get(i).getCitycode().equals(cities[j][0])) {
					data.get(i).setCity(cities[j][1]);
				}
			}
		}
	}
	
	public void showAllData() {
		System.out.println("전체 데이터 : ");
		for(int i = 0; i<data.size(); i++) {
			data.get(i).showData();
		}
	}

	public void monthlyRainData(String cityname, String start, String end) throws ParseException {
		int count = 0;				// 검색된 데이터 카운트
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date1 = null, date2 = null, date3 = null;
		
		try {
		date1 = sdf.parse(start);
		date2 = sdf.parse(end);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i<data.size(); i++) {
			if(data.get(i).getCity().equals(cityname)) {
				try {
					date3 = sdf.parse(data.get(i).getYearMonth());
				} catch(Exception e) {
					e.printStackTrace();
				}
				if((date1.before(date3) && date2.after(date3)) || date1.equals(date3) || date2.equals(date3)) {
					data.get(i).showData();
					++count;
				}
			}
		}
		if(count == 0) {
			System.out.println("검색된 데이터가 없습니다.\n");
			System.out.println("***************************");
		}
	}

	public void maxRainData(String cityname, String year)	throws ParseException {
		float com = 0;			// 비교할 숫자 저장 변수
		int idx = -1;			// 최댓값 인덱스 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date1 = null;
		Date date2 = null;
		
		for(int i = 0; i<data.size(); i++){
			if(data.get(i).getCity().equals(cityname)) {
				try {
					date1 = sdf.parse(year);
					date2 = sdf.parse(data.get(i).getYearMonth());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(date1.equals(date2)) {
					if(com == 0) {				// 비교할 값이 저장되지 않은 경우
						com = Float.parseFloat(data.get(i).getRain());
						idx = i;
					} else {
						if(Float.parseFloat(data.get(i).getRain()) > com) {
							com = Float.parseFloat(data.get(i).getRain());
							idx = i;
						}
					}
				}
			}
		}
		if(idx != -1) {
			data.get(idx).showData();		// 최댓값 출력
		} else {
			System.out.println("검색된 데이터가 없습니다.\n");
			System.out.println("***************************");
		}
	}

	public void addRainData(String cityname, String yearmonth, String rain) {
		Scanner r = new Scanner(System.in);
		String citycode = "000";			// 알맞은 도시 정보를 입력했는지 확인
		int setdata = 0;					// 데이터가 등록되어있는지 판별
		
		for(int i = 0; i<8; i++) {			// city로 citycode 찾기
			if(cityname.equals(cities[i][1])) {
				citycode = cities[i][0];
			}
		}
		
		if(citycode.equals("000")) {
			System.out.println("알맞은 도시의 정보가 아닙니다.");
			System.out.println("***************************");
		} else {
			for(int i = 0; i<data.size(); i++) {	// 등록된 데이터가 있는지 확인
				if((cityname.equals(data.get(i).getCity()) && yearmonth.equals(data.get(i).getYearMonth()))) {
					setdata = 1;
					System.out.println("이미 등록된 데이터가 있습니다. 변경하시겠습니까? YES or NO");
					String answer = r.next();
					if(answer.equals("YES")) {
						System.out.println("변경 전 정보 : ");
						data.get(i).showData();
						
						data.get(i).setRain(rain);
						
						System.out.println("변경 후 정보 : ");
						data.get(i).showData();
						
					} else if (answer.equals("NO")) {
						break;
					} else {
						System.out.println("잘못입력하셨습니다.");
						System.out.println("***************************");
					}
				}
			}
			
			if(setdata == 0) {						// 등록된 데이터가 없는 경우 추가
				RainData ndata = new RainData(yearmonth, citycode, rain);
				data.add(ndata);
				data.get(data.size() -1).setCity(cityname);
			}
		} 
	}

	public void delRainData(String cityname, String yearmonth) {
		int del = 0;		// 데이터가 삭제되었는지 확인
		for(int i = 0; i<data.size(); i++) {
			if(data.get(i).getCity().equals(cityname) && data.get(i).getYearMonth().equals(yearmonth)) {
				System.out.println("삭제된 데이터 : ");
				data.get(i).showData();
				data.remove(i);
				del = 1;
			}
		}
		if(del == 0) {
			System.out.println("삭제할 데이터가 없습니다 . . .");
		}
	}
		
		
}
	


	

