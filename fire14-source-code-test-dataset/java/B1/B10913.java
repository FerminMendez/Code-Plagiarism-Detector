import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T=in.nextInt();
		for(int t=1; t<=T; t++) {
			int N=0;
			
			int A=in.nextInt(), B=in.nextInt();
			int num = (int) Math.log10(B);			
			for(int n=A; n<B; n++) {
				int p=10;
				int q=(int) Math.pow(10, num);
				for(int j=0; j<num; j++) {
					int m = (n/p) + (n%p)*q;
					p*=10;
					q/=10;
					if(m > n && m <= B)
						N++;
				}
			}
			
			System.out.println("Case #"+t+": "+N);
		}
	}

}
