import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Recycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int result = getResult(A, B);
			System.out.println("Case #" + i + ": " + result);
		}
		
	}

	private static int getResult(int A, int B) {
		int result = 0;
		int numDigits = Integer.toString(A).length();
		Set<Integer> processed = new HashSet<Integer>();
		for (int num = A; num <= B; num++) {
			if (processed.contains(num))
				continue;
			processed.add(num);
			int count = 0;
			for (int rotated = 1; rotated < numDigits; rotated++) {
				int tp = tenpow(rotated);
				int dropped = num % tp;
				int stay = num / tp;
				int recyclednumber = dropped * tenpow(numDigits - rotated) + stay;
				if (processed.contains(recyclednumber))
					continue;
				processed.add(recyclednumber);
				if (recyclednumber >= A && recyclednumber <= B)
					count++;
			}
			if (count == 0)
				continue;
			count +=1;
			result += ncr(count, 2);
		}
		return result;
	}

	private static int ncr(int n, int r) {
		return factorial(n)/(factorial(n-r) * factorial(r));
	}

	private static int tenpow(int exp) {
		int res = 1;
		for (int i = 0; i < exp; i++)
			res *= 10;
		return res;
	}
	
	private static int factorial(int n)
    {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

}
