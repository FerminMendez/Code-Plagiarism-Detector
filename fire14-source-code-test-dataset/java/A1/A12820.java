import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Googlers {
	
	static int judgeGooglersNum(String input) {
		int result = 0;
		String[] s = input.split(" ");
		int N = Integer.parseInt(s[0]);
		int S = Integer.parseInt(s[1]);
		int p = Integer.parseInt(s[2]);
		int total = p > 0 ? p + (p - 1) + (p - 1) : 0;
		int totalS = p > 1 ? p + (p - 2) + (p - 2) : total;
//		System.out.println(N + "," + S + "," + p + "," + 
//			total + "," + totalS);
		for(int i = 3; i < N + 3; i++) {
			int now = Integer.parseInt(s[i]); 
			if(now >= total || (now >= totalS && S-- > 0)) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/B-small-attempt0.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/B-small.out"));
        int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			bw.write("Case #" + (i+1) + ": " +
					judgeGooglersNum(br.readLine()));
			bw.newLine();
		}
        bw.flush();
        bw.close();
        br.close();
	}
}
