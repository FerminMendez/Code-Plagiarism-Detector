import java.util.HashSet;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		
		int T = r.nextInt();
		int caseNumber = 1;
		while(T-- > 0){
			int A = r.nextInt();
			int B = r.nextInt();
			
			int ret = 0;
			for(int x = A; x <= B; x++){
				HashSet<Integer> S = new HashSet<Integer>();
				
				int curr = x;
				int L = (curr + "").length();
				int L10 = 1;
				for(int i = 0; i < L - 1; i++)
					L10 *= 10;
				
				for(int itr = 0; itr < L; itr++){
					if((curr + "").length() == L && !S.contains(curr) && curr <= B && curr >= A && curr < x){
						ret++;
					}
					
					S.add(curr);
					curr = R(curr, L10);
				}
			}
			
			System.out.printf("Case #%d: %d\n", caseNumber++, ret);
		}
	}
	static int R(int x, int L){
		int m = x % 10; 
		return (x / 10) + (L * m);
	}
}
