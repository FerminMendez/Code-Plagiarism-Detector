import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int k = 1; k<=T; k++){
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			
			int[] t=new int[n];
			
			for (int i =0; i<n; i++) t[i]=in.nextInt();
			Arrays.sort(t);
			
			int comp =0;
			
			for (int i = n-1; i>=0; i--){
				if (t[i]<p) {
					continue;
				}
				if (t[i]>=3*p-2) {
					comp++;
					continue;
				}
				if (s>0 && t[i]>=3*p-4){
					s--;
					comp++;
					continue;
				}
			break;	
			}
			System.out.println("Case #"+k+": "+comp);
		}

	}

}
