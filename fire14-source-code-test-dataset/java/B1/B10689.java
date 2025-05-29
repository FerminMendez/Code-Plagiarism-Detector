import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * C
 */

/**
 * @author devang
 *
 */
public class RecycledNumbers {

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		int n = 0;
		String input[] = null;
		int A, B = 0;
		List recycledNumbers = null;
		
		File f = new File("//home//devang//Desktop//C-small-attempt0.in");
		//File f = new File("//home//devang//Desktop//input");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		
		String testcases = reader.readLine();
		n = Integer.parseInt(testcases);
		
		FileWriter fw = new FileWriter("//home//devang//Desktop//output");
		
		for(int i = 0; i < n; i++)
		{
			int count = 0;
			input = reader.readLine().split(" ");
			if(input[0].length() == 1)
			{
				//Do not increment count.
			}
			else
			{
				A = Integer.parseInt(input[0]);
				B = Integer.parseInt(input[1]);
				HashMap record = new HashMap();
				
				recycledNumbers = getRecycledNumbers(input[0], input[1]);
				int j = 0;
				int a = A;
				int subtract = 0;
				for(;j < B - A + 1; j++)
				{
					//iterate over list.
					for(int k = (j * (input[0].length() - 1)), l = 0; l < input[0].length() - 1; k++, l++)
					{
						String m = (String)recycledNumbers.get(k);
						if(m.length() == input[0].length() && Integer.parseInt(m) > a && Integer.parseInt(m) <= B)
						{
							List list = (List)record.get(String.valueOf(a));
							if(list != null && !list.contains(m))
							{
								list.add(m);
								count++;
							}
							else if(list == null)
							{
								list = new ArrayList();
								list.add(m);
								record.put(String.valueOf(a), list);
								count++;
							}
							else if(list.contains(String.valueOf(a)))
								;//Do nothing.
						}
					}
					a++;
				}
			}
			/*System.out.print("Case #"+(i+1)+": "+count+"\n");*/
			fw.write("Case #"+(i+1)+": "+count+"\n");
		}
		
		reader.close();
		fw.close();
	}

	@SuppressWarnings("unchecked")
	private static List getRecycledNumbers(String A, String B)
	{	
		List l = new ArrayList();
		int a, b, diff = 0;
		StringBuilder builder = new StringBuilder(A.length());
		short numberOfRecycledNumbers = (short)(A.length() - 1);
		a = Integer.parseInt(A);
		b = Integer.parseInt(B);
		diff = b - a + 1;
		//Do it for each number in the range A to B.
		for(int j = 0; j < diff; j++)
		{
			A = String.valueOf(a + j);
			for(short i = 0; i < numberOfRecycledNumbers; i++)
			{
				char first = A.charAt(0);
				builder.insert(0, A.substring(1));
				builder.insert(A.length() - 1, first);
				if(builder.length() > A.length())
				{
					//suppress all the un-required characters.
					builder.replace(A.length(), builder.length(), "");
				}
				A = builder.toString();
				l.add(builder.toString());
			}
		}
		
		return l;
	}
}
