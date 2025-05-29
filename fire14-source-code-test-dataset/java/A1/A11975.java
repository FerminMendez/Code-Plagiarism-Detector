package codejam;

import java.util.HashMap;
import java.util.Scanner;

public class DanceScores {

	public static void main(String[] args) {
		HashMap<Integer,int[]> best = new HashMap<Integer, int[]>();
		best.put(1 , new int[]{1,1});
		best.put(2 , new int[]{2,3});
		best.put(3 , new int[]{4,6});
		best.put(4 , new int[]{7,9});
		best.put(5 , new int[]{10,12});
		best.put(6 , new int[]{13,15});
		best.put(7 , new int[]{16,18});
		best.put(8 , new int[]{19,21});
		best.put(9 , new int[]{22,24});
		best.put(10, new int[]{25,27});
		
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i=1; i<=cases; i++){
			int n = in.nextInt();	//Number of scores
			int s = in.nextInt();	//Number of surprising score triplets
			int p = in.nextInt();	//The minimum criterion

			/********* Boundary Cases ********/
			if(p==0){
				System.out.println("Case #"+i+": "+n);
				in.nextLine(); //Ignore remaining line
				continue;
			}
			
			int[] range = best.get(p);	//The range where the best score p can be achieved only in case of surprising triplet.
			int definite = 0, probable=0;

			for(int j=0;j<n;j++){
				int score = in.nextInt();	//Reading individual scores
				if(score>=range[0] && score <=range[1])
					probable++;
				else if(score>range[1])
					definite++;
			}
			System.out.println("Case #"+i+": "+(definite+Math.min(probable, s)));
		}
	}

}
