

///REMOVE ALL OUTPUT AND USE STRINGTOKENIZER!


/*
ID: mfranzs1
LANG: JAVA
TASK: DancingWithTheGooglers
*/
import java.io.*;
import java.util.*;

public class DancingWithTheGooglers {
	static BufferedReader f;
	public static void main (String [] args) throws IOException {
		long unixTime = System.currentTimeMillis();
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		f = new BufferedReader(new FileReader("DancingWithTheGooglers.in"));
	                                                  // input file name goes above
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DancingWithTheGooglers.out")));

	    
	    int lines=Integer.parseInt(f.readLine());
	    
	    for(int i=0;i<lines;i++){
	    	StringTokenizer st = new StringTokenizer(f.readLine()," ");
	    	int bestOfAtLeastP=0;
	    	int numGooglers=Integer.parseInt(st.nextToken());
	    	int suprising=Integer.parseInt(st.nextToken());
	    	int p=Integer.parseInt(st.nextToken());
	    	int suprisingLeft=suprising;
	    	for(int g=0;g<numGooglers;g++){
	    		int total = Integer.parseInt(st.nextToken());
	    		System.out.println(total+" "+Math.ceil(total/3D)+" "+p+" "+((total-p)/2D));
	    		if(Math.ceil(total/3D)>=p){
	    			bestOfAtLeastP++;
	    		}else{
	    			//Has to be suprising
	    			if(total>=p){
		    			if(suprisingLeft>0){
		    				if((total-p)/2D>=p-2){
			    				suprisingLeft--;
			    				bestOfAtLeastP++;
		    				}
		    			}
	    			}
	    		}
	    	}
	    	System.out.println("Case #"+(i+1)+": "+bestOfAtLeastP);
	    	out.println("Case #"+(i+1)+": "+bestOfAtLeastP);
	    }
	    
	    out.close();                                  // close the output file
	    
	    System.out.println("Time elapsed (ms): "+(System.currentTimeMillis()-unixTime));
	    
	    System.exit(0);                               // don't omit this!
	  }
}