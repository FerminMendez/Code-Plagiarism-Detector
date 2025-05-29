import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Run3
{
	private static class Pair
	{
		private String n;
		private String m;
		
		public Pair(String n, String m)
		{
			this.n = n;
			this.m = m;
		}
		
		public String getStringN()
		{
			return n;
		}
		
		public String getStringM()
		{
			return m;
		}
		
		public int getIntegerN()
		{
			return Integer.parseInt(n);
		}
		
		public int getIntegerM()
		{
			return Integer.parseInt(m);
		}
		
		@Override
		public boolean equals(Object obj)
		{
			Pair pair = (Pair)obj;
			if ((pair.getStringN().equals(this.n) && pair.getStringM().equals(this.m)) ||
				(pair.getStringN().equals(this.m) && pair.getStringM().equals(this.n)))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		@Override
		public String toString()
		{
			return n+" "+m;
		}
	}
	public static void main(String[] args)
	{
		String path = "files/C-small-attempt1.in";
		
		int T = 0;
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		try
		{
			boolean isFirstLine = true;
			
			FileReader FR = new FileReader(path);
			BufferedReader BR = new BufferedReader(FR);
			String str = "";
			
			while((str=BR.readLine())!=null)
			{
				if (isFirstLine)
				{
					T = Integer.parseInt(str);
					isFirstLine = false;
				}
				else
				{
					String[] temp = str.split(" ");
					
					A.add(Integer.parseInt(temp[0]));
					B.add(Integer.parseInt(temp[1]));
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		for (int i = 0; i < T; i++)
		{
			pairs.clear();
			int start = A.get(i);
			int end = B.get(i);
			
			for (int j = start; j <= end; j++)
			{
				String n = String.valueOf(j);
				String m = "";
				for (int x = 1; x < n.length() ; x++)
				{
					m = moveDigital(n, x);
					if (start <= Integer.parseInt(n) && Integer.parseInt(n) < Integer.parseInt(m) && Integer.parseInt(m) <= end)
					{
						Pair pair = new Pair(n, m);
						if (!pairs.contains(pair))
						{
							pairs.add(pair);
						}
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+pairs.size());
		}
	}
	
	static public String moveDigital(String number, int digitals)
	{
		return number.substring(number.length()-digitals, number.length())+number.substring(0, number.length()-digitals);
	}
}