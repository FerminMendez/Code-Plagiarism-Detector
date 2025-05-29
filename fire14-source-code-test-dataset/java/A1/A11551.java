import java.util.Scanner;

public class Dancing {
	
	public static int isPossible(int p, int t){
			
		// -1 -> not possible
		//  0 -> possible
		//  1 -> possible but surprising
		
		int a = (t-p)/2;
		int b = t-p-a;
		
		if((t/3)>=p){
			return 0;
		}
		if(a<0 || b<0){
			return -1;
		}
		if(Math.abs(p-a)<=2 && Math.abs(p-b)<=2 && Math.abs(p-b)<=2) { 
			if(Math.abs(p-a)==2 || Math.abs(p-b)==2 || Math.abs(p-b)==2){
				return 1;
			}
			return 0;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int t[] = new int[N];
			int count=0;
			
			for(int j=0; j<N; j++){
				t[j] = sc.nextInt();
				switch(isPossible(p,t[j])){
					case 0:
						count++;
						break;
					case 1:
						if(S!=0){
							count++;
							S--;
						}
				}
			}
			System.out.print("Case #" + (i + 1) + ": "+count );
			
			
			System.out.println();
		}
	}
}
