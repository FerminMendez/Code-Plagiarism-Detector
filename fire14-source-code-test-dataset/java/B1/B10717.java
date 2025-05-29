import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;


public class Recycled {

	public static void main(String [] args) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new StringReader(args[0]));
		int rows = Integer.parseInt(in.readLine());
		for ( int i = 1; i <= rows; i++)
		{			
			String line = in.readLine();
			String [] tokens = line.split(" ");
			int low = Integer.parseInt(tokens[0]);
			int high = Integer.parseInt(tokens[1]);
			
			int count = 0;
			Set<String> used = new HashSet<String>();
			for ( int j = low; j <= high; j++ )
			{
				String str = Integer.toString(j);
				//System.out.println("Original: " + str);
				for ( int k = 0; k < str.length()-1; k++ )
				{
					String newStr = str.substring(k+1) + str.substring(0,k+1);
					int newInt = Integer.parseInt(newStr); 
					if ( Integer.toString(j).length() == Integer.toString(newInt).length() &&
							
							newInt<=high && 
							!used.contains(j+","+newInt)
							&& !used.contains(newInt+","+j) 
							&& j < newInt )
					{
						count++;
						used.add(j+","+newInt);
					}
				}
			}
			System.out.println("Case #"+i+": " + count);
			//System.out.println(used);
			
			
		}
	}
	
}
