import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class DancingWithGooglers {
	static class Googler implements Comparable<Googler>{
		int averageScore;
		int remainder;
		
		Googler(int averageScore, int remainder) {
			this.averageScore = averageScore;
			this.remainder = remainder;
		}

		@Override
		public int compareTo(Googler o) {
			return this.averageScore - o.averageScore;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCases; t++) {
			String[] nspt = br.readLine().split(" ");
			int n = Integer.parseInt(nspt[0]);
			int s = Integer.parseInt(nspt[1]);
			int p = Integer.parseInt(nspt[2]);
			int[] totalPoints = new int[n];
			for (int i = 0, j = 3; i < n; i++, j++) {
				totalPoints[i] = Integer.parseInt(nspt[j]);
			}
			
			Googler[] googlers = new Googler[n];
			for (int i = 0; i < n; i++) {
				googlers[i] = new Googler(totalPoints[i] / 3, totalPoints[i] % 3);
			}
			Arrays.sort(googlers);
			
//			System.out.println("minimum = " + p + ", surprising = " + s);
//			for (int i = 0; i < n; i++) {
//				System.out.println("(" + googlers[i].averageScore + " " + googlers[i].averageScore + " " + googlers[i].averageScore + ") " + googlers[i].remainder);
//			}
			
			int count = 0;
			int i = n - 1;
			for (;i >= 0; i--) {
				if (googlers[i].averageScore >= p) {
					count++;
				} else {
					break;
				}
			}
			
			//average + 1 == p
			for (;i >= 0; i--) {
				if (googlers[i].averageScore + 1 == p) {
					if (googlers[i].remainder == 0 && googlers[i].averageScore != 0 && s > 0) {
						count++;
						s--;
					} else if (googlers[i].remainder >= 1) {
						count++;
					}
				} else {
					break;
				}
			}
			
			//average + 2 == p
			for (;i >= 0;i--) {
				if (googlers[i].averageScore + 2 == p) {
					if (googlers[i].remainder == 2 && s > 0) {
						count++;
						s--;
					}					
				} else {
					break;
				}
			}
			
			System.out.println("Case #" + t + ": " + count);
		}
	}
}
