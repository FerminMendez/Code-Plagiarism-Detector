import java.util.*;
import java.io.*;

public class QR_Bsmall {
	public static void main(String[] args) throws Exception{
		// Scanner sc = new Scanner(System.in);
		// PrintWriter pw = new PrintWriter(System.out);
		// Scanner sc = new Scanner(new FileReader("input.in"));
		// PrintWriter pw = new PrintWriter(new FileWriter("output.out"));
		Scanner sc = new Scanner(new FileReader("B-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("B-small-attempt0.out"));
		
		
		int T;
		
		int N, S, p;
		int[] t = new int[100];
		int ans;
		
		T = sc.nextInt();
		
		for(int times = 1; times <= T; times++){
			N = sc.nextInt();
			S = sc.nextInt();
			p = sc.nextInt();
			
			for(int i = 0; i < N; i++){
				t[i] = sc.nextInt();
			}
			
			ans = 0;
			
			for(int i = 0; i < N; i++){
				if(t[i] <= 1){
					if(p <= t[i]){
						ans++;
					}
					continue;
				}
				t[i] = t[i] - (p * 3);
				if(t[i] > -3){
					ans++;
				}else if(t[i] > -5 && S > 0){
					ans++;
					S--;
				}
			}
			
			System.out.print("Case #" + times + ": ");
			System.out.print(ans);
			System.out.println();
			
			
			pw.print("Case #" + times + ": ");
			pw.print(ans);
			pw.println();
			
		}
		
		sc.close();
		pw.close();
		
	}
}

