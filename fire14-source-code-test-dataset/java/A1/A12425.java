import java.io.*;

public class DancingGooglers {
	private static final String IN_FILE = "B-small.in";
	private static final String OUT_FILE = "B-small_output.txt";
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(IN_FILE));
			BufferedWriter bw = new BufferedWriter(new FileWriter(OUT_FILE));
			String line = br.readLine();
			final int T_CASES = Integer.parseInt(line);
			
			for (int t = 1; t <= T_CASES; t++) {
				line = br.readLine();
				String parts[] = line.split(" ");
				final int N = Integer.parseInt(parts[0]);	// number of Googlers
				final int S = Integer.parseInt(parts[1]);	// number of surprising triplets of scores
				final int P = Integer.parseInt(parts[2]);	// best result of at least p
				
				int[] totalPoints = new int[N];
				for (int i = 0; i < N; i++) {
					totalPoints[i] = Integer.parseInt(parts[i + 3]);
				}
				
				int result = processCase(N, S, P, totalPoints);
				bw.write("Case #" + t + ": " + result);
				bw.newLine();
			}
			
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int processCase(int n, int s, int p, int[] totalPoints) {
		int result = 0;
		
		for (int t : totalPoints) {
			switch (p) {
			case 0:
				result++;
				break;
			case 1:
				if (t >= 1) {
					result++;
				}
				break;
			default:
				// p is between 2 to 10
				if (t >= 3 * p - 2) {
					result++;
				} else if (s > 0 && t >= 3 * p - 4) {
					s--;
					result++;
				}
				break;
			}
		}
		
		return result;
	}
	
}
