import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		
		int T = r.nextInt();
		int caseNumber = 1;
		while(T-- > 0){
			int N = r.nextInt();
			int S = r.nextInt();
			int P = r.nextInt();
			
			int[] a = new int[N];
			for(int i = 0; i < N; i++)
				a[i] = r.nextInt();
			
			Arrays.sort(a);
			
			int ret = 0;
			for(int i = N - 1; i >= 0; i--){
				boolean need = true;
				for(int x = 0; x <= 10; x++)
				for(int y = 0; y <= 10; y++){
					int z = a[i] - x - y;
					if(z > 10 || z < 0)continue;
					
					int max = Math.max(x, Math.max(y, z));
					if(max >= P && (Math.abs(x - y) <= 1 && Math.abs(x - z) <= 1 && Math.abs(y - z) <= 1)){
						need = false;
					}
				}
				
				if(!need)ret++;
				else{
					if(S > 0){
						boolean can = false;
						
						for(int x = 0; x <= 10; x++)
						for(int y = 0; y <= 10; y++){
							int z = a[i] - x - y;
							if(z > 10 || z < 0)continue;
							
							int max = Math.max(x, Math.max(y, z));
							if(max >= P && (Math.abs(x - y) <= 2 && Math.abs(x - z) <= 2 && Math.abs(y - z) <= 2)){
								can = true;
							}
						}
						
						if(can){
							S--;
							ret++;
						}
					}
				}
			}
			System.out.printf("Case #%d: %d\n", caseNumber++, ret);
		}
	}
}
