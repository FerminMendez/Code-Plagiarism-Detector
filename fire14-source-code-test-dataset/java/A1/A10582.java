import java.util.Scanner;
import java.util.Arrays;

public class Main {
	private final static int N_MAX = 1024;
	
	public static void main(String[] args) {
		int T,N,S,P;

		Scanner stdin = new Scanner(System.in);
		T = stdin.nextInt();
		
		for(int i = 1;i <= T;++i) {
			N = stdin.nextInt();
			S = stdin.nextInt();
			P = stdin.nextInt();
			
			int[] score = new int[N];
			for(int j = 0;j < N;++j)
				score[j] = stdin.nextInt();
			Arrays.sort(score);
			
			int res = 0;
			
			for(int j = N - 1;j >= 0; --j)
				if(score[j] >= P * 3 - 2)
					++res;
				else if(P != 1 && score[j] >= P * 3 - 4 && S != 0) {
					++res;
					--S;
				}
			
			System.out.println("Case #" + i + ": " + res);
		}
	}
}
