/*
GCJ2012-Q
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class GCJ2012QB {
	static BufferedReader fin;
    static PrintWriter fout;
    // change numefile
    static String file="qbs2";
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
		String a=fin.readLine();	
		String[] as=a.split(" ");
		int N=Integer.parseInt(as[0]);
		int S=Integer.parseInt(as[1]);
		int p=Integer.parseInt(as[2]);
		int[] t=new int[N];
		for (int i=0; i<N; i++) t[i]=Integer.parseInt(as[i+3]);
		
		int iret=0;
		int[] sur=new int[N]; Arrays.fill(sur, 0);
		int[] nes=new int[N]; Arrays.fill(nes, 0);
		
		for (int i=0; i<N; i++){
			for (int pc=p; pc<=10; pc++){
				if (3*pc==t[i] || (3*pc-1==t[i] && pc-1>=0) || (3*pc-2==t[i] && pc-1>=0)) nes[i]=1;
				if ((3*pc-2==t[i] && pc-2>=0) || (3*pc-3==t[i] && pc-2>=0) || (3*pc-4==t[i] && pc-2>=0)) sur[i]=1;
			}
			iret=0;
			int surp=0;
			for (int j=0; j<N; j++)
				if (sur[j]==1 && nes[j]==0) surp++;
			if (surp<=S) iret+=surp; else iret+=S;
			for (int j=0; j<N; j++)
				if (nes[j]==1) iret++;
		}
			
		String ret=""+iret;
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
