import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class ProblemC {

	static int numLength(int x)
	{
		int ans = 0;
		while (x > 0)
		{
			ans ++;
			x /= 10;
		}
		return ans;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fin = new Scanner(new File("C.txt"));
		PrintStream fout = new PrintStream("C.ans");
		int caseN = fin.nextInt();
		for (int caseI = 1; caseI <= caseN; caseI++)
		{
			int A = fin.nextInt();
			int B = fin.nextInt();
			int ans = 0;
			for (int n = max(A, 12); n < B; n++)
			{
				String front = Integer.valueOf(n / 10).toString();
				String back = Integer.valueOf(n % 10).toString();
				Set<Integer> appeared = new HashSet<Integer>();
				while (front.length() != 0)
				{
					if (back.charAt(0) != '0')
					{
						int m = Integer.valueOf(back + front);
						if (m > n && m <= B && !appeared.contains(m))
						{
							ans++;
							appeared.add(m);
							//fout.println(n + " " + m);
						}
					}
					back = front.charAt(front.length() - 1) + back;
					front = front.substring(0, front.length() - 1);
				}
			}
			fout.println("Case #" + caseI + ": " + ans);
		}
	}

}
