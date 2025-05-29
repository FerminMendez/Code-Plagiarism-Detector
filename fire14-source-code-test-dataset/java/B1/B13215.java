import java.io.*;
import java.util.*;


public class RecycledNumbers {
	
	static LinkedList<String> seen = new LinkedList<String>();
	static int min, max;
	static int count;
	
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(new File("C-small.txt"));
		
		int cases;
		cases = in.nextInt();
		
		
		for (int n = 0; n < cases; n++) {
			seen = new LinkedList<String>();
			min = in.nextInt();
			max = in.nextInt();
			
			count = 0;
			
			for (int i = min; i < max; i++) {
				findPairs(i);
			}
			
			System.out.println("Case #" + (n+1) + ": " + count);
		}

	}
	
	public static void findPairs(int num) {
		String n = "" + num;
		int result;
		
		for (int i = 1; i < n.length(); i++) {
			result = Integer.parseInt(n.substring(i) + n.substring(0, i));
			
			if (result > num && result <= max && !(seen.contains(n + " " + result))) {
				count ++;
				seen.add(n + " " + result);
			}
		}
	}
}