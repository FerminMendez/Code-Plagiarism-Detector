import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int normal = 0;
			int surprising = 0;
			for(int i=0; i<N; i++) {
				int ti = sc.nextInt();
				int M = ti/3;
				int R = ti%3;
				if(M>=p || (R>=1 && M+1>=p)) {
					normal++;
				} else if(surprising<S &&
						((R==2 && M+2>=p)
							|| (R==0 && M>0 && M+1>=p))) {
					surprising++;
				}
				
			}
			
			System.out.println("Case #" + t + ": " + (surprising+normal));
		}
		
	}

}
