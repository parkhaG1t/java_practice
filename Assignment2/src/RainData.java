
public class RainData {
	private String city;
	private String citycode;
	private String yearmonth;
	private String rain;
	

	public RainData(String yearmonth, String citycode, String rain) {
		this.yearmonth = yearmonth;
		this.citycode = citycode;
		this.rain = rain;
	}
	
	
	public String getCitycode() {
		return this.citycode;
	}
	public String getCity() {
		return this.city;
	}
	public String getYearMonth() {
		return this.yearmonth;
	}
	public String getRain() {
		return this.rain;
	}
	
	
	public void setCity(String city) {
		this.city = city;
	}
	public void setRain(String newrain) {
		this.rain = newrain;
	}
	
	
	public void showData() {
		System.out.println("***************************");
		System.out.println("년-월 : " + yearmonth + "\n도시 : " + city + "\n도시코드 : " + citycode + "\n강수량 : " + rain);
		System.out.println("***************************");
	}

	@Override
	public String toString() {
		return "RainData [city=" + city + ", citycode=" + citycode + ", yearmonth=" + yearmonth + ", rain=" + rain
				+ "]";
	}


	
}
