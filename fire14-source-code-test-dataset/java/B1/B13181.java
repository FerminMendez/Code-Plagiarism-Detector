/**
 * @(#)Googlerese.java
 *
 *
 * @author Evan Forbes
 * @version 1.00 2012/4/13
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class Recycle {

	static int caseNum=0;
	static int numCases;

    public static void main(String[] args)
    {
    	try{
	    	Scanner in=new Scanner(new FileReader("C-small-attempt3.in"));
	    	//Scanner in=new Scanner(new FileReader("sample_recycled.txt"));
	   		while (in.hasNextLine()) //go through all lines of file
			{
				String current=in.nextLine();
				String output="";
				if (caseNum==0)
				{
					numCases=Integer.parseInt(current);
				}
				else
				{
					output="Case #"+caseNum+": ";
					int mode=0;
					String As=""; //number of scores
					int A=0;
					String Bs=""; //num of suprising scores
					int B=0;

					for (int i=0;i<current.length();i++)
					{
						char currentChar=current.charAt(i);
						switch(mode)
						{
							case 0:
								if (currentChar==' ')
								{
									mode++;
									A=Integer.parseInt(As);
								}
								else
									As=As+currentChar;
							break;
							case 1:
								Bs=Bs+currentChar;
						}
					}
					B=Integer.parseInt(Bs);
					//System.out.println("A: "+A+" B: "+B);
					int count=0;
					if (A==B) count=0;
						else
						{
							for (int n=A;n<(B-1);n++)
							{

								for (int m=n+1;m<=B;m++)
								{
									//System.out.println("Testing: "+n+", "+m);
									if (isRecycled(n,m)) count++;
								}
							}
						}


					System.out.println(output+count);
				}
				caseNum++;
			}
    	}
		catch(IOException ex){
		}
		//System.out.println(isRecycled(12345,34512));
    }
	static boolean isRecycled(int in, int im)
	{
		boolean found=false;
		String n=in+"";
		String m=im+"";
		for (int i=n.length()-1;i>0;i--)
		{
			String cut=n.substring(i);
			String compare=cut+n.substring(0,i);
			//System.out.println("cut: "+cut+" compare: "+compare);
			if (compare.equals(m)) found=true;
		}
		return found;
	}

}