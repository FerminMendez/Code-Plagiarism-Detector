/*
GCJ2012-Q
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class GCJ2012QC {
	static BufferedReader fin;
    static PrintWriter fout;
    // change numefile
    static String file="qcs2";
    static String infile=file+".in";
    static String outfile=file+".out";
    //
  	
	// write result to output file
	private static void writetestresult(int test, String ret){
		fout.println("Case #"+test+": "+ret);
	}
	
	// open files
	private static void openfiles() throws IOException{
		fin = new BufferedReader(new FileReader(infile));
	    fout = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));
	}
	
	// close files
	private static void closefiles() throws IOException{
		fin.close();
		fout.close();
	}
	
	 // solve test no. "test"
	private static String solvetest(int test) throws IOException{
		System.out.println(">>>Solving test..."+test);
		// Parse input for test no. test
		int iret=0;
		String a=fin.readLine();	
		String[] as=a.split(" ");
		int A=Integer.parseInt(as[0]);
		int B=Integer.parseInt(as[1]);
		for (int n=A; n<B; n++){
			List<Integer> lst=new ArrayList<Integer>();
			
			
			int len=(""+n).length();
			String sm=""+n;
			for (int j=0; j<=len; j++) {
				String sk=sm;
				int lk=sk.length();
				sm=sk.charAt(lk-1)+sk.substring(0, lk-1);
				int m=Integer.parseInt(sm);
				
				if (m>n && m<=B) if (!lst.contains(m)) {
					lst.add(m); 
					// System.out.println(n+" "+m);
				}
				
				
			}
			iret+=lst.size();
		}
		String ret="";
		ret=""+iret;
		return ret;
	}
	
	// main here
	public static void main(String[] args) throws IOException{
		// open files
		openfiles();
		// read first line, no. of tests
		String line=fin.readLine();
		int T=Integer.parseInt(line);    
		// solve T tests
		for (int test=1; test<=T; test++) {	    	
			//long stime=System.currentTimeMillis();
			
			String ret=solvetest(test);
			writetestresult(test, ret);
			
			//long etime=System.currentTimeMillis();
	    	//long dtime=(etime-stime);
	    	//System.out.println("Test "+test+": "+dtime+"ms");
		}	    
		// close files
		closefiles();
	}
}
