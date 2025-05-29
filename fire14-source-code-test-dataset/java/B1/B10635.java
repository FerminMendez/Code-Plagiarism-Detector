

///REMOVE ALL OUTPUT AND USE STRINGTOKENIZER!


/*
ID: mfranzs1
LANG: JAVA
TASK: RecycledNumbers
*/
import java.io.*;
import java.util.*;

public class RecycledNumbers {
	static BufferedReader f;
	public static void main (String [] args) throws IOException {
		long unixTime = System.currentTimeMillis();
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		f = new BufferedReader(new FileReader("RecycledNumbers.in"));
	                                                  // input file name goes above
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("RecycledNumbers.out")));
	    // Use StringTokenizer vs. readLine/split -- lots faster
	    //StringTokenizer st = new StringTokenizer(f.readLine()," ");	    	
    	//int i = Integer.parseInt(st.nextToken());
	    
	    int cases=Integer.parseInt(f.readLine());
	    for(int c=0;c<cases;c++){
	    	StringTokenizer st = new StringTokenizer(f.readLine()," ");	
	    	int A = Integer.parseInt(st.nextToken());
	    	int B = Integer.parseInt(st.nextToken());
	    	//System.out.println(A+" "+B);
	    	int numRecycled=0;
	    	for(int n=A;n<B;n++){
	    		numRecycled+=rec(n,B);
	    	}
	    	System.out.println("Case #"+(c+1)+": "+numRecycled);
	    	out.println("Case #"+(c+1)+": "+numRecycled);
	    }
	    
	    
	    
	    out.close();                                  // close the output file
	    
	    System.out.println("Time elapsed (ms): "+(System.currentTimeMillis()-unixTime));
	    
	    System.exit(0);                               // don't omit this!
	  }
	public static int rec(int n,int max){
		ArrayList<String> workingPairs = new ArrayList<String>();
		String stringN=""+n;
		for(int swap=1;swap<stringN.length();swap++){
			String next=stringN.substring(swap)+stringN.substring(0,swap);
			int m=Integer.parseInt(next);
			if(n<m&&m<=max&&(m+"").charAt(0)!='0'){
				String add=n+" "+m;
				if(!workingPairs.contains(add)){
					workingPairs.add(add);
				}
				System.out.println(n+" "+m);
			}
			//System.out.println(next);
		}
		return workingPairs.size();
	}
}