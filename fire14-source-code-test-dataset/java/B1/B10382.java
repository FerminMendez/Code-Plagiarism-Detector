package jam2012;
import java.io.*;
import java.util.*;

// Marian G Olteanu
public class QC
{
	public static void main(String[] args)
	throws Exception
	{
		initRecycle(2020202);
		
		BufferedReader inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
		int cases = Integer.parseInt(inputFile.readLine());
		
		PrintStream outFile = new PrintStream(new FileOutputStream(args[1]));
		for (int i = 1; i <= cases; i++)
		{
			String lineT[] = tokenize(inputFile.readLine());
			int A = Integer.parseInt(lineT[0]);
			int B = Integer.parseInt(lineT[1]);
			
			int out = 0;
			for (int j = A; j <= B; j++)
				if (recycle[j] != null)
					for (int e : recycle[j])
						if (e >= A)
							out++;	
			
			
			outFile.println("Case #" + i + ": " + out);
		}
		
		
		outFile.close();
		inputFile.close();
	}
	private static int[][] recycle;
	private static int totalR = 0;
	public static void initRecycle(int len)
	{
		recycle = new int[len][];
		Set<Integer> r = new HashSet<Integer>();
		for (int i = 0; i < recycle.length; i++)
		{
			String s1 = "" + i;
			
			for (int cut = 1; cut < s1.length(); cut++)
			{
				String s2 = s1.substring(cut) + s1.substring(0, cut);
				//System.out.println(s1 + ".." + s2);
				if (!s2.startsWith("0"))
				{
					int v2 = Integer.parseInt(s2);
					if (v2 < i)
						r.add(v2);
				}
			}
			//System.out.println(i + ": " + r);
			
			if (r.size() > 0)
			{
				recycle[i] = toArray(r);
				r.clear();
			}
		}
		//System.out.println(totalR);
	}
	
	private static int[] toArray(Collection<Integer> r)
	{
		int[] out = new int[r.size()];
		int i = 0;
		for (Integer e : r)
			out[i++] = e.intValue();
//		for (int i = 0; i < out.length; i++)
//			out[i] = r.get(i).intValue();
		
		totalR += out.length;
		return out;
	}
	
	
	
	
	public static String[] tokenize(String input)
	{
		StringTokenizer st = new StringTokenizer(input);
		String[] k = new String[st.countTokens()];
		for (int i = 0; i < k.length; i++)
			k[i] = st.nextToken();
		return k;
	}
	public static String[] tokenize(String input, String sep)
	{
		StringTokenizer st = new StringTokenizer(input , sep);
		String[] k = new String[st.countTokens()];
		for (int i = 0; i < k.length; i++)
			k[i] = st.nextToken();
		return k;
	}
	
}

