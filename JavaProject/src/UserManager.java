import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.StringTokenizer;

public class UserManager {
	
	private UserManager() {}
	
	private static UserManager um = null;
	private String path = System.getProperty("user.dir") + "\\" + "users.txt";
	private File users = new File(path);
	
	public static UserManager getInstance() {
		if(um == null) um = new UserManager();
		return um;
	}
	
	public boolean signUp(String id, String pwd) {		
		try {
			if(!users.exists()) {
				users.createNewFile();
			}
			
			FileWriter fw = new FileWriter(users, true);
			PrintWriter w = new PrintWriter(fw);
			FileReader reader = new FileReader(users);
			BufferedReader buf = new BufferedReader(reader);
			
			String line;
			while((line = buf.readLine()) != null) {
				String userinfo;
				StringTokenizer st = new StringTokenizer(line, "\n");
				userinfo = st.nextToken();
				String[] array = userinfo.split("-");
				if(array[0].equals(id)) {
					if(array[1].equals(pwd)) {
						w.close();
						buf.close();
						System.out.println("이미 가입된 사용자 입니다.");
						return true;
					} else {
						w.close();
						buf.close();
						System.out.println("이미 가입된 아이디 입니다.");
						return true;
					}
				}
			}
			
			w.write(id + "-" + pwd + "-1000" + "\n");	// 정보 입력
			
			w.close();		
			buf.close();								// 종료
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("회원가입 성공");
		return true;
	}
	
	public String[] signIn(String id, String pwd) throws IOException {
	try {
		FileReader reader = new FileReader(users);
		BufferedReader buf = new BufferedReader(reader);
		
		String line;
		while((line = buf.readLine()) != null) {
			String userinfo;
			StringTokenizer st = new StringTokenizer(line, "\n");
			userinfo = st.nextToken();
			String[] array = userinfo.split("-");
			if(array[0].equals(id)) {
				if(array[1].equals(pwd)) {
					buf.close();
					return array;
				} else {
					System.out.println("잘못된 비밀번호입니다");
					buf.close();
					return null;
				}
			}
		}
		System.out.println("가입되지 않은 사용자입니다");
		buf.close();
		return null;
	} catch (FileNotFoundException e) {
		System.out.println("파일이 존재하지 않습니다");
		return null;
	}
}

	public void saveUserInfo(String user, int money) throws IOException {
		String updatetext = null;
		String updatepath = System.getProperty("user.dir") + "\\" + "update.txt";
		File update = new File(updatepath);
		FileWriter uw = new FileWriter(update, true);
		PrintWriter w = new PrintWriter(uw);
		try {
				FileReader reader = new FileReader(path);
				BufferedReader buf = new BufferedReader(reader);
				
				
				String line;
				while((line = buf.readLine()) != null) {
					String userinfo;
					StringTokenizer st = new StringTokenizer(line, "\n");
					userinfo = st.nextToken();
					String[] array = userinfo.split("-");
					if(array[0].equals(user)) {
						updatetext = userinfo;
					} else {
						w.write(userinfo + "\n");
					}
				}
				
				buf.close();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int first = updatetext.indexOf("-");
		int secound = updatetext.indexOf("-", first+1);
		
		
		String text = updatetext.substring(0, secound+1);
		text += Integer.toString(money) + "\n";
		
		w.write(text);
		w.close();
		
		Files.copy(update.toPath(), users.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		update.delete();

		} 
	
	public void delUser(String user) throws IOException {
		String updatepath = System.getProperty("user.dir") + "\\" + "update.txt";
		File update = new File(updatepath);

		try {
				FileReader reader = new FileReader(path);
				BufferedReader buf = new BufferedReader(reader);
				FileWriter uw = new FileWriter(update, true);
				PrintWriter w = new PrintWriter(uw);
				
				
				String line;
				while((line = buf.readLine()) != null) {
					String userinfo;
					StringTokenizer st = new StringTokenizer(line, "\n");
					userinfo = st.nextToken();
					String[] array = userinfo.split("-");
					if(array[0].equals(user)) {
						
					} else {
						w.write(userinfo + "\n");
					}
				}
				w.close();
				buf.close();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Files.copy(update.toPath(), users.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		update.delete();

		} 
		
	}


