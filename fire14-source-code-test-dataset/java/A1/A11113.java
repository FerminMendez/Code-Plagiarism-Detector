import java.util.*;
import java.lang.*;
import java.io.*;

class googler
{
    public static void main(String args[])
    {
	try
	{
	    PrintWriter pw=new PrintWriter("out.txt"); 
	    //creating file reader instance and reading first line
	    BufferedReader br=new BufferedReader(new FileReader(args[0]));
	    String line=br.readLine();
	    int T=Integer.parseInt(line); //number of test cases T
	    //-------------------------
	    for(int i=0;i<T;++i)
	    {
		String[] testcase=br.readLine().split(" ");
		int N = Integer.parseInt(testcase[0]);
		int S = Integer.parseInt(testcase[1]);
		int p = Integer.parseInt(testcase[2]);
		if(p==0)
		{
		    //System.out.println("Case #"+(i+1)+": " + N);
		    pw.println("Case #"+(i+1)+": " + N);
		    continue;
		}

		int answer=0;
		for(int j=1;j<=N;++j)
		{
		    int total=Integer.parseInt(testcase[2+j]);
		    if(total==0)
			continue;
		    int x=total/3;
		    //if(x>=p)
		    //{
		    //	answer++;
		    //	continue;
		    //}
		    int modulo=total%3;
		    switch(modulo)
		    {
		    case 0:
			if(x>=p)
			{
			    answer++;
			}
			else if((x+1)>=p && S>0)
			{
			    answer++;
			    S--;
			}
			break;
		    case 1:
			if((x+1)>=p)
			    answer++;
			break;
		    case 2:
			if((x+1)>=p)
			{
			    answer++;
			}
			else if((x+2)>=p && S>0)
			{
			    answer++;
			    S--;
			}
			break;
		    }//end switch
		}

       		//System.out.println("Case #"+(i+1)+": " + answer);

		pw.println("Case #"+(i+1)+": " + answer);
		/*------------------------**/
	    }
	    br.close();
	    pw.close();
	}//end of try
	catch(Exception e)
	{
	    System.out.println("Exception caught: "+e);
	}	
   } 
}