import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public void doMain() throws Exception {

		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			pw.print("Case #" + (caseNum + 1) + ": ");
			//# A
			int a = sc.nextInt();
			//# B
			int b = sc.nextInt();
			
			int res = 0;
			for (int i = a; i<b; i++) {
				for (int j = i+1; j<=b ; j++) {
					if(recycledPairs(i, j, a, b)) {
						res++;
					}
				}
			}
			pw.println(res);
		}


		pw.flush();
		pw.close();
		sc.close();
	}
	
	public boolean recycledPairs(int n, int m, int a, int b) {
		boolean result = false;
		String initial = ""+n;
		String expected = ""+m;
		
		for (int i=1; i<initial.length(); i++) {
			if (expected.equals(initial.substring(i,initial.length())+initial.substring(0,i))) {
				result = true;
			}
		}
		
//		System.out.println(n+" "+m+ " "+result);
		return result;
	}

	public static void main(String[] args) throws Exception {
//		System.out.println((int)'a');
		new Solution().doMain();
	}
}
