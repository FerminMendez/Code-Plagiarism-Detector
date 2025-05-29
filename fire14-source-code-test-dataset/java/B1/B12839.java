/**
 * @(#)test.java
 *
 * test application
 *
 * @author
 * @version 1.00 2012/4/13
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class test {

    public static void main(String[] args) {


    	try
    	{
    		FileInputStream fstream = new FileInputStream ("B-small-attempt1.in");
    		DataInputStream in = new DataInputStream(fstream);
     		BufferedReader br = new BufferedReader(new InputStreamReader(in));


			int T = Integer.parseInt (br.readLine()+"");
			String [] line = new String[T];
			String [] temp;
			int [] numbers;
			int numdancers = 0;
			int surprising = 0;
			int compare = 0;
			if (T>100)T=100;
			for (int i = 0; i<T; i++)
			{
				line[i] = br.readLine()+"";
				temp = line[i].split(" ");
				if (temp.length>33)
					numbers = new int[33];
				else
					numbers = new int[temp.length];
				for (int j = 0; j<numbers.length; j++)
					numbers[j] = Integer.parseInt (temp[j]);

				numdancers = numbers[0]; //Total number of dancers (and total scores)
				if (numdancers>3)numdancers=3;
				surprising = numbers[1]; //Number of surprising cases
				if (surprising>numdancers)surprising = numdancers;
				compare = numbers[2]; //Find number of googlers that have a best result >= compare
				if (compare>10)compare = 10;

				int specialcombo = 0;
				int counter = 3;
				int[] scores = new int[3];
				int casenum = 0;
				int max;
				int one;
				int prevmax;
				int prevcombo;
				boolean match = false;

				while (counter<numbers.length)
				{
					one = numbers[counter];
					prevmax = 0;
					prevcombo = 0;
					specialcombo = 0;
					while (one>=0)
					{

							max = 0;
							if ((one+(one)+(one-1))==numbers[counter])//1 1 0 normal
							{
								match = true;

								//System.out.println ((one+"+"+(one)+"+"+(one-1))+"="+(one+(one)+(one-1)));
								scores[0] = one;
								scores[1] = one;
								scores[2] = one-1;
								if (scores[0]>max) max = scores[0];
								if (scores[1]>max) {max = scores[1];}
								if (scores[2]>max) {max = scores[2];}
								if (max>=compare && prevmax==0)
								{
									casenum++;
									prevmax = max;

								}
								//System.out.println (casenum);

							}
							else if ((one+(one-1)+(one-1))==numbers[counter])//0 0 1 normal
							{
									match = true;

								//System.out.println ((one+"+"+(one-1)+"+"+(one-1))+"="+(one+(one-1)+(one-1)));
								scores[0] = one;
								scores[1] = one-1;
								scores[2] = one-1;
								if (scores[0]>max) max = scores[0];
								if (scores[1]>max) {max = scores[1];}
								if (scores[2]>max) {max = scores[2];}
								if (max>=compare && prevmax==0)
								{
								casenum++;
								prevmax = max;


								}
								//System.out.println (casenum);

							}

							else if (((one)+(one)+(one+2))==numbers[counter]) //1 1 3 surprising
							{
									match = true;


								//System.out.println (((one)+"+"+(one)+"+"+(one+2))+"="+((one)+(one)+(one+2)));

								specialcombo++;
								scores[0] = one;
								scores[1] = one;
								scores[2] = one+2;
								if (scores[0]>max) max = scores[0];
								if (scores[1]>max) max = scores[1];
								if (scores[2]>max) max = scores[2];
								if (max>=compare && prevmax==0 && specialcombo<=surprising)
								{
								casenum++;
								prevmax = max;

								}
								//System.out.println (casenum);

							}
							else if (((one-1)+(one-2)+(one))==numbers[counter]) //1 2 3 //surprising
							{
								match = true;

								specialcombo++;
								//System.out.println ((one+"+"+(one-2)+"+"+(one-1))+"="+(one+(one-2)+(one-1)));

								scores[0] = one-1;
								scores[1] = one-2;
								scores[2] = one;
								if (scores[0]>max) max = scores[0];
								if (scores[1]>max) max = scores[1];
								if (scores[2]>max) max = scores[2];
								if (max>=compare && prevmax==0 && specialcombo<=surprising)
								{
								casenum++;
								prevmax = max;

								}
								//System.out.println (casenum);

							}


							else if (((one-1)+(one)+(one))==numbers[counter]) //0 1 1
							{
								match = true;


								//System.out.println ((one+"+"+(one-1)+"+"+(one))+"="+(one+(one-1)+(one)));

								scores[0] = one-1;
								scores[1] = one;
								scores[2] = one;
								if (scores[0]>max) max = scores[0];
								if (scores[1]>max) max = scores[1];
								if (scores[2]>max) max = scores[2];
								if (max>=compare && prevmax==0)
								{
								casenum++;
								prevmax = max;
								}
								//System.out.println (casenum);

							}
							else if ((one+one+one)==numbers[counter])//1 1 1 normal
							{
								match = true;

								//System.out.println ((one+"+"+(one)+"+"+(one))+"="+(one+(one)+(one)));
								scores[0] = one;
								scores[1] = one;
								scores[2] = one;
								if (scores[0]>max) max = scores[0];
								if (scores[1]>max) {max = scores[1];}
								if (scores[2]>max) {max = scores[2];}
								if (max>=compare && prevmax==0)
								{
								casenum++;
								prevmax = max;

								}
								//System.out.println (casenum);

							}

							one--;




					}


					counter++;
					match = false;

				}

				System.out.println ("Case #"+(i+1)+": "+casenum);
			}



		}
    	catch(Exception e){System.out.println (e);}
    }
}
