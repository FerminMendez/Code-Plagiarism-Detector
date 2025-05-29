import java.io.*;
import java.math.*;

public class Dance {
	public void cal(String filename) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bar.txt")));
		int count = 1;
		String s = in.readLine();
		int all = Integer.parseInt(s);
		while((s = in.readLine()) != null)
		{
			int result = 0;
			if(count > all)
				break;
			String[] elements = s.split(" ");
			int dancer_num = Integer.parseInt(elements[0]);
			int surprise_num = Integer.parseInt(elements[1]);
			int least = Integer.parseInt(elements[2]);
			for(int i = 0; i < dancer_num; i++)
			{
				if( 3 + i >= elements.length)
					break;
				int data = Integer.parseInt(elements[3 + i]);
				if(data <= 30 && data>=0)
				{
				    if(data / 3 >= least)
					    result = result + 1;
				    else
				    {
				    	int second = (data - least) / 2;
				    	int third = data - second - least;
				    	if(Math.abs(least - second) <= 1 &&Math.abs(least - third) <= 1)
				    	{
				    		if(second >= 0 && third >= 0)
				    		    result = result + 1;
				    	}
				    	else if(Math.abs(least - second) <= 2 &&Math.abs(least - third) <= 2)
				    	{
				    		if(surprise_num > 0 && second >= 0 && third >= 0)
				    		{
				    			result = result + 1;
				    			surprise_num = surprise_num - 1;
				    		}
				    	}
				    	else
				    	{}					
				    }
				}
			}
			out.println("Case #" + count +": " + result);
			count = count + 1;
		}
		out.close();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Dance d = new Dance();
		d.cal("B-small-attempt0.in");
	}

}
