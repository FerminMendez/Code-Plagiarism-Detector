import java.util.*;
import java.io.*;

public class Googlers {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Googlers.out")));
		StringTokenizer st;
		
		st = new StringTokenizer(f.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int N, S, p;
		int i, j;
		int tempTotal;
		int[] result = new int[T];
		for(i = 0; i< T; i++) {
			st = new StringTokenizer(f.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			for(j = 0; j < N; j++) {
				tempTotal = Integer.parseInt(st.nextToken());
				if(tempTotal >= (3 * p - 2))
					result[i]++;
				else if(tempTotal >= p + 2*Math.max(p - 2, 0)) {
					if(S > 0) {
						result[i]++;
						S--;
					}
				}
			}
		}
		
		for(i = 0; i < T; i++) {
			out.println("Case #" + (i + 1) + ": " + result[i]);
		}
		
		out.close();
	}
}
