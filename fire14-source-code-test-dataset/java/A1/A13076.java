
import java.io.BufferedInputStream;
import java.util.Scanner;

public class ProblemB {
	
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		
		int T = scanner.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = scanner.nextInt();
			int S = scanner.nextInt();
			int p = scanner.nextInt();
			int res = 0;
			
			for(int j = 0; j < N; j++) {
				double t = (double)(scanner.nextInt());
				
				if(t >= 0) {
					if(t/3 >= p) res++;
					else if(t >= 1) {
						if((t-1)/3 + 1 >= p) res++;
						else if(t >= 2) {
							if((t-2)/3 + 1 >= p) res++;
							else if((t-2)/3 + 2 >= p && S > 0) {res++; S--;}
							else if(t >= 3) {
								if((t-3)/3 + 2 >= p && S > 0) {res++; S--;}
								else if(t >= 4 && (t-4)/3 + 2 >= p && S > 0) {res++; S--;}
							}
						}
					}
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+res);
		}

	}
	
}
