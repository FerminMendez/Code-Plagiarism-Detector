
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class testrun {

	
	public static void main(String[] args) {
		
		
	    
	    BufferedReader in;
	    String line;
	    PrintWriter out;
	   
	    // Inputting File.
		try {
			in = new BufferedReader(new FileReader("C:\\Users\\imumair\\Desktop\\C-small-attempt0.in"));
			
			
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
					int a = Integer.parseInt( linearray[0]);
					
					int b = Integer.parseInt( linearray[1]); 
					
				
					for (int j = a ; j<b ; j++){
					
						ArrayList<Integer>  digitlist = new ArrayList<Integer>();
						
						
						int number = j; // = and int
						
						
						LinkedList<Integer> stack = new LinkedList<Integer>();
						while (number > 0) {
						    stack.push( number % 10 );
						    number = number / 10;
						}
	
						while (!stack.isEmpty()) {
						  digitlist.add(stack.pop());
						}
						
						int numdigits = digitlist.size();
						
						
						
						
						if(numdigits > 1  ){
							
							
    							String comb = "";
							
								 
    							
    							if(allequal(digitlist)){
    							   
    							   resultcount = resultcount + 0;
    							} else {
    							
    							    String prevcomb = "";
    							    
    							    //going throguh all combinations
	    							for (int m = 1 ; m <numdigits; m++) {
										
										comb = "";
										
										for(int m1 = m; m1<numdigits; m1++){
											comb = comb+digitlist.get(m1);
										}
										
										for(int m2 = 0; m2< m ; m2++ ){
											comb = comb + digitlist.get(m2);
										}
									    
										int resultant = Integer.parseInt(comb); 
										
								
									
										
										if( resultant <= b && resultant > j && !prevcomb.equals(comb) ){
											resultcount++;
											prevcomb = comb;
											//System.out.println("( " +j+" , " + comb +" )"  );
										}
										
									
									
									}
								
    							}							

						}
						
						
						
					
					}
					
					
					outstring = initstring+outstring +resultcount;
					
					
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
	
	
	public static boolean allequal(ArrayList<Integer> digitlist){
		
		int n = digitlist.size();
		
		int start = digitlist.get(0);  
		
		boolean all = true;
		
			for (int i = 0; i<n ; i++ ){
				
				if(start !=  digitlist.get(i)){
					all = false;
                    break;					
				}
				
				
			}
		
		return all;
	}
	
	

}
