import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
  		FileWriter fw = new FileWriter("output.out");
  		/*BufferedReader in = new BufferedReader(new FileReader("A-large.in"));
  		FileWriter fw = new FileWriter("A-large.out");*/
  		int N = new Integer(in.readLine());
  		String[] output = new String[N];
  		int[] trueCount = new int[N];
  		for (int cases = 0; cases < N; cases++) {
  			int CaseNo = cases+1;
  			output[cases] = "";
  			StringTokenizer G = new StringTokenizer(in.readLine());
  			int W = G.countTokens();
  			int[] a = new int[2];
  			String[] b = new String[W];
  			for (int j = 0; j < a.length; j++) {
  				a[j] = new Integer(G.nextToken());
  			}
  			int counter = 1;
  			int A =a[0];
  			int B =a[1];
  			int C = a[0];
  			System.out.println(A + "  x  " +B);
  			
  			int lengthA = Integer.toString(A).length();
  			if (lengthA == 1){
  				trueCount[cases] = 0;
  			}
  			else{
	  			int range = B - A + 1;
	  			int[] rangeA = new int[range];
	  			rangeA[0] = A;
	  			while (A<B){
	  				A = A+1;
	  				rangeA[counter] = A;
	  				counter=counter+1;
	  			}
	  			for (int ii=0;ii<range;ii++){
	  				int currentN = rangeA[ii];
	  				int currentM = rangeA[ii];
	  				int length = Integer.toString(rangeA[ii]).length();
	  				String curM = Integer.toString(currentM);
	  				for (int jj=0; jj<length;jj++){  					
	  					curM = curM.charAt(length-1) + curM.substring(0, length-1);
	  					currentM = Integer.parseInt(curM);	  					
	  					if (currentM <= B && currentM > currentN && currentM >= C){
	  						trueCount[cases]+=1;
	  					}
	  				}
	  				
	  			}  	
  			}
  			fw.write("Case #"+CaseNo+": "+ trueCount[cases]+ "\n");  			
  			
  		}
  		fw.flush();
  		fw.close();
	}
}
