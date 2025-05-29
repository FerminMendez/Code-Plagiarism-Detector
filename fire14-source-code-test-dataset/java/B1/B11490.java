import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class C {

	private static ArrayList<Byte> makeCycle(ArrayList<Byte> digits) {
		if (digits.size() == 1) {
			return new ArrayList<Byte>(digits);
		}
		
		ArrayList<Byte> cycle = new ArrayList<Byte>();
		int tail = 0;
		
		while (tail < digits.size() && digits.get(tail) == 0) {
			++tail;			
		}
		
		cycle = new ArrayList<Byte>(digits.subList(tail + 1, digits.size()));
		
		for (int i = 0;i <= tail; ++i) {
			cycle.add(digits.get(i));
		}
		
		return cycle;
	}
	
	private static boolean sequenceEquals(ArrayList<Byte> sec1, ArrayList<Byte> sec2) {
		for (int i = 0;i < sec1.size(); ++i) {
			if (sec1.get(i) != sec2.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	private static long value(ArrayList<Byte> digits) {
		long val = 0;
		long pow = 1;
		
		for (int i = 0;i < digits.size(); ++i) {
			val += digits.get(i) * pow;
			pow *= 10;
		}
		
		return val;
	} 
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer tokenizer = new StreamTokenizer(in);

		int tests;
		
		tokenizer.nextToken();
		tests = (int)tokenizer.nval;
		
		int[] answers = new int[tests];
		
		for (int i = 0;i < tests; ++i) {
			long A, B;
			
			tokenizer.nextToken();
			A = (long)tokenizer.nval;
			
			tokenizer.nextToken();
			B = (long)tokenizer.nval;			
			
			for (long n = A; n <= B; ++n) {
				ArrayList<Byte> digits = new ArrayList<Byte>();
				
				long v = n;
				
				while (v > 0) {
					digits.add(Byte.valueOf(Long.toString(v % 10)));
					v = v / 10;
				}				
								
				ArrayList<Byte> cycled = new ArrayList<Byte>(digits);
				
				while (!sequenceEquals(cycled = makeCycle(new ArrayList<Byte>(cycled)), digits)) {
					long val = value(cycled);
					if (val <= B && val > n) {
						++answers[i];
					}
				}
			}
		}
		
		for (int i = 0;i < tests; ++i) {
			System.out.println("Case #" + (i + 1) + ": " + answers[i]);
		}
	}

}
