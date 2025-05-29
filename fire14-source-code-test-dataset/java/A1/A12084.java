import java.util.*;

class B{
	public static void main(String... arg){
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for(int caseNo = 1; caseNo <= cases; caseNo++ ){
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			
			int[] t = new int[N];
			int n = 0;
			for(int i = 0; i < N; i++)
					t[i] = sc.nextInt();
			if(p == 0)
				System.out.println("Case #" + caseNo + ": " + N);
			else{
				for(int i = 0; i < N; i++){
					int tmp = ((int)(t[i]/3));
					if(t[i] == 0) tmp = 0;
					else{
						if(t[i] % 3 != 0) tmp = tmp + 1;
					}
					if(tmp >= p) n++;
				}
				if (S == 0)
					System.out.println("Case #" + caseNo + ": " + n);
				else{
					Arrays.sort(t);
					for(int i = N-n-1; i >= 0 && S > 0; i--){
						int tmp = ((int)(t[i]/3));
						if(t[i] == 0) tmp = 0;
						else{
							int rem = t[i] % 3;
							if(rem == 2 && t[i] <= 28) tmp = tmp + 2;
							else if(rem == 0 && t[i] <= 29) tmp = tmp + 1;
							else continue;
						}
						if(tmp >= p) { n++; S--; }
					}
					System.out.println("Case #" + caseNo + ": " + n);
				}
			}
		}
	}
}