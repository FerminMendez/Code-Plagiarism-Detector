import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class ProblemC {
	public static void main(String [] args) throws NumberFormatException, IOException
	{
		BufferedReader r = new BufferedReader( new FileReader("C:\\Users\\ÐÐÐ\\Downloads\\C-small-attempt0.in"));
		ArrayList<String> s = new TestCaseReader().read(r);
		s = new ProblemC().remap(s);
		OutputPrinter p = new OutputPrinter();
		for (String str : s)
			p.print(str);
		p.m_writer.flush();
		p.m_writer.close();
		
	}

	private ArrayList<String> remap(ArrayList<String> s) {
		ArrayList<String> remapped = new ArrayList<String>();
		for (String str : s)
		{
			
			StringTokenizer tk = new StringTokenizer(str, "  ");
			int A = Integer.parseInt(tk.nextToken());
			int B = Integer.parseInt(tk.nextToken());
			int total = 0;
			
			for (int n = A; n <= B ; n ++ )
			{
				HashSet<Integer> possible_ms = new HashSet<Integer>();
				String n_str = "" + n;
				int n_digits = (int) (Math.floor( Math.log10( n  ) ) + 1);
				for (int i = 0 ;i < n_digits-1 ; i ++)
				{
					char c = n_str.charAt(n_str.length() -1);
					n_str = c + n_str.substring(0, n_str.length()-1);
					int result = Integer.parseInt(n_str);
					if ((int) (Math.floor( Math.log10(result  ) ) + 1) == n_digits)	
						possible_ms.add(result);
				}
				if (possible_ms.size() == 0)
					continue;
				total = match(n,B, total, possible_ms, n_digits);
			}
			remapped.add(""+total);
		}
		return remapped;
	}

	private int match(int n, int B, int total, HashSet<Integer> possible_ms,
			int n_digits) {
		for (int m = n+1; m <= B ; m ++)
		{
			int m_digits = (int) (Math.floor( Math.log10( m  ) ) + 1);
			if (m_digits != n_digits)
				continue;
			if (possible_ms.contains(m))
				total ++;
			
		}
		return total;
	}
}
