import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.Math.abs;

public class B {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("input.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("output"));

		int T = in.nextInt();

		int n, s, p;
		for (int i = 1; i <= T; i++) {
			// read input
			n = in.nextInt(); s = in.nextInt();	p = in.nextInt();
			int[] googlers = new int[n];
			for (int j = 0; j < n; j++)
				googlers[j] = in.nextInt();

			// solve
			int ans = solve(n, s, p, googlers);
			System.out.println(ans);
			bw.write("Case #" + i + ": " + ans);
			bw.newLine();
		}
		
		bw.close();
	}

	private static int solve(int n, int s, int p, int[] googlers) throws IOException {
		boolean[] surp = new boolean[n];
		boolean[] reach = new boolean[n];
		boolean[] both = new boolean[n];
		
		for (int T = 0; T < n; T++)
			for (int i = 0; i <= 10; i++)
				for (int j = i; j <= i+2 && j <= 10; j++)
					for (int k = j; k <= j+2 && j <= 10; k++)
						if (i+j+k == googlers[T] && check(i, j, k))
						{
							boolean a = isSurprising(i, j, k), b = reached(i, j, k, p);
							if(!surp[T]) surp[T] = a && !b;
							if(!reach[T]) reach[T] = b && !a;
							if(!both[T]) both[T] = a && b; 
						}
		
		int max = findMax(n, s, p, surp, reach, both);
		
		return max;
	}

	private static int findMax(int n, int s, int p, boolean[] surp,	boolean[] reach, boolean[] both) {
		
		int max = 0;
		for(int i = 0; i < n; i++)
			if(both[i] || reach[i])max++;
		
		int ss = 0;
		for(int i = 0; i < n; i++)
			if(surp[i] || both[i]) ss++;
		
		if(ss == s)
			return max;
		else // ss > s
		{
			for(int i = 0; i < n; i++)
				if(surp[i] || (both[i] && reach[i])) ss--;
			
			if(ss <= s)
				return max;
			else
				return max-(ss-s);
			
		}
	}

	private static boolean reached(int i, int j, int k, int p) {
		return Math.max(i, Math.max(j, k)) >= p;
	}

	private static boolean isSurprising(int i, int j, int k) {
		return abs(i - j) == 2 || abs(j - k) == 2 || abs(i - k) == 2;
	}

	private static boolean check(int i, int j, int k) {
		return abs(i - j) <= 2 && abs(j - k) <= 2 && abs(i - k) <= 2;
	}
}
