import java.io.*;
import java.util.*;

public class RecycledNumbers {
	public static void main(String... args) throws Exception {

		BufferedReader br = new BufferedReader(
		new FileReader(System.getProperty("user.home") + "/Desktop/csmall.in")
		//new InputStreamReader(System.in)
		);

		int times = Integer.parseInt(br.readLine());

		for (int i = 0; i < times; i++) {
			numbers(br.readLine(), i+1);
		}

	}

	public static void numbers(String data, int num) {
		int a = Integer.parseInt(data.split(" ")[0]);
		int b = Integer.parseInt(data.split(" ")[1]);
		int count = 0;
		
		for (int n = a; n < b; n++) {
			String nn = n+"";
			for (int m = n+1; m <= b; m++) {
				String mm = m+"";
				if (nn.length() != mm.length()) {continue;}
				
				boolean check = false;
				for (int i = mm.length() - 1; i >= 0; i--) {
					String news = mm.substring(i);
					String newst = news + mm.substring(0, i);
					check = check(nn, newst);
					if (check) {
						count++;
						break;
					}
				}
				
			}
		}
		
		System.out.println("Case #" + num + ": " + count);
	}
	
	public static boolean check(String a, String b) {
		a = Integer.parseInt(a) + "";
		b = Integer.parseInt(b) + "";
		
		if (a.equals(b) || a.length() != b.length()) {
			return false;
		}
		
		String end = "";
		
		for (int i = b.length(); i >= 0; i--) {
			String first = b.substring(i);
			end = first + b.substring(0, i);
			
			if (a.equals(end)) {
				return true;
			}
		}
		
		return false;
	}
}
