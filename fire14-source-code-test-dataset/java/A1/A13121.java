import java.util.Scanner;


public class b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//n cases
		for (int i = 1; i <= n+1; i++) {
			//for each case
			int dancers = sc.nextInt();
			int surprising = sc.nextInt();
			int minscore = sc.nextInt();
			int res=0;
			for (int j = 0; j < dancers; j++) {
				int scoretotal = sc.nextInt();
				if (minscore!=0 && scoretotal/minscore>=1) {
					
					if (surprising>=1) {
						if (scoretotal>minscore*3-3) {
							res++;
						}else if (scoretotal==minscore*3-4 || scoretotal==minscore*3-3) {
							res++;
							surprising--;
						}
					}else if (surprising==0) {
						if (scoretotal>=minscore*3-2) {
							res++;
						}
					}
				}else if (minscore==0) {
					res = dancers;
				}
			}
			
			System.out.println("Case #"+i+": "+res);
		}
	}
	
	
}
