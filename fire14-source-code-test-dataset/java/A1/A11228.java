import java.util.*;
import java.io.*;

public class B{
	
	public static void main(String[] args) throws IOException{
		Scanner inp = new Scanner(new File("B-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("b.out"));
		
		int numCases = inp.nextInt();
		
		for (int cas = 0; cas < numCases; cas++){
			pw.print("Case #" + (cas+1) + ": ");
			
			/* case input */
			int N = inp.nextInt();
			int S = inp.nextInt();
			int p = inp.nextInt();
			int[] t = new int[N];
			for (int i = 0; i < N; i++){
				t[i] = inp.nextInt();
			}
			/* end case input */
			
			/* main logic */
			int ans = 0;
			
			int bNoS = 3*p - 2;
			if (bNoS < 0){
				bNoS = 0;
			}
			
			int bS = 3*p - 4;
			if (bS < 2){
				bS = 2;
			}
			
			for (int i = 0; i < N; i++){
				int ti = t[i];
				if (ti >= bNoS){
					ans++;
					continue;
				}
				else if (ti >= bS){
					if (S > 0){
						S--;
						ans++;
						continue;
					}
					else{
						continue;
					}
				}
				else{
					continue;
				}
			}
			
			pw.println(ans);
		}
		pw.close();
	}
}
