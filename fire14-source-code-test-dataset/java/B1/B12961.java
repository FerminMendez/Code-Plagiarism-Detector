import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Recycle {
	static TreeSet<Integer> set = new TreeSet<Integer>();
	public static void main(String[] args) {
		System.out.println("\t****** Recycle numbers ******");
		long start = System.currentTimeMillis();
		String tokenStr;
		int test;int y=0,a=0,b=0;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
			PrintWriter out = new PrintWriter(new FileWriter("C-small-output0.txt"));
			//read the first line of the file
			test = Integer.parseInt(in.readLine());
			for(int i = 1; i <= test; i++) {
				tokenStr = in.readLine();
				StringTokenizer tok = new StringTokenizer(tokenStr);
				a = Integer.parseInt(tok.nextToken());
				b = Integer.parseInt(tok.nextToken()); 
				/////////////
				set.clear();y=0;	
				for (int j=a;j<=b;j++) {
				  if (set.contains(j)) continue; 
				  y += group(j,a,b); 	
				}
			    ///////////////
			    out.println("Case #" + i +": " +y);
			}//for
			out.flush();out.close();in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long time = System.currentTimeMillis()-start;
		System.out.println("time = "+time);
	}

	private static int group(int j, int a, int b) {
		String s = String.valueOf(j);
		boolean zero=false;
		int len = s.length(); int msb = (int) Math.pow(10, (len-1));  
		int n=j;int count=0;
		for (int i=0;i<len;i++) {
		  if (zero)
			  zero=false; //salto n attuale in quanto ha leading zero
		  else if (n>=a && n<=b) {
			if (!set.contains(n)) {
				set.add(n);
				count++;
			}
		  }
		  //calcolo prox giro.
			int r = n %10;
			zero = (r==0);//se leading zero salto a prox iterazione 
			n = n/10 + r*msb;
		}
		return count*(count-1)/2; // nume coppie combinazioni di count su 2
	}
}
