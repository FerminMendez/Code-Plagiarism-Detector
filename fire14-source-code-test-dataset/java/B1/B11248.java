import java.util.*;
import java.io.*;

public class Recycled
{
	public static void main(String[] sArgs)throws IOException
	{
		Scanner oScan = new Scanner(new File("recycled.in"));
		PrintWriter out = new PrintWriter("recycled.out");

		int o_0 = oScan.nextInt();oScan.nextLine();
		for(int o_o=1;o_o<=o_0;o_o++)
		{
			int A = oScan.nextInt(),B=oScan.nextInt();
			int count=0,base=0;
			for(int i=1;i<=A;i*=10)base+=i;
			for(int i=A;i<B;i++)
			{
				String s = new String(i+"");
				ArrayList<Integer> nums = new ArrayList<Integer>();
				if(i%base==0)
				{
					//System.out.println("same "+i);
					continue;
				}
				for(int j=1;j<s.length();j++)
				{
					String newS = s.substring(j)+s.substring(0,j);
					if(newS.charAt(0)=='0')continue;
					int rec = new Integer(newS);
					if(rec>i&&rec<=B&&!nums.contains(rec)){count++;nums.add(rec);}
				}
			}
			out.println("Case #"+o_o+": "+count);
		}

		out.close();
	}
}