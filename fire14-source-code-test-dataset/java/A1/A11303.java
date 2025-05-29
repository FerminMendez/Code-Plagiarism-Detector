import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Dance {

/*	private static int maxScore(int total, boolean isSurprise) {
		int base = total / 3;
		if (isSurprise) {
			switch ( total % 3 ) {
			case 0:  return base + 1;
			case 1:  return base + 1; 
			case 2:  return base + 2;		
			}
		} else {
			switch ( total % 3 ) {
			case 0:  return base;
			case 1:  return base + 1; 
			case 2:  return base + 1;		
			}			
		}
		return -1;
	}*/
	
	private static int[] noSurpriseList={ 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9,10,10,10};
	private static int[] surpriseList={  -1, -1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9,10,10,10,-1, -1};
	
	/*  
	 0 :  0 ,  X
	 1 :  1 ,  X
	 2 :  1 ,  2
	 3 :  1 ,  2
	 4 :  2 ,  2
	 5 :  2 ,  3
	 6 :  2 ,  3
	 7 :  3 ,  3
	 8 :  3 ,  4
	 9 :  3 ,  4
	10 :  4 ,  4
	11 :  4 ,  5
	12 :  4 ,  5
	13 :  5 ,  5
	14 :  5 ,  6
	15 :  5 ,  6
	16 :  6 ,  6
	17 :  6 ,  7
	18 :  6 ,  7
	19 :  7 ,  7
	20 :  7 ,  8
	21 :  7 ,  8
	22 :  8 ,  8
	23 :  8 ,  9
	24 :  8 ,  9
	25 :  9 ,  9
	26 :  9 , 10
	27 :  9 , 10
	28 : 10 , 10
	29 : 10 , XX
	30 : 10 , XX
	*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
/*		for (int i=0;i<=30;i++) {
			System.out.printf("%2d,", maxScore(i, true));
		}
		
		System.exit(0);*/
		
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int ret = 0;
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for(int n=0;n<N;n++) {
				int tn = in.nextInt();
				int s= surpriseList[tn];
				int ns= noSurpriseList[tn];
				if (s<0 || s == ns) {
					if (ns>=p) ret++;
				} else if (s>=p) {
					nums.add(tn);
				}
			}
			Collections.sort(nums, new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					return surpriseList[o1] - surpriseList[o2];
				}
				
			});
			
			//System.out.println("X: " + nums);
			if (nums.size()>=S) {
				ret+=S;
				for(int i=S;i<nums.size();i++) {
					if (noSurpriseList[nums.get(i)]>=p) ret++;
				}
			} else {
				ret+=nums.size();
			}
			System.out.println("Case #" + t + ": " + ret);
		}
	}

}
