import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T=in.nextInt();
		for(int t=1; t<=T; t++) {
			int max=0;
			
			int N = in.nextInt(), S = in.nextInt();
			int p = in.nextInt();
			
			int sMin = (p==0)?0:(3*p-2);
			int strictMin = (p<=2)?p:(3*p-4);
			
			while(N-->0) {
				int s = in.nextInt();
				if(s >= sMin)
					max++;
				else if(s >= strictMin && S>0) {
					max++;
					S--;
				}
			}
			
			System.out.println("Case #"+t+": "+max);
		}
	}
}
