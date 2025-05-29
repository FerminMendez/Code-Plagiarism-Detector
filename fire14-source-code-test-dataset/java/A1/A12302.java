import java.util.ArrayList;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Dance {
	
	public static int lowScore(int a) {
		return a/3;
	}

	public static int mediumScore(int a) {
		if (a%3==0)
			return a/3;
		else
			return a/3 + 1;
	}

	public static int surprisingScore(int a) {
		if (a == 0) return 0;
		if (a == 1) return 1;
		if (a == 2) return 2;
		if (a%3 == 0)
			return a/3 + 1;
		else
			return a/3+2;
	}


	public static int maxAbove(ArrayList<Integer> l, int S, int p) {
		int aboveP = 0;
		for (Integer a : l) {
			if (lowScore(a) >= p) {
				aboveP++;
				//System.out.println(a + "low");
			} else if (mediumScore(a) >= p) {
				aboveP++;
				//System.out.println(a + "med");
			} else if (surprisingScore(a) >= p && S > 0) {
				aboveP++;
				S--;
				//System.out.println(a+"surprise");
			}
		}
		return aboveP;
	}

	public static void main(String[] args) throws Exception{
		/*ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(29);
		l.add(20);
		l.add(8);
		l.add(18);
		l.add(18);
		l.add(21);
		System.out.println(maxAbove(l, 2, 8));*/


		Scanner in = new Scanner(new File(args[0]));
		int tests = in.nextInt();
		for (int i = 1 ; i <= tests; i++) {
			int googlers = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for (int j = 0; j < googlers; j ++ ) {
				nums.add(in.nextInt());
			}
			System.out.println("Case #" + i + ": " + maxAbove(nums, S, p));
		}

		//int[] m = new int[] {15}
	}

}