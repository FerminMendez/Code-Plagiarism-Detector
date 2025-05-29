
import java.util.*;
import java.io.*;
import java.lang.*;

public class RQQ2 {
	
	public static void main(String[] args)
	{
		try
		{
			HashMap<Character,Character> map = new HashMap<Character,Character>();
			Scanner s = new Scanner(new File("B-small-attempt0.in"));
			FileWriter o = new FileWriter(new File("out.txt"));
			
			Integer lines = Integer.parseInt(s.nextLine());
			String str;
			Integer sup;
			Integer googlers;
			Integer p;
			StringTokenizer st;
			
			for (int i = 0; i < lines; i++)
			{
				o.write("Case #" + ( i + 1) + ": ");
				str = s.nextLine();
				st = new StringTokenizer(str, " ");
				googlers = Integer.parseInt(st.nextToken());
				sup = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				int even = 0;
				int max = 0;
				
				for (int j = 0; j < googlers; j++)
				{
					int total = Integer.parseInt(st.nextToken());
					if ( Math.ceil((double)total / 3.0) >= p )
					{
						max++;
					}
					else if ( total != 0 && Math.ceil((double)total/3.0 + 2.0/3.0) >= p)
					{
						even++;
					}
				}
				max += Math.min(even, sup);
				o.write("" + max + "\n");
			}
			
			s.close();
			o.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}
	}
}
