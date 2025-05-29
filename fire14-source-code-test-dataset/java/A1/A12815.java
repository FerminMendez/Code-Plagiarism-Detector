import java.io.BufferedWriter;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigInteger;


public class Dancing 
{
	public static void main(String args[])
	{
		String filename = "C://in.txt";
		int i=0,j=0;
		int testcase=0 ;
		String out="";
		BufferedWriter bufferedWriter = null;
		try { BufferedReader in = new BufferedReader(new FileReader(filename));
		String str;
		str = in.readLine();
		testcase = Integer.parseInt(str);
		
		//Construct the BufferedWriter object
		bufferedWriter = new BufferedWriter(new FileWriter("oneoutput3.wpd"));
		for (i=0;i <testcase; i++)
		{
			int N=0,S=0,P=0;
			int[] t=new int[10000000];
			str = in.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			System.out.println(st);
			N = Integer.parseInt((String)st.nextElement());
			S = Integer.parseInt((String)st.nextElement());
			P = Integer.parseInt((String)st.nextElement());

			System.out.println("N="+N+" S="+S);
			for (j=0;j<N;j++)
				t[j] = Integer.parseInt((String)st.nextElement());
			
		//declare data structures here
					String ou1="";
  	int maxwinner=-1;
		int nowinner=0; 
  		
  		int surp_reqd=0;
			int[][] score= new int[N][3]; 	    
			   // initialize with non surprizes
				for ( j=0;j<N;j++)
				{
					
				if(t[j]%3 ==0  )
				{
					score[j][0]=t[j]/3;
					score[j][1]=t[j]/3;
					score[j][2]=t[j]/3;
					
					
					if (P==score[j][2]+1 &&t[j]>0)
						surp_reqd++;
					if (P<=score[j][2])
						nowinner++;
					
				}
				if(t[j]%3 ==1 )
				{
					score[j][0]=t[j]/3;
					score[j][1]=t[j]/3;
					score[j][2]=(t[j]/3)+1;
					
					if (P<=score[j][2])
						nowinner++;
				}
				if(t[j]%3 ==2 )
				{
					score[j][0]=t[j]/3;
					score[j][1]=(t[j]/3)+1;
					score[j][2]=(t[j]/3)+1;
					
					if (P==score[j][2]+1)
						surp_reqd++;
					if (P<=score[j][2])
						nowinner++;
				}
			 	  System.out.println ("score["+j+"]="+score[j][0]+","+score[j][1]+","+score[j][2]);
				   		
				}
				
			System.out.println ("surp_reqd="+surp_reqd);
			System.out.println ("nowinner="+nowinner);
		    if (S>=surp_reqd)
		    	maxwinner=nowinner+surp_reqd;
		    else
		    	maxwinner=nowinner+S;
       
          
			
			out="Case #"+(i+1)+": ";
			
				out += maxwinner+"\n";
				
				System.out.println ("out ="+out);
				
			bufferedWriter.write(out);
			
		}
		in.close(); } 
		catch (IOException ex) {               ex.printStackTrace();} 
		finally {
			//Close the BufferedWriter
			try {
				if (bufferedWriter != null) {
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
