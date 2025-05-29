import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++){
			int N=sc.nextInt();
			int S=sc.nextInt();
			int P=sc.nextInt();
			int P1 = P-1<0 ? 0 : P-1;
			int P2 = P-2<0 ? 0 : P-2;
			
			int[] sum = new int[N];
			for(int i=0; i<N; i++)
				sum[i] = sc.nextInt();
			
			int out = 0;
			for(int i=0; i<N; i++)
				if(sum[i] >= 2*P1+P) {
					out++;
					sum[i] = -1;
				}
			for(int i=0; i<N && S>0; i++)
				if(sum[i] >= 2*P2+P){
					S--;
					sum[i] = -1;
					out++;
				}
			System.out.println("Case #"+t+": "+out);
		}
	}

}
