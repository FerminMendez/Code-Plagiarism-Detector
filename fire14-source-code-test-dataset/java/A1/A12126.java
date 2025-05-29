import java.util.Scanner;


public class Main {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int x=0; x<T; x++) {
			int N = in.nextInt(); //googlers
			int S = in.nextInt(); //surprising
			int p = in.nextInt(); //score to beat
			
			int direct = 0;
			int poss = 0;
			
			for(int i=0; i<N; i++) {
				int total = in.nextInt();
				int m = total/3;
				int mod = total %3;
				if(mod >0)
					m++;
				if(m>=p) {
					direct++;
					continue;
				}
				else if(m<p-1)
					continue;
				//Time to use possibilities
				switch(mod) {
				case 0:
					if(m<10 && m>0)
						poss++;
					break;
				case 2:
					if(m<10)
						poss++;
					break;
				}
			}
			int result = (S>poss)? poss : S;
			result += direct;
			System.out.print("Case #" + String.valueOf(x+1) + ": ");
			System.out.println(result);
		}
	}
}