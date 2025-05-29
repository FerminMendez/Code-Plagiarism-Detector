
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class prob2sol {

	
	public static void main(String[] args) {
		
		
	    
	    BufferedReader in;
	    String line;
	    PrintWriter out;
	   
	    // Inputting File.
		try {
			in = new BufferedReader(new FileReader("C:\\Users\\imumair\\Desktop\\B-small-attempt0.in"));
			
			
			int i = Integer.parseInt( in.readLine() );
			ArrayList<String> outputlist = new ArrayList<String>();

			
			String outstring = "";
			
			String initstring = "" ;
			
		    int count = 1 ; 
		    
		    int resultcount = 0;
			
			while(in.ready() && count <= i){
				
				initstring = "Case #" + count+": " ;
				
				try {
					line = in.readLine();
					
					
					outstring = "";
					
					String[] linearray =   line.split(" ");
					
					resultcount = 0;
					int n = Integer.parseInt( linearray[0]);
					
					int s = Integer.parseInt( linearray[1]); 
					
					int p = Integer.parseInt( linearray[2]);
					
					int diff = 0;
					
					int pp = 3*p;
					
					int inp = 0;
					
					if(n>0){
						for (int j = 3 ; j < linearray.length ; j++  ){
						
							inp =  Integer.parseInt(linearray[j]);
							diff = inp-pp; 
							
							if(inp == pp){
								resultcount++;
							} else if (inp > pp){
								resultcount++;
							} else if (inp < pp){
							    
								if(inp > p){						
								    if (diff > -3 ){
										resultcount++;
									} else if (diff <= -3 && diff >-5 ){
										
										if(s>0){
											resultcount++;
											s--;
										}
									}
								}		
									
								
								
								
							}
							
						
						}
					}
					
					
					
					outstring = initstring+outstring + resultcount;
					
					
					outputlist.add(outstring);
					
					//System.out.println(line);
					
							
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("readline fails!!");
				}
				
				count++;
				
			}
				
			in.close();
			
			
			//Outputting File.
			
            out = new PrintWriter(new FileWriter("C:\\Users\\imumair\\Desktop\\A-small-output.out"));
			if(i >0){
				int k;
				for (k = 0; k < i ; k++){
					out.println(outputlist.get(k));
				}
			}else{
				out.println("");
			}
				
				
			out.close();			
			
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ready Input fails.");
		}
		
	
		
	}
	
	
	
	
	

}
