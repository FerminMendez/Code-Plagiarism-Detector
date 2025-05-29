import java.util.*;
import java.io.*;
public class B {
	public static void main(String[]args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int x=1;x<T+1;x++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int[] scores = new int[n];
			for(int i=0;i<n;i++)
				scores[i]=Integer.parseInt(st.nextToken());
			int cases = 0;
			for(int score : scores) {
				int base = score/3;
				switch(score%3) {
					case 0:
						if(base>=p) {
							cases++;
						}
						else 
							if (s > 0 && base > 0 && base + 1 >= p) {
								cases++;
								s--;
							}
						break;
					case 1:
						if(base+1>=p) {
							cases++;
						}
						else 
							if (s > 0 && base + 1 >= p) {
								cases++;
								s--;
							}
						break;
					case 2:
						if(base+1>=p) {
							cases++;
						}
						else 
							if (s > 0 && base + 2 >= p) {
								cases++;
								s--;
							}
						break;
				}
			}
			System.out.println("Case #"+x+": "+cases);
		}
	}
}