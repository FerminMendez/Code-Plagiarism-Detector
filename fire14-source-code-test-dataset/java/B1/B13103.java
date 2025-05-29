package QR2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class C
{
	private static class Pair
	{
		final int n;
		final int m;

		public Pair(int n, int m)
		{
			this.n = n;
			this.m = m;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + m;
			result = prime * result + n;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}

	}

	public static void main(String[] args) throws Exception
	{
		String test = "C-small-attempt0";
		BufferedReader in = new BufferedReader(new FileReader("QR2012/C/" + test + ".in"));
		PrintWriter out = new PrintWriter("QR2012/C/" + test + ".out." + System.currentTimeMillis());

		final int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++)
		{
			String[] nums = in.readLine().split("\\s");
			final int A = Integer.parseInt(nums[0]);
			final int B = Integer.parseInt(nums[1]);

			Set<Pair> pairs = new HashSet<Pair>();
			
			final int order = (int) Math.floor(Math.log10(A)) + 1;
			for (int n = A; n <= B; n++)
			{
				int m = n;
				for (int o = 0; o < order - 1; o++)
				{
					// rotate m one digit
					int tail = m % 10;
					m /= 10;
					m += tail * Math.pow(10, order - 1);
					if (m > n && m >= A && m <= B)
						pairs.add(new Pair(n, m));
				}
			}

			System.out.println("Case #" + t + ": " + pairs.size());
			out.println("Case #" + t + ": " + pairs.size());
		}
		out.close();
	}
}
