import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class C {

	static final char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = null;
		if (args != null && args.length > 0) {
			
			try {
				sc = new Scanner(new File(args[0]));
					
				if (args.length > 1) {
					System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(args[1])), 128)));
				}
			} catch (FileNotFoundException e) {
				
				// e.printStackTrace();
				sc = new Scanner(System.in);
			}
			
		} else {
			
			sc = new Scanner(System.in);
		}

		int T = Integer.valueOf(sc.nextLine());
		
		for (int i = 0; i < T; i++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int answer = solve(A, B);
			System.out.printf("Case #%d: %d\n", i + 1, answer);
			
		}
		System.out.close();
	}
	
	public static int solve(int A, int B) {
		
		int answer = 0;
		int seedNum = A;
		do {
			
			answer += hasRecycled(seedNum++, A, B);
			
		} while (seedNum < B);
		return answer;
	}
	
	public static int hasRecycled(long seedNum, long A, long B) {
		
		int count = 0;
		int ptr;
		char[] old_num_chars = String.valueOf(seedNum).toCharArray();
		int length = old_num_chars.length;
		char[] moved_num_chars = new char[length];
		List<Long> newNumList = new ArrayList<Long>();
		
		for (int i = length - 1; i > 0; i--) {
			
			ptr = i;
			for (int j = 0; j < length; j++) {
				
				if (ptr == 0) {
					
					moved_num_chars[ptr] = old_num_chars[length - 1];							
				} else {			
					
					moved_num_chars[ptr] = old_num_chars[ptr - 1];					
				}
				
				if (--ptr < 0) {
					ptr += length;
				}
				
			}
			
			
			long newNum = Long.valueOf(new String(moved_num_chars));
			if ( seedNum < newNum && newNum <= B) {
				
				boolean isNew = true;
				for (Iterator<Long> it = newNumList.iterator(); it.hasNext();) {
					Long l = it.next();
					
					if (l.equals(newNum)) {
						isNew = false;
						break;
					}
				}
				if (isNew) {
					newNumList.add(newNum);					
					count++;
					
				}
			}
			old_num_chars = moved_num_chars.clone();
			
		}
		
		return count;
	}

}
