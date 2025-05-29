import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Dancing { 
	
	
 	public static void main(String[] arg) throws Exception {
 		Dancing pg = new Dancing();
	 
		 pg.go();
	}
 	
 	Dancing()
	{
 	 
 
	}
 	

 	private int addThisScore(int totalPoints, int p)
 	{
 		int avg = totalPoints / 3;
 		int low = Math.max(0,  avg - 2);
 		int high = Math.min(10, avg + 2);
 		int bestResult;
 		
 		int S, NS;
 		S = 0;
 		NS = 0;
 	
 		for(int i = low; i <=high; i++)
 		{
 			for(int j = low; j <=high; j++)
 	 		{
 				for(int k = low; k <=high; k++)
 		 		{
 		 			if((i + j + k) != totalPoints)
 		 				continue;
 		 			
 		 			if(Math.abs(i-j) > 2 || Math.abs(j-k) > 2 || Math.abs(i-k) > 2)
 		 				continue;
 		 			
 		 			bestResult = Math.max(Math.max(i, j),k);
 		 			if(bestResult < p)
 		 				continue;
 		 				
 		 			//System.out.println("Triplet = " +i +" "+j +" "+k);
 		 			
 		 			if(bestResult >= p)
 		 			{
 		 				//is this a surprising triplet
 		 				if(Math.abs(i-j) == 2 || Math.abs(j-k) == 2 || Math.abs(i-k) == 2)
 		 				{
 		 					S = 2;
 		 				}
 		 				else
 		 				   NS = 1;
 		 			}
 		 			
 		 		}
 	 			
 	 		}
 			
 		}
 		return S + NS;
 	}
 	public void go()
	{
 		String line = "";
			try {
			    BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
			     
			    StringBuilder outString = new StringBuilder();
			    StringTokenizer tokens;
			    
	             
	            int caseNo = 0;
	             
	            int T = Integer.parseInt(in.readLine().trim());
	            int N, S, p, t;
	            int totalGooglers;
	            int totalSurprisingTriplets;
	            while(caseNo++ < T)
	            {
 	              line = in.readLine().trim();
 	              totalGooglers = 0;
 	              totalSurprisingTriplets = 0;
 	              tokens = new StringTokenizer(line);
 	              N = Integer.parseInt(tokens.nextToken().trim());
 	              S = Integer.parseInt(tokens.nextToken().trim()); //noof surprises
 	              p = Integer.parseInt(tokens.nextToken().trim());
 	              int res;
 	              while(N > 0)
 	              {
 	            	  t = Integer.parseInt(tokens.nextToken().trim());
 	            	// System.out.println("**** " + t +" ****");
 	            	  res = addThisScore(t, p);
 	            	 
 	            	  if(res != 0)
 	            	  {
 	            		  if(res == 2)
 	            		  {
 	            			  totalSurprisingTriplets++;
 	            		  }
 	            		  else
 	            		    totalGooglers++;
 	            	  }
 	            	  N--;
 	              }
 	              if(S < totalSurprisingTriplets)
 	              {
 	            	 totalSurprisingTriplets = S; 	            	  
 	              }
 	              
 	             totalGooglers +=  totalSurprisingTriplets;
            	  
 	             outString.append("Case #" + caseNo + ": " + totalGooglers); 	               
	             
	              outString.append("\n");
	            }
	  		    BufferedWriter pwr = new BufferedWriter(new FileWriter("output.txt"));
			    pwr.write(outString.toString());
			    pwr.close();		    
			    in.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println("processing : " + line);
			}
	}
}
