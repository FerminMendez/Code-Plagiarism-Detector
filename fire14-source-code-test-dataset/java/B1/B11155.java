import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author vaidyasm
 */

public class ProblemC
{
	private class Pair implements Comparable<Pair>
	{
		int a, b;

		Pair(int a, int b)
		{
			this.a = Math.min(a, b);
			this.b = Math.max(a, b);
		}
		
		@Override
		public String toString()
		{
			return String.format("(%d, %d)", this.a, this.b);
		}
		
		@Override
		public boolean equals(Object o)
		{
			if (o instanceof Pair)
			{
				if (((Pair) o).compareTo(this) == 0)
					return true;
				else
					return false;
			}
			else 
				return false;
		}

		@Override
		public int compareTo(Pair o)
		{
			if (this.a == o.a)
				return 0;
			else if (this.a < o.a)
				return -1;
			else
				return 1;
		}
		
		public int hashCode()
		{
			return this.a << 16 + this.b;
		}
	}

	public ProblemC(String inFileName)
	{
		URL urlInFileName = ProblemC.class.getResource(inFileName);

		File inFile = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		try
		{
			inFile = new File(urlInFileName.toURI());
			fis = new FileInputStream(inFile);
			bis = new BufferedInputStream(fis);
		}
		catch (Exception e)
		{
//			System.err.println(e.getMessage());
		}

		Scanner s = new Scanner(bis);
		int T = Integer.parseInt(s.nextLine());
		StringBuilder sb = new StringBuilder();

		String outFileName = inFile.toString() + ".out";

		FileWriter fstream = null;
		try
		{
			fstream = new FileWriter(outFileName);
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(-3);
		}

		BufferedWriter out = new BufferedWriter(fstream);

		Set<Pair> pairs = null;

		for (int i = 1; i <= T; i++)
		{
			int A = s.nextInt();
			int B = s.nextInt();
			pairs = new HashSet<Pair>();
			

			for (int j = A; j <= B; j++)
			{
				int n = j;
				int m = 0;

				String ns = String.format("%d", n);
				int nslen = ns.length();

				for (int k = 1; k < nslen; k++)
				{
					int nchop = n % (int) Math.pow(10, k);
					int rem = n / (int) Math.pow(10, k);
					int chopToPrefix = nchop * (int) Math.pow(10, nslen - k);
					m = chopToPrefix + rem;
					if (n < m && m <= B)
					{
						Pair p = new Pair(n, m);
						pairs.add(p);
					}
				}
			}

			String strCaseOutput = String.format("%d", pairs.size());
			sb.setLength(0);
			String strOutput = String.format("Case #%d: %s\n", i, strCaseOutput);
			try
			{
				out.write(strOutput);
			}
			catch (IOException e)
			{
//				System.err.println(e.getMessage());
			}
		}
		try
		{
			out.flush();
			out.close();
		}
		catch (IOException e)
		{
//			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{		
		if (args.length < 1)
			System.exit(-1);

		String inFileName = args[0];
		
		new ProblemC(inFileName);
	}
}