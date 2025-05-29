import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import util.MyUtil;


public class ProblemC {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws Exception {
		String title = "C-small-attempt0.in";

		BufferedReader reader = MyUtil.getReader(title);
		int caseNumber = Integer.parseInt(reader.readLine());
		BufferedWriter writer = MyUtil.getWriter(title);
		
		for (int i = 0 ; i < caseNumber; i++){
			String line = reader.readLine();
			String result = subRoutine(line);
			
			writer.write("Case #" + (i + 1) + ": " + result + "\n");
			System.out.println("Case #" + (i + 1) + ": " + result);
		}
		
		writer.flush();

	}
	
	private static String subRoutine(String line){
		StringBuilder sb = new StringBuilder();
		String[] elements = line.split(" ");
		long A = Long.parseLong(elements[0]);
		long B = Long.parseLong(elements[1]);
		long count = 0;
		
		for (long n = A ; n < B ; n++){
			Set<Long> ms = new HashSet<Long>();
			String str = String.valueOf(Math.abs((long)n));
			String newn = Long.toString(n);
			for (int i = 1; i < str.length(); i++){
				newn = shift(newn);
				
				long m = Long.parseLong(newn);
				if (m > n && m <= B && m > A){
					ms.add(m);
					//System.out.println(n + " : " + m);
					test(n,m);
				}
			}
			count += ms.size();
			
		}
		sb.append(count);
		return sb.toString();
	}
	
	public static boolean test(long n, long m){
		String nstr = Long.toString(n);
		String mstr = Long.toString(m);
		
		for (int i = 0; i < nstr.length(); i++){
			nstr = nstr.charAt(nstr.length() - 1) + nstr;
			nstr = nstr.substring(0, mstr.length());
			
			if (nstr.equals(mstr)){
				return true;
			}
		}
		return false;
	}
	private static String shift(String nstr){
		long n =  Long.parseLong(nstr);
		StringBuilder shifted = new StringBuilder();
		long last = n % 10;
		shifted.append(last);
		for (int i = 0; i < nstr.length() - 1; i++){
			shifted.append(nstr.charAt(i));
		}
		
		return shifted.toString();
	}
}
