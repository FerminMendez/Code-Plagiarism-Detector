import java.util.*;
import java.io.*;

public class ProblemB {

	static boolean surprising(int s, int p)
	{
		int r = s % 3;
		int x;
		if (r == 0)
			x = (s - 3) / 3;
		else if (r == 1)
			x = (s - 4) / 3;
		else
			x = (s - 2) / 3;
		if (x >= 0 && x <= 8)
		{
			return (x + 2) >= p;
		}
		else
			return false;
	}
	
	static boolean nonsurprising(int s, int p)
	{
		int r = s % 3;
		int x;
		if (r == 0)
		{
			x = s / 3;
			return x >= 0 && x <= 10 && x >= p;
		}
		else if (r == 1)
			x = (s - 1) / 3;
		else
			x = (s - 2) / 3;
		return (x >= 0 && x <= 9 && x + 1 >= p);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = new Scanner(new File("B.txt"));
		int caseN = cin.nextInt();
		for (int caseI = 1; caseI <= caseN; caseI++)
		{
			int n = cin.nextInt();
			int s = cin.nextInt();
			int p = cin.nextInt();
			int scores[] = new int[n];
			boolean sur[] = new boolean[n];
			boolean non[] = new boolean[n];
			for (int i=0; i<n; i++)
				scores[i] = cin.nextInt();
			int ans = 0;
			int inc = 0, dec = 0, rem = 0;
			for (int i=0; i<n; i++)
			{
				sur[i] = surprising(scores[i], p);
				non[i] = nonsurprising(scores[i], p);
				if (non[i])
					ans++;
				if (sur[i] == non[i])
					rem++;
				else if (sur[i])
					inc++;
				else
					dec++;
			}
			int delta;
			delta = Math.min(s, inc);
			s -= delta;
			ans += delta;
			delta = Math.min(s, rem);
			s -= delta;
			delta = Math.min(s, dec);
			s -= delta;
			ans -= delta;
			System.out.println("Case #" + caseI + ": " + ans);
		}
	}

}
