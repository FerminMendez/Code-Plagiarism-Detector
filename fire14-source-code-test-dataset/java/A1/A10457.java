import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void doMain() throws Exception {

		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			pw.print("Case #" + (caseNum + 1) + ": ");
			//# googlers
			int n = sc.nextInt();
			//# surprising
			int s = sc.nextInt();
			//min score
			int p = sc.nextInt();
			
			ArrayList<Integer> scores = new ArrayList<Integer>(); 
			int res = 0; 
			for (int i = 0; i<n; i++) {
				scores.add(sc.nextInt());
			}
			
			int minNumberP = (p-2);
			if (minNumberP < 0) {
				minNumberP = 0;
			} 
			
			int minNumberNormal = p-1;
			if (minNumberNormal < 0) {
				minNumberNormal = 0;
			}
			
			int minSurprisingNumber = minNumberP*2+p;
			int minNumber = minNumberNormal*2+p;
			int sUsed = 0;
			for (int score : scores) {
				if (score>=minNumber) {
					res++;
				} else if (score>=minSurprisingNumber && sUsed < s) {
					res++;
					sUsed++;
				}
			}
			
			pw.println(res);
//			System.out.println(n+" "+s+" "+p+" ");
			
//			for (int score : scores) {
//				if (score>=minNumber) {
//					res++;
//				}
//			}
//			System.out.println("min score: "+minNumber);
		}


		pw.flush();
		pw.close();
		sc.close();
	}

	public static void main(String[] args) throws Exception {
//		System.out.println((int)'a');
		new Solution().doMain();
	}
}
