import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner sc = null;
		if (args != null && args.length > 0) {
			
			try {
				sc = new Scanner(new File(args[0]));
					
				if (args.length > 1) {
					System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(args[1])), 128)));
				}
			} catch (FileNotFoundException e) {
				
				// e.printStackTrace();
				sc = new Scanner(System.in);
			}
			
		} else {
			
			sc = new Scanner(System.in);
		}
		
		int T = Integer.valueOf(sc.nextLine());
		
		for (int i = 0; i < T; i++) {
			
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int[] t = new int[N];
			for (int j = 0; j < N; j++) {
				t[j] = sc.nextInt();				
			}
			int answer = solve(S, p, t);
			System.out.printf("Case #%d: %d\n", i + 1, answer);
			
		}
		System.out.close();
	}
	
	public static int solve(int S, int p, int[] t) {
		
		int suprisingSuccess = 0;
		int answer = 0;
		for (int i = 0; i < t.length; i++) {
			
			if (t[i] >= 3 * p - 2) {				
				answer++;
				
			} else if (p < 3 && t[i] >= p) {				
				suprisingSuccess++;
				
			} else if ( p >= 3 && t[i] >= 3 * p - 4 ) {				
				suprisingSuccess++;
				
			}
			
		}	
		answer += (S >= suprisingSuccess) ? suprisingSuccess : S;
		return answer;
	}

}
