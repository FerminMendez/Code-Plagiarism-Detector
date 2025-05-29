import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import util.MyUtil;


public class ProblemB {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws Exception {
		String title = "B-small-attempt0.in";

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
		
		// The first integer will be N, the number of Googlers. 
		long N = Long.parseLong(elements[0]);
		// the second integer will be S, the number of surprising triplets of scores
		long B = Long.parseLong(elements[1]);
		// The third integer will be p, a best result of at least p
		long P = Long.parseLong(elements[2]);
		
		long count = 0;
		for (int i = 3 ; i < elements.length; i++){
			long total = Long.parseLong(elements[i]);
			long ok1 = Math.min(1, total);
			long ok2 = Math.min(2, total);
			long remains = total - P;
			long least = P - ok1;
			long doubleLeast = least * 2;
			if (remains >= doubleLeast ){
				count ++;
			}
			else if (remains + ok2 >= doubleLeast  && B > 0){
				count++;
				B--;
			}
			
		}
		
		sb.append(count);
		return sb.toString();
	}
}
