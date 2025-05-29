import java.util.Scanner;


public class Main {
	static int move(int n, int p){
		return (n%10)*(int)Math.pow(10, p) + n/10;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++){
			int out=0;
			int A=sc.nextInt();
			int B=sc.nextInt();
			int p = (int)Math.log10((double)A);
			
			for(int n=A; n<B; n++) {
				int m = n;
				for(int i=0; i<=p; i++){
					m = move(m,p);
					if(n<m && m<=B)
						out++;
				}
			}
			System.out.println("Case #"+t+": "+out);
		}
	}
}
