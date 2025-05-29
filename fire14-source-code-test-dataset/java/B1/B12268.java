import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RecycledNumbers {

	public static void main(String[] args) throws Exception{
		char problem = 'C';
		boolean smallCase = true;
		boolean practice = false;
		BufferedReader br = new BufferedReader(new FileReader(problem + "-" + (smallCase ? "small" : "large") + (practice ? "-practice" : "") + ".in"));
		PrintWriter out = new PrintWriter(new FileWriter(problem + "-" + (smallCase ? "small" : "large") + (practice ? "-practice" : "") + ".out"));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			out.println("Case #" + i + ": " + solve(br.readLine()));
		}
		out.close();
		System.exit(0);
	}

	public static int solve(String in) {
		StringTokenizer st = new StringTokenizer(in);
		String min = st.nextToken();
		String max = st.nextToken();
		int length = min.length();
		int output = 0;
//		for(int shortL = 1; shortL <= length / 2; shortL++) {
//			int longL = length - shortL;
//			int numShort = Integer.parseInt(max.substring(0, shortL)) - Integer.parseInt(min.substring(0, shortL)) + 1;
//			int numLong = Integer.parseInt(max.substring(0, longL)) - Integer.parseInt(min.substring(0, longL)) + 1;
//			int num;
//			if(numShort > 2) {
//				output += (numShort - 2) * (numLong - 2);
//			}
//			if(numShort >= 2) {
//				num = (Integer.parseInt(max.substring(0, longL)) - 1) - Integer.parseInt(min.substring(shortL)) + 1;
//				if(num > 0) output += num;
//				num = Integer.parseInt(max.substring(shortL)) - (Integer.parseInt(min.substring(0, longL)) + 1) + 1;
//				if(num > 0) output += num;
//			}
//			if(numLong >= 2) {
//				num = (Integer.parseInt(max.substring(0, shortL)) - 1) - Integer.parseInt(min.substring(longL)) + 1;
//				if(num > 0) output += num;
//				num = Integer.parseInt(max.substring(longL)) - (Integer.parseInt(min.substring(0, shortL)) + 1) + 1;
//				if(num > 0) output += num;
//			}
//			if(numShort == 1) {
//				num = (Integer.parseInt(max.substring(0, longL)) - 1) - Integer.parseInt(min.substring(shortL)) + 1;
//				if(num > 0) output += num;
//			}
//		}
		
		
		int ma = Integer.parseInt(max);
		int mi = Integer.parseInt(min);
		if(length == 2) {
			for(int i = 1; i < 10; i++) {
				for(int j = i + 1; j < 10; j++) {
					if(10 * i + j >= mi && 10 * j + i <= ma) output ++;
				}
			}
		} else if(length == 3) {
			for(int i = 1; i < 10; i++) {
				for(int j = 10; j < 100; j++) {
					if(j != 11 * i && 100 * i + j <= ma && 100 * i + j >= mi && 10 * j + i <= ma && 10 * j + i >= mi) output ++;
				}
			}
		}
		return output;
	}

}
