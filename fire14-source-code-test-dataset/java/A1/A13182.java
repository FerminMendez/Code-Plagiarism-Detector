
/**
 * @(#)gcjB.java
 *
 *
 * @author
 * @version 1.00 2012/4/14
 */
import java.io.*;
public class gcjB {

    /**
     * Creates a new instance of <code>gcjB</code>.
     */
    public gcjB() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here






        int lineCount;
		String[] lines;
		try
		{


			BufferedReader in = new BufferedReader(new FileReader("B.in"));
			PrintWriter out = new PrintWriter(new FileWriter("B.out"));
			String text = in.readLine();
			lineCount = Integer.parseInt(text);
			lines = new String[lineCount];



		int x =0, y =0, z =0, sup =0;

        Integer[] maxs = new Integer[100];
        Integer[] maxws = new Integer[100];
        Integer matrix[][]  = new Integer[100][2];

        String surp = new String("");
        String norm = new String("");
        for(int i = 0; i < 100 ; i ++)
        {
        	maxs[i] = 0;
        	maxws[i] = 0;
			for(x=10;x>=0;x--)
			{
				for(y=x; y>=0;y--)
				{
					for(z=y;z>=0;z--)
					{
						if((x+y+z) == i)
						{
							if(delta(x, y, z) == 1)
							{
								//ah! surprized
								maxs[i] = java.lang.Math.max(maxs[i], maxi(x, y, z));
							}
							else if(delta(x, y, z) == 2)
							{
								//eh, not surprized
								maxws[i] = java.lang.Math.max(maxws[i], maxi(x, y, z));
							}
							else
							{
								//don't care
							}
						}
						else
						{
							//don't care
						}
					}
				}
			}

			matrix[i][0] = maxs[i];
			matrix[i][1] = maxws[i];
        }



			int Ng = 0 ;
			int Spz = 0;
			int NgMax = 0;

			int sx = 0;

			int MaxGo = 0;

			for(sx = 0; sx < lineCount; sx++)
			{
				String[] whatIsLeft;
				lines[sx] = in.readLine().trim();

				whatIsLeft = lines[sx].split(" ");

				Ng = Integer.parseInt(whatIsLeft[0]);
				Spz = Integer.parseInt(whatIsLeft[1]);
				NgMax = Integer.parseInt(whatIsLeft[2]);



				for(int i=3;i<whatIsLeft.length;i++)
				{
					if(Spz > 0)
					{
						if(matrix[Integer.parseInt(whatIsLeft[i])][1] >= NgMax)
						{
							MaxGo++;
						}
						else if(matrix[Integer.parseInt(whatIsLeft[i])][0] >= NgMax)
						{
							Spz--;
							MaxGo++;
						}
					}
					else
					{
						if(matrix[Integer.parseInt(whatIsLeft[i])][1] >= NgMax)
						{
							MaxGo++;
						}
					}

				}

				out.print("Case #"+(sx+1)+": "+MaxGo);
				if(sx < lineCount-1)
				{
					out.println();
				}
				MaxGo=0;
			}

			in.close();
			out.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    }

    public static int delta(int x, int y, int z)
    {
    	if((java.lang.Math.abs(x-y) < 3) && ((java.lang.Math.abs(y-z)) < 3) && (java.lang.Math.abs(z-x) < 3))
    	{
	    	if((java.lang.Math.abs(x-y) ==2) || ((java.lang.Math.abs(y-z)) ==2) || (java.lang.Math.abs(z-x) ==2))
	    	{
	    		return 1;
	    	}
	    	else if((java.lang.Math.abs(x-y) < 2) || ((java.lang.Math.abs(y-z)) < 2) || (java.lang.Math.abs(z-x) < 2))
	    	{
	    		return 2;
	    	}
	    }
    	return 0;
    }
    public static int maxi(int x, int y, int z)
    {
     	int maxim = x;
     	maxim = java.lang.Math.max(maxim, y);
     	maxim = java.lang.Math.max(maxim, z);

     	return maxim;
    }
}
