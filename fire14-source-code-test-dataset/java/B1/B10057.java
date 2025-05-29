import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ProblemC2 
{
	public boolean checked[];
	public int min, max;
	
	public static void main(String [] args)
	{
		new ProblemC2();
	}
	
	public ProblemC2()
	{
		try
		{
			String inputFile = new String("C-small");
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			PrintWriter	out = new PrintWriter(new FileWriter(inputFile+".out"),true);
				
			int numCases = Integer.parseInt(in.readLine());
			String [] items = null;
			for(int j = 0 ; j < numCases; j++)
			{
				checked = new boolean[2000000];
				items = in.readLine().split("\\s+");
				min = Integer.parseInt(items[0]);
				max = Integer.parseInt(items[1]);
				int total = 0;
				for(int x = min; x <= max; x++)
				{
					if(! checked[x])
						total+=checkRecycled(x);
				}
				out.println("Case #" + (j+1) + ": " + total);
			}
			in.close();
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private int checkRecycled(int x) 
	{
		int matches=1;
		checked[x]=true;
		if(x<10)
			return 0;
		
		int numChecks = 0;
		if(x>=1000000)
			numChecks = 6;
		else if(x>=100000)
			numChecks = 5;
		else if(x>=10000)
			numChecks = 4;
		else if(x>=1000)
			numChecks = 3;
		else if(x>=100)
			numChecks = 2;
		else
			numChecks = 1;
		
		String xstr=new String(""+x);
		int tmp=0;
		for(int i=0; i<numChecks ; i++)
		{
			xstr=xstr.substring(xstr.length()-1)+""+xstr.substring(0,xstr.length()-1);
			if(xstr.startsWith("0"))
				continue;
			tmp = Integer.parseInt(xstr);
			if(x != tmp && checked[tmp] == false &&	tmp >= min && tmp <= max)
				matches++;
			if(tmp<=2000000)
				checked[tmp]=true;
		}
		if(matches == 1)
			return 0;
		else if(matches == 2)
			return 1;
		else if(matches == 3)
			return 3;
		else if(matches == 4)
			return 6;
		else if(matches == 5)
			return 10;
		else if(matches == 6)
			return 15;
		else if(matches == 7)
			return 21;
		
		return 0;
	}
}
