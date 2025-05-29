import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Countscores {

	public static int processLine(String data) {
		int result = 0;
		String[] info = data.split(" ");
//		for (int i = 0; i < info.length; i++) {
//			System.out.print(info[i] + " ");
//		}
//		System.out.println();
		
		int N = Integer.parseInt(info[0]);
		if (info.length < 3 + N) {
			System.err.println("insufficient arguments!");
			return -1;
		}
		int surprises = Integer.parseInt(info[1]);
		int surprisecount = 0;
		int threshold = 3 * Integer.parseInt(info[2]);
		
		for (int i = 0; i < N; i++) {
			int totalscore = Integer.parseInt(info[3 + i]);
			if (totalscore >= threshold - 2) {
				result++;
			} else if (totalscore > Math.max(threshold - 5, 0) 
					&& surprisecount < surprises) {
				result++;
				surprisecount++;
			}
		}
		
		return result;
	}
	
	public static void countScores(String input) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			int cases = Integer.parseInt(br.readLine());
			int idx = 0;
			while (idx < cases) {
				idx++;
				System.out.println("Case #" + idx + ": " + processLine(br.readLine()));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String input = "C:/Users/hattori/Downloads/B-small-attempt0.in";
		countScores(input);
	}
	
}
