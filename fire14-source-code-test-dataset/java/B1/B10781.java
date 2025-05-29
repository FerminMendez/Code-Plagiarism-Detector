import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class TestJAM
{
	public static void main (String[] args)
	{
/*		String nStr1 = "12";
		int numswindex1 = ;
		String nsw1 = nStr1.substring (numswindex1) + nStr1.substring (0, numswindex1);		
		System.out.println (nStr1.substring (numswindex1));
		System.out.println (nStr1.substring (0, numswindex1));
		System.out.println (nsw1);
		if (1==1) return;
*/		
		BufferedReader br = null;
		PrintStream ps = null;
		
		try
		{
			int a;
			int b; 
			int t;
			int count;
			String nStr;
			String mStr;
			String nsw;
			String line;
			StringTokenizer st;
			
			br = new BufferedReader (new FileReader ("C-small-attempt0.in"));
			ps = new PrintStream (new FileOutputStream ("C-small-attempt0.out"));
						
			line = br.readLine ();
			t = Integer.parseInt (line);
			
			for (int testCase = 0; testCase < t; testCase++)
			{
				count = 0;
				line = br.readLine ();
				st = new StringTokenizer (line);
				a = Integer.parseInt (st.nextToken ());
				b = Integer.parseInt (st.nextToken ());
				
				for (int n = a; n <= b; n++)
				{
					for (int m = n + 1; m <= b; m++)
					{
						nStr = String.valueOf (n);
						mStr = String.valueOf (m);
						
						int nlen = nStr.length ();
						int mlen = mStr.length ();

						if (nlen == mlen)
						{
							for (int numswindex = 0; numswindex < nlen; numswindex++)
							{
								nsw = nStr.substring (numswindex) + nStr.substring (0, numswindex);
								if (nsw.equalsIgnoreCase (mStr))
								{
									count++;
									break;
								}
							}
						}
						else if (nlen > mlen)
						{
							break;
						}
					}
				}
				
				ps.println ("Case #" + (testCase + 1) + ": " + count);

//				System.out.println (count);
			}
						

//			ps.println ("test1 test1 test1");
			
//			System.out.println ("Hola Mundo!!!");			
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace ();
		}
		catch (NumberFormatException nfe)
		{
			nfe.printStackTrace ();
		}
		finally
		{
			if (ps != null)
			{
				ps.close ();
			}
			if (br != null)
			{
				try
				{
					br.close ();					
				}
				catch (IOException ioe)
				{
					ioe.printStackTrace ();
				}
			}
		}
	}	
}




