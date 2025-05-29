import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class googleDancers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lstInt = new ArrayList<Integer>();
		boolean error_ni = false;
		try{
			 FileReader fr=new FileReader("B-small-attempt11.in"); 
		
			 BufferedReader  br = new BufferedReader (fr);
		     int numCases = Integer.parseInt(br.readLine());
		     BufferedWriter bw = new BufferedWriter(new FileWriter(new File("solution.txt")));
		     int i;
		     

		     for(i=1; i<=numCases; i++ ){
		    	 String linea = new String(br.readLine());
		    	 StringTokenizer palabraSeparation = new StringTokenizer(linea);
		    	 lstInt.clear();
		    	 int N = Integer.parseInt(palabraSeparation.nextToken());
		    	 int S = Integer.parseInt(palabraSeparation.nextToken());
		    	 int p = Integer.parseInt(palabraSeparation.nextToken());
		    	 int solution = 0;
		    	 int surprising = 0;
		    	 while(palabraSeparation.hasMoreTokens() != false){
		    		 int num_i = Integer.parseInt(palabraSeparation.nextToken());
		    		 lstInt.add(num_i);
		    		 /*if (num_i > 30)
		    			 error_ni = true;*/
		    	 }
		    
		    	
		    
		    	 if ((S>=0  && S <= N) && (p>= 0 && p <= 10) && error_ni == false){
		    		 if (p==0){
		    			 solution = lstInt.size();
		    		
		    		 }
		    		 else
				    		 for (int j=0; j<lstInt.size(); j++){ 
				    			  
				    			 if (p == 1  ){
				    				 if (lstInt.get(j)>0) solution++;
				    			 }	  
				    			 else if (p*3 <= lstInt.get(j) && lstInt.get(j)!=0 ){
				    				 solution++;
				    			 }
				    			 else if(p*3-2 <= lstInt.get(j) && p>=1 && lstInt.get(j)!=0 ){
				    				 solution++;
				    			 }
				    			 else if(p*3-4 <= lstInt.get(j) && lstInt.get(j) >= 2 && lstInt.get(j)<=28){
				    				 surprising++;
				    			 }
				    			 	 
				    		 }
				    		 if(S >= surprising)
			    				 solution +=surprising;
					    	 else if(S < surprising )
					    		 solution +=S;
				    	 }
				    	 
				    	 
				    	 //System.out.println("Case #" + i+": "+solution);
				    	bw.write("Case #" + i+": "+solution);
				        bw.newLine();
				         
				     }
		     
		 bw.close();
		}catch (Exception e){//Catch exception if any
		    	  System.err.println("Error: " + e.getMessage());
		}
			  
		


	}

}
