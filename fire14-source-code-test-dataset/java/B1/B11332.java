package quali2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int testcase = 1; testcase <= T; testcase++) {
			int A = in.nextInt();
			int B = in.nextInt();
			//System.out.println("["+A + " " + B+"]");
			int answer = 0;
			List<Integer> found = new ArrayList<Integer>();
			for (int i = A; i <= B; i++) {
				for (int j = A; j <= B; j++) {
					if (i < j) {
						for (int k = 1; k < String.valueOf(A).length(); k++) {
							int a, b1;
							String b;
							
							a = recycleNumber(j, k);
							b =  debugsplit(j, k);
							b1 = i;

							if (a == b1) {
								answer += 1;
								//System.out.println(j + " " + b1+ " ["+b+"]");
								
							}
						}
					}
				}

			}
			System.out.format("Case #%d: %s\n", testcase, answer);
		}

	}

	private static int recycleNumber(int num, int pos) {
		String input = String.valueOf(num);
		String subA, subB;

		subA = input.substring(0, pos);
		subB = input.substring(pos);

		/*if(subA == subB){
			return 0;
		}*/
		int result = Integer.parseInt(subB + subA);
		return result;
	}
	private static String debugsplit(int num, int pos) {
		String input = String.valueOf(num);
		String subA, subB;

		subA = input.substring(0, pos);
		subB = input.substring(pos);

		/*if(subA == subB){
			return "";
		}*/
		String result = subA +" "+ subB;
		return result;
	}

}
