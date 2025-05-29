import java.util.*;
import java.lang.*;
import java.io.*;

class recycle
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
	    //processing each test case
	    for(int i=0;i<T;++i)
	    {
		String[] testcase=br.readLine().split(" ");
		long A = Long.parseLong(testcase[0]);
		long B = Long.parseLong(testcase[1]);
		//System.out.println(A+" "+B); //remove
		int len=1;
		long copyA = A;
		while((copyA=copyA/10) != 0)
		    len++;
		//System.out.println("len is: "+len);
		if(len==1)
		{
		    pw.println("Case #"+(i+1)+": 0");
		    continue;
		}
		long result=0;
		for(long n=A;n<B;++n)
		{
		    int ilen = 1;
		    while(ilen<len)
		    {
			int index = (int)Math.pow(10,ilen);
			int base = (int)Math.pow(10,len-ilen);
			//	System.out.println("index: "+index);
			long last=n % index;
			long m=(last*base)+(n/index);
			//	System.out.println("n="+n+" : m="+m);
			if(m>n && m<=B)
			{
			    result++;
			    //  System.out.println("valid");
			}
			++ilen;
		    }
		}

		//		System.out.println("Case #"+(i+1)+": " + result);

		pw.println("Case #"+(i+1)+": " + result);
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