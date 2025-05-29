package gcj.qualifier;
/**
 * @(#)ProbB.java
 *
 *
 * @author 
 * @version 1.00 2011/5/9
 */

import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
public class ProbB
{

	public FileReader fr;
	public BufferedReader br;

	
    public ProbB(String file, String output)
    {
    	if (output!=null)
			setOut(output);

    	try
    	{
   	    	fr=new FileReader(file);
 	   		br=new BufferedReader(fr);
 	   		
    		int caseNo=parseInt(br.readLine());
    		//out.println(caseNo);
    		for (int i=0; i<caseNo; i++)
    		{
    			String caseAnswer=runCase();
    			out.println("Case #"+ (i+1) + ": " +caseAnswer);
    		}
    		
    	}
    	catch (IOException e)
    	{
    	}

    }

    public void setOut(String output)
    {
		try
    	{
			System.setOut(new PrintStream(output));
		}
    	catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}    	
    }
    
    public String runCase() throws IOException
    {
    	String ss=br.readLine();
    	StringTokenizer st=new StringTokenizer(ss);
    	int t=Integer.parseInt(st.nextToken());
    	int s=Integer.parseInt(st.nextToken());
    	int p=Integer.parseInt(st.nextToken());
    	int [] tt=new int[t];
    	int test=4;
    	if (p>2)
    		test=(p-2)*3;
 //   	out.println();
 //   	out.println(test);
    	int num=0;
    	//double test=((double)p-((double)2/3));

    	int div; int mod;
    	for (int i=0; i<t; i++)
    	{
    		tt[i]=Integer.parseInt(st.nextToken());
    		div=tt[i]/3;mod=tt[i]%3;
    		if (tt[i]>=p)
    		{
        		if (div>=p-2)
        		{
        			if (div>=p || (div==(p-1)&&(mod==2||mod==1)))
        			{
        				num++;
        			}
        			else if (s>0)
        			{
        				if ((div==(p-2)&&mod==2)||(div==(p-1)&&mod==0))
        				{
        					s--;
//        					out.print("*");
        					num++;

        				}
        				
        				
        			}
        			else continue;

/*
            		out.print(tt[i]);
            		out.print(" : ");
            		out.print(tt[i]/3);
            		out.print(" : ");
            		out.print(tt[i]%3);
            		out.print(" : ");
            		out.println();    			    				
  */
        		}
    		}

//    		out.println(p+":::"+tt[i]+":"+tt[i]/3+":"+tt[i]%p);

    		
      		//out.println(tt[i]);
    	}

	
    		//out.println(num);

        	return new Integer(num).toString();
    }
    
    public static void main(String [] args)
    {
    	ProbB gjct=new ProbB("C:/JavaPgms/workspace/codejam/2012/in/qualifier/B-small-attempt3.in", "C:/JavaPgms/workspace/codejam/2012/out/qualifier/B.out");
    }
    
    
    
    
}