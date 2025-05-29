import java.io.*;
import java.util.*;
import java.math.*;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("B-small-attempt1.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		PrintWriter out = new PrintWriter("B-small-attempt1.out");
		int cases = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int c = 1; c <= cases; c++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int res = 0;
			for (int i = 0; i < N; i++) {
				int curr = Integer.parseInt(st.nextToken());
				int currBest = curr/3+Math.min(curr%3, 1);
				int curSurBest = curr/3+Math.max(1, curr%3);
				if(curr == 0)
					res += p>0?0:1;
				else if(currBest >= p)
					res++;
				else if(s > 0 && curSurBest >= p) {
					res++;
					s--;
				}
			}
			out.println("Case #" + c + ": " + res);
		}
		out.close();
	}
}