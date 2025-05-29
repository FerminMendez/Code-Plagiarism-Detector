import java.util.*;
import java.io.*;

public class QR_Csmall {
	public static void main(String[] args) throws Exception{
		// Scanner sc = new Scanner(System.in);
		// PrintWriter pw = new PrintWriter(System.out);
		// Scanner sc = new Scanner(new FileReader("input.in"));
		// PrintWriter pw = new PrintWriter(new FileWriter("output.out"));
		Scanner sc = new Scanner(new FileReader("C-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("C-small-attempt0.out"));
		
		
		int T;
		int A, B;
		int n, m;
		int ncnt;
		int cnt;
		int[] check = new int[3];
		boolean ok;
		
		T = sc.nextInt();
		
		
		for(int times = 1; times <= T; times++){
			A = sc.nextInt();
			B = sc.nextInt();
			cnt = 0;
			
			
			for(int i = A; i < B; i++){
				n = i;
				m = 0;
				ncnt = 0;
				for(int k = 0; k < check.length; k++){
					check[k] = -1;
				}
				
				while(n > 0){
					n /= 10;
					ncnt++;
				}
				
				for(int j = 1; j < ncnt; j++){
					ok = true;
					m = 0;
					m = (i / (int)Math.pow(10, j)) + ((i % (int)Math.pow(10, j)) * (int)Math.pow(10, ncnt-j));
					if(i < m && m <= B){
						check[j - 1] = m;
						for(int l = 0; l < j - 1; l++){
							if(check[l] == m){
								ok = false;
								break;
							}
						}
						if(ok) cnt++;
						
					}
					
				}
				
			}
			
			
			System.out.print("Case #" + times + ": ");
			System.out.print(cnt);
			System.out.println();
			
			
			pw.print("Case #" + times + ": ");
			pw.print(cnt);
			pw.println();
			
		}
		
		sc.close();
		pw.close();
		
	}
}

