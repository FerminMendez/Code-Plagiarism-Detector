import java.util.Arrays;
import java.util.Scanner;


public class dancingWithTheGooglers {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nCases = in.nextInt();
		for (int c = 0; c < nCases; c++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int min = in.nextInt();
			//System.out.printf("%d is the best result we're looking for\n", min);
			int[] t = new int[n];
			for (int i = 0; i < n; i++) {
				t[i] = in.nextInt();
			}
			Arrays.sort(t);
			int unsurprisingMinTotal = min + 2*(min-1 < 0 ? 0 : min-1);
			int surprisingMinTotal = min + 2*(min-2 < 0 ? 0 : min-2);
			int count = 0;
			int surprisesLeft = s;
			while (surprisesLeft >= 0) {
				if (t[t.length-1-count] >= unsurprisingMinTotal) {
					//System.out.printf("%d is unsurprising\n", t[t.length-1-count]);
					count++;
				} else if(t[t.length-1-count] >= surprisingMinTotal && surprisesLeft > 0) {
					//System.out.printf("%d is surprising\n", t[t.length-1-count]);
					surprisesLeft--;
					count++;
				} else {
					//System.out.printf("%d is rejected\n", t[t.length-1-count]);
					surprisesLeft = -1;
				}
				
				if (count >= t.length) {
					break;
				}
			}
			System.out.printf("Case #%d: %d\n", c+1, count);
		}
	}
}
