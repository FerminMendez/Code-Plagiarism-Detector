/*
 * Google Code Jam 2012 - Qualification Round (14.04.2012)
 * Thomas "ThmX" Denoréaz - thomas.denoreaz@gmail.com
 */

package codejam._2012.qualif;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class B {
	
	static final String FILENAME = "B-small-attempt1";
	
	public static boolean isValidTriplet(int a, int b, int c) {
		return (abs(b-a) <= 1) && (abs(c-a) <= 1) && (abs(c-b) <= 1);
	}
	
	public static boolean isValidSurprisingTriplet(int a, int b, int c) {
		return (abs(b-a) <= 2) && (abs(c-a) <= 2) && (abs(c-b) <= 2);
	}
	
	public static int[][] TRIPLETS_MAX_VALUES = {
			{0, 0}, // 0
			{0, 0}, // 1
			{0, 0}, // 2
			{1, 0}, // 3
			{2, 0}, // 4
			{2, 3}, // 5
			{2, 3}, // 6
			{3, 3}, // 7
			{3, 4}, // 8 
			{3, 4}, // 9
			{4, 4}, 
			{4, 5}, 
			{4, 5}, 
			{5, 5}, 
			{5, 6}, 
			{5, 6}, 
			{6, 6}, 
			{6, 7}, 
			{6, 7}, 
			{7, 7}, 
			{7, 8}, 
			{7, 8}, 
			{8, 8}, 
			{8, 9}, 
			{8, 9}, 
			{9, 9}, 
			{9, 10}, 
			{9, 10}, 
			{10, 10}, 
			{10, 0}, 
			{10, 0}
		};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		int[][] tripletsMaxValue = new int[31][2]; 
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				for (int k = 1; k <= 10; k++) {
					if (isValidTriplet(i, j, k)) {
						int idx = i + j + k;
						int max = max(max(i, j), k);
						tripletsMaxValue[idx][0] = max(max, tripletsMaxValue[idx][0]);

					} else if (isValidSurprisingTriplet(i, j, k)) {
						int idx = i + j + k;
						int max = max(max(i, j), k);
						tripletsMaxValue[idx][1] = max(max, tripletsMaxValue[idx][1]); 
					}
				}
			}
		}
		
		System.out.print("TRIPLETS_MAX_VALUES = ");
		for (int i = 0; i < tripletsMaxValue.length; i++) {
			System.out.println(Arrays.toString(tripletsMaxValue[i]) + ", ");			
		}
		System.out.println();
		//*/
		
		//*
		BufferedReader reader = new BufferedReader(new FileReader(FILENAME + ".in"));
		PrintWriter writer = new PrintWriter(FILENAME + ".out");
		
		int T = Integer.valueOf(reader.readLine());
		for (int t=1; t<=T; t++) {
			
			String[] nums = reader.readLine().split(" ");
			int N = Integer.valueOf(nums[0]);
			int S = Integer.valueOf(nums[1]);
			int p = Integer.valueOf(nums[2]);
			
			int[] ti = new int[N];
			for (int i=0; i<N; i++) {
				ti[i] = Integer.valueOf(nums[3+i]);
			}
			
			int count = count(0, S, N-S, p, ti);
			
			writer.println("Case #" + t + ": " + count);
		}
		
		writer.flush();
		writer.close();
		reader.close();
		//*/
	}
	
	public static int count(int i, int S, int nS, int p, int[] ti) {
		if (S == 0 && nS == 0) {
			return 0;
		}
	
		int max1 = 0;
		if (nS > 0) {
			max1 = count(i+1, S, nS-1, p, ti);
			if (TRIPLETS_MAX_VALUES[ti[i]][0] >= p) {
				++max1;
			}
		}
		
		int max2 = 0;
		if (S > 0) {
			max2 = count(i+1, S-1, nS, p, ti);
			if (TRIPLETS_MAX_VALUES[ti[i]][1] >= p) {
				++max2;
			}
		}
		
		return max(max1, max2);
	}
}
