import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;


public class Googlers {

	private static int testcases = 0;
	
	public static void main(String[] args)
	{
		String DataLine = "";
		int line = 0;
		PrintWriter out;
		
		try
		{
	      File inFile = new File("./config/B-small-attempt1.txt");
	      BufferedReader br = new BufferedReader(new InputStreamReader(
	          new FileInputStream(inFile)));
	      
	      out = new PrintWriter(new BufferedWriter(new FileWriter("./config/out3" + ".txt")));
         
	      while((DataLine = br.readLine()) != null)
	      {
	   
	    	  if(line == 0)
	    	  {
	    		  testcases = Integer.parseInt(DataLine.trim());
	    		  line++;
	    	  }
	    	  else
	    	  {
	    		  if(line<=testcases)
	    		  {
	    			  String[] datas = DataLine.split(" ");
	    			 
	    			  int N = Integer.parseInt(datas[0]);
	    			  int S = Integer.parseInt(datas[1]);
	    			  int P = Integer.parseInt(datas[2]);
	    			  int[] pnts = new int[N];
	    			  for(int i=0;i<N;i++)
	    				  pnts[i] = Integer.parseInt(datas[2+i+1]);
	    			  
	    			  int reslt = getResult(N, S,P,pnts);
	    			  out.write("Case #"+line+": "+reslt+"\n");
	    			  System.out.println("Case #"+line+": "+reslt+"\n");
	    			  line++;
	    		  }
	    		 
	    	  }
	    	
	      }
	      
	      br.close();
	      out.close();
	      
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		
		
	}
	
	private static int getResult(int N,int S,int P,int[] pnts)
	{
		int resCount = 0;
		int temp = 0;
		
		System.out.println("N:S:P::"+N+":"+S+":"+P);
		
		if(P==0)
			return N;
		
		for(int j=0;j<N;j++)
		{
			int check = pnts[j];
			if(temp < S && P > 1)
			{
	
				if(((P-2)*3)+2 <= check )
				{
					resCount++;
					
					if(((P-2)*3)+2 == check || ((P-2)*3)+2 == check-1)
						temp++;
				}
			}
			else
			{
				if(((P-1)*3)+1 <= check )
					resCount++;
			}
		}
		return resCount;
	}
}
