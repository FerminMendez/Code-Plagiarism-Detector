

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Dance {

    public static String filename = "Input";


    public static void main(String[] args) {


    	try {
	    	Scanner filein = new Scanner(new File(filename+".in"));
	    	PrintWriter fileout = new PrintWriter(new FileWriter(filename+".out"));
	    	int totalCase = filein.nextInt();
	    	filein.nextLine();
	    	Hashtable  map = new  Hashtable();
	    	//------------------------------
	    	int[] f1 = {10,	9,	9,	8,	9,	8,	8,	9,	8,	8,	7,	8,	7,	7,	8,	7,	7,	6,	7,	6,	6,	7,	6,	6,	5,	6,	5,	5,	6,	5,	5,	4,	5,	4,	4,	5,	4,	4,	3,	4,	3,	3,	4,	3,	3,	2,	3,	2,	2,	3,	2,	2,	1,	2,	1,	1,	2,	1,	1,	0,	1,	0,	0,	1,	0,	0,	0};
	    	int[] f2 = {10,	10,	10,	10,	9,	9,	8,	9,	9,	9,	9,	8,	8,	7,	8,	8,	8,	8,	7,	7,	6,	7,	7,	7,	7,	6,	6,	5,	6,	6,	6,	6,	5,	5,	4,	5,	5,	5,	5,	4,	4,	3,	4,	4,	4,	4,	3,	3,	2,	3,	3,	3,	3,	2,	2,	1,	2,	2,	2,	2,	1,	1,	0,	1,	1,	0,	0};
	    	int[] f3 = {10,	10,	10,	10,	10,	10,	10,	9,	9,	9,	9,	9,	9,	9,	8,	8,	8,	8,	8,	8,	8,	7,	7,	7,	7,	7,	7,	7,	6,	6,	6,	6,	6,	6,	6,	5,	5,	5,	5,	5,	5,	5,	4,	4,	4,	4,	4,	4,	4,	3,	3,	3,	3,	3,	3,	3,	2,	2,	2,	2,	2,	2,	2,	1,	1,	1,	0};
	    	int[] tt = {30,	29,	29,	28,	28,	27,	26,	27,	26,	26,	25,	25,	24,	23,	24,	23,	23,	22,	22,	21,	20,	21,	20,	20,	19,	19,	18,	17,	18,	17,	17,	16,	16,	15,	14,	15,	14,	14,	13,	13,	12,	11,	12,	11,	11,	10,	10,	9,	8,	9,	8,	8,	7,	7,	6,	5,	6,	5,	5,	4,	4,	3,	2,	3,	2,	1,	0};
	    	int[] bo = {0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	0};
	    	System.out.println("Added array");

	    	for(int item=1; item<=totalCase; item++) {


				//int cases = filein.nextInt();
				//filein.nextLine();
				fileout.print("Case #" + (item) + ": ");
				System.out.println("------------------------------------------------------------------------");
				System.out.println("Case #" + (item) + ": ");
				System.out.println("------------------------------------------------------------------------");
				String str = filein.nextLine();
				String[] tokens = str.split("\\s");
				System.out.println(tokens.length);
				int N= Integer.parseInt(tokens[0]);
				System.out.println("N"+N);
				int S= Integer.parseInt(tokens[1]);
				System.out.println("S"+S);
				int score= Integer.parseInt(tokens[2]);
				System.out.println("score"+score);
				if(score==0)
				{
					System.out.println("Total Count:P->0--"+N);
				fileout.println(N);
					continue;
				}
				int[] NA=new int[N];
				for(int i =0; i< N ; i++)
				{
					NA[i]=Integer.parseInt(tokens[3+i]);
				}
				Arrays.sort(NA);
				/*
				int tem;
				for( int i = 0; i < NA.length/2; ++i ) {
				tem = NA[i];
				NA[i] = NA[NA.length - i - 1];
				NA[NA.length - i - 1] = tem;
				}
				*/



				int[] ans= new int[N];
				int surprise=0;
				int goal=0;
				int goaly[][] = new int[N][2];
				int goal0=0;
				int goal1=0;
				for (int i =0; i<N; i++)
				{
					int temp=-1;
					int tempVal=-1;
					goaly[i][0]=0;
					goaly[i][1]=0;
					System.out.println("-------------NA[i]-"+NA[i]);
					for(int j=0; j<tt.length;j++)
					{

						if(tt[j]==NA[i])
						{
							if(f1[j]>=score||f2[j]>=score||f3[j]>=score)
							{
								System.out.println("tt[j]-"+tt[j]);

								System.out.println("f1[j]-"+f1[j]);
								System.out.println("f2[j]-"+f2[j]);
								System.out.println("f3[j]-"+f3[j]);
								System.out.println("bo[j]-"+bo[j]);
								System.out.println("----------------------");
							if (bo[j]==0)
							goaly[i][0]=goaly[i][0]+1;
							else
							goaly[i][1]=goaly[i][1]+1;
							}
						}
					}
					if(goaly[i][0]>0)
					goal0++;
					if(goaly[i][1]>0)
					goal1++;
				}

				int counter=0;
				HashMap mapr = new HashMap();
				for(int i=0; i< N; i++)
				{
					if(surprise !=S)
					{
								if(goaly[i][1]>0 && goaly[i][0]==0)
								{
									counter++;
									surprise++;
									mapr.put(i,"Dummy");
								}
					}
				}

				for(int i=0; i< N; i++)
				{

					if(surprise !=S)
					{
								if(goaly[i][1]>0 && goaly[i][0]>0)
								{
														counter++;
														surprise++;
														mapr.put(i,"Dummy");
								}
					}
				}

				for(int i=0; i< N; i++)
				{

					if( !mapr.containsKey(i))
					{
								if(goaly[i][0]>0 )
								{
														counter++;
								}
					}
				}


				System.out.println("Total Count"+counter);
				fileout.println(counter);


	    	}

	    	filein.close();
	    	fileout.close();
       	}
       	catch(IOException e) {
       		System.out.println("Error loading input or output file");
       	}
    }
}

