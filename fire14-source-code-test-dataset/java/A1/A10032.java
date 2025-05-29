import java.io.*;
import java.util.*;
public class GoogleDancing {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader("B-small-attempt3.in.txt"));
		int T = Integer.parseInt(read.readLine());
		for(int i = 1; i <= T; i++){
			StringTokenizer st = new StringTokenizer(read.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			if(P == 0) {
				System.out.println("Case #" + i + ": " + N);
				continue;
			}
			int total = 0;
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0)
					continue;
				int q = temp/3 + ((temp%3 == 0)? 0:1);
				if(P <= q)
					total++;
				else if(temp%3 != 1) {
					if(P <= q+1 && S > 0) {
						total++;
						S--;
					}
				}
			}
			System.out.println("Case #" + i + ": " + total);
		}

	}
}
