import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class recycle {

	static int lim,start;
	static HashMap<String,HashSet<String>> set ;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("problem.in"));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++)
		{
			set  = new HashMap<String,HashSet<String>>();
			String line = br.readLine();
			String val1 = line.split(" ")[0];
			String val2 = line.split(" ")[1];
			if (val1.length() == 1)
			{
				System.out.println("Case #" + i + ": 0");
				continue;
			}
			int v1 = Integer.parseInt(val1);
			int v2 = Integer.parseInt(val2);
			start = v1;
			lim = v2;
			int count = 0;
			for (int j = v1; j <= v2; j++)
			{
				recycle(j);
			}
			Set<String> key = set.keySet();
			Iterator k = key.iterator();
			int c = 0;
			while (k.hasNext())
			{
				String ne = (String)k.next();
				c+= set.get(ne).size();
			}
			System.out.println("Case #" + i + ": " + c);
			
			
		}
	}
	public static void recycle(Integer i)
	{
		String s = i.toString();
		boolean flag = false;
		for (int j = s.length() - 1; j > 0; j--)
		{
			String temp = "";
			temp += s.substring(j);
			temp += s.substring(0,j);
			if (temp.equals(s) == false && Integer.parseInt(temp) < lim && Integer.parseInt(temp) > start)
			{
				Integer lesser = Math.min(Integer.parseInt(s), Integer.parseInt(temp));
				Integer greatr = Math.max(Integer.parseInt(s), Integer.parseInt(temp));
				if (set.containsKey(lesser.toString()) == false)
				{
					HashSet<String> n = new HashSet<String>();
					n.add(greatr.toString());
					set.put(lesser.toString(), n);
				}
				else
				{
					HashSet<String> n = set.get((String)lesser.toString());
					n.add(greatr.toString());
					set.put(lesser.toString(),n);
				}
			}
			
		}
	}

}
