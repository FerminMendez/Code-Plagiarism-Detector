
import java.io.*;
import java.util.*;

public class RecycledNumbers
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("RecycledNumbers-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("RecycledNumbers-small-attempt0.out", false));

		String line = in.readLine();
		int cases = Integer.parseInt(line); // # of test cases

		for (int i = 1; i <= cases; i++)
		{
			line = in.readLine();
			String[] parts = line.split(" ");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);

			out.write("Case #" + i + ": " + solve(a,b));
			out.newLine();
		}

		in.close();
		out.close();

	}

	private static int solve(int a, int b)
	{
		Set<Pair> set = new HashSet<Pair>();
		for (int i = a; i <= b; i++)
		{
			String s = Integer.toString(i);
			char f = s.charAt(0);
			for (int j = 1, len = s.length(); j < len; j++)
			{
				if (s.charAt(j) < f) continue;
				String t = s.substring(j) + s.substring(0, j);
				int k = Integer.parseInt(t);
				if (k > i && k <= b) set.add(new Pair(i, k));
			}
		}
		return set.size();
	}

	private static class Pair
	{
		private int a;
		private int b;

		public Pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}

		public int hashCode()
		{
			return (a ^ b);
		}

		public boolean equals(Object obj)
		{
			Pair that = (Pair) obj;
			return (this.a == that.a && this.b == that.b);
		}
	}
}

