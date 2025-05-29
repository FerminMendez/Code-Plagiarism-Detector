import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pb2 {
	public static void main(String[] args) {
		try {
			PrintWriter writer = new PrintWriter("B-small-attempt0.out");
			BufferedReader reader = new BufferedReader(new FileReader("B-small-attempt0.in"));
			int lines = Integer.parseInt(reader.readLine());
			for(int i = 1; i <= lines; i++) {
				String line = reader.readLine();
				writer.println(processLine(i, line));
				writer.flush();
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static StringBuffer processLine(int k, String str) {
		StringBuffer out = new StringBuffer("Case #" + k + ": ");
		Scanner scanner = new Scanner(str);
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		int p = scanner.nextInt();
		int cat0 = 0;
		int cat1 = 0;
		int cat2 = 0;
		int cat3 = 0;
		int cat4 = 0;
		int cat29 = 0;
		for(int i = 0; i < n; i++){
			int tmp = scanner.nextInt();
			if(tmp == 0) {
				cat0++;
			} else if(tmp == 1) {
				cat1++;
			} else if(tmp >=29) {
				cat29++;
			} else if(2 <= tmp && tmp < (3*p-4) && p!= 2) {
				cat2++;
			} else if(tmp == (3*p-4) || tmp == (3*p-3)) {
				cat3++;
			} else {
				cat4++;
			}
		}
		int t = cat29 + cat4 + cat3;
		if(p == 0) {
			t = n;
		} else if(p == 1) {
			t = n - cat0;
		} else if(s < cat3) {
			t -= cat3 - s; 
		}
		
		return out.append(t);
	}

}
