
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Recycle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new FileReader("/Users/sunny/Desktop/C-small-attempt0.in")));
		PrintWriter out=new PrintWriter(new FileWriter("/Users/sunny/Desktop/1.out"));
		int n = in.nextInt(); String i1, i2, line ; 
		for( int i = 1 ; i <= n ; i++){
			i1 = in.next() ; i2 = in.next() ;  
			line = "Case #"+i+": "+findN(i1, i2);
			System.out.println(line);
			out.println(line);
		}
		out.close() ;
	}

	private static int findN(String i1, String i2) {
		Integer n = new Integer(i1), m = new Integer(i2);
		int count = 0 ;
		for(int i = n ; i <= m ; i++) {
			count += getRotateCount(i+"", n, m);
		}
		return count/2;
	}
	
	private static int getRotateCount(String x, int n, int m) {
		Set<String> pairs = new HashSet<String>();
		int j, count=0, xI = Integer.parseInt(x);
		for(int i=1 ; i < x.length() ; i++ ) {
			j = Integer.parseInt(x.substring(i)+x.substring(0,i)); 
			if(j <= m && j >=n && j !=xI ) {
				if(!pairs.contains(xI+"-"+j)) {
					pairs.add(xI+"-"+j);
					count++;
				}
			}
		}
		return count ; 
	}
}
