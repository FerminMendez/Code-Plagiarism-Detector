import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Recycled { 
	
	HashMap<Integer, String> map; //key is the number, value is the sorted number in string form
	HashMap<Integer, Integer> digits; //key is the number, value is the sorted number in string form
	
 	public static void main(String[] arg) throws Exception {
 		Recycled pg = new Recycled();
	 
 		pg.init();
		 pg.go();
	}
 	
 	Recycled()
	{
 	 map = new HashMap<Integer, String>();
 	 digits = new HashMap<Integer, Integer>();
	}
 	
 	private void init()
 	{
 		int arr[] = {0,0,0,0,0,0,0,0,0,0};
 		int rem;
 		StringBuilder str = new StringBuilder();
 		int i; 
 		int digits;
 		for(int no = 1 ; no <= 2000000; no++)
 	     {
 			i = no;
 			digits  = 0;
 			while(i > 0)
 			{
 				rem = i % 10;
 				arr[rem]++;
 				i = i / 10; 
 				digits++;
 			}
 			
 			str.delete(0, str.length());
 			for(int j = 0; j < arr.length; j++)
 			{
 				while(arr[j] > 0)
 				{
 					str.append(j);
 					arr[j]--;
 				}
 			}
 			
 			map.put(no, str.toString());
 			this.digits.put(no, digits);
 	    	//reset the array
 	     }
 		//System.out.println("Done initialization");
 	}
 	
  	public void go()
	{
 		String line = "";
			try {
			    BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
			     
			    StringBuilder outString = new StringBuilder();
			    StringTokenizer tokens;
			    
	             
	            int caseNo = 0;
	             
	            int T = Integer.parseInt(in.readLine().trim());
	            int A,B, high;
	            String s1, s2;
	            int count;
	            while(caseNo++ < T)
	            {
 	              line = in.readLine().trim();
 	              tokens = new StringTokenizer(line);
 	              A = Integer.parseInt(tokens.nextToken().trim());
 	              B = Integer.parseInt(tokens.nextToken().trim());
 	              
 	             count = 0;
 	              for(int n = A; n < B; n++)
 	              {
 	            	  high = (int)Math.pow(10,digits.get(n)) - 1;
 	            	  high = Math.min(high, B);
 	            	  for(int m = n + 1; m <= high; m++)
 	            	  {
 	            		  s1 = map.get(n);
 	            		  s2 = map.get(m);
 	            		  if(!s1.equals(s2))
 	            			  continue;
 	            		  
 	            		  if((n + "" + n).indexOf(m+"") != -1)
 	            		  {
 	            			  count++;
// 	            			  System.out.println(" Pairs (" +n + " " +m + ")"); 	            			  
 	            		  }
 	            		  
 	            	  }
 	              }
            	  
 	             outString.append("Case #" + caseNo + ": " +count ); 	               
	             
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
