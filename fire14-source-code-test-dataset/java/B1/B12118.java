import java.util.Scanner;

public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		in.nextLine();

		for (int i = 1; i <= T; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int res = 0;
			
			for (int j = A; j <= (B - 1); j++) {
				for (int k = (j + 1); k <= B; k++) {
					if(checkRecycled(j,k))
						res++;
				}
			}
			
			System.out.println("Case #"+i+": "+res);
		}

	}
	
	public static boolean checkRecycled (int n, int m){
		boolean res = false;
		
		String sn = Integer.toString(n);
		String sm = Integer.toString(m);
		String snTemp,snTemp2,snTemp3;
		if (n>10 && (sn.length() == sm.length())){
			for (int i = 1; i<sn.length(); i++){
				snTemp = sn.substring(i);
				snTemp2 = sn.substring(0, i);
				snTemp3 = snTemp+snTemp2;
				if (snTemp3.equals(sm))
					return true;
			}
		}
			
		
		return res;
	}
}
