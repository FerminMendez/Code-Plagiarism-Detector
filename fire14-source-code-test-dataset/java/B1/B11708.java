import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author ysan
 *
 */

public class Problem_C_small {
	

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("C-small-output0.txt"));
		
		int cases = Integer.parseInt(in.readLine());
		
		 for (int i = 1; i <= cases; i++) {
			 String text = in.readLine().trim();
			 String[] val = text.split(" ");
			 int count = 0;
			 int lasta=0,lastb=0;
			 
			 int a = Integer.parseInt(val[0]);
			 int b = Integer.parseInt(val[1]);
			 
			 for(int j=a; j<b; j++){ 
				 
//				 if(i < 4)break;
				 String g = Integer.toString(j);
				 
				 for(int k=g.length()-1; k>0; k--){
					 int r = switchIt(g, k);
					 if(r > j && r <= b && r != j){
						 
						 if(lasta == j && lastb == r) continue;
						 lasta = j;
						 lastb = r;
						 count++;

					 }
				 }
				 
			 }
			 out.write("Case #"+ i +": " + count);
			 out.newLine();
			 
			 
		 }
		 
		
		in.close();
		out.close();
		
		
		

	}
	
	
	static int switchIt(String v, int p){
		int r=0;
		
		String a = v.substring(p);
		String b = v.substring(0, p);
		
		if(a.charAt(0) != '0'){
			r = Integer.parseInt((a+b));
		}
		return r;
		
	}
}
