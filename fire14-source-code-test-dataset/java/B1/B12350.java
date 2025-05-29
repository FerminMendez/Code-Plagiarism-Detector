import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class RecycledNumbers {
	
	public static void main(String[] args) {

		Scanner sc = null;
		try {
			sc = new Scanner(new File("./C-small-attempt0.in"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int numTestCases = Integer.parseInt(sc.nextLine());
		String eachTest = "";
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < numTestCases; ++i) {
			eachTest = sc.nextLine();
			result.append(String.format("Case #%s: ", i+1));
			result.append(compute(eachTest));
			result.append("\n");
		}
		
		try {
			FileWriter fileWriter = new FileWriter("./output");
			fileWriter.write(result.toString());
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return;
	}
	
	private static int compute(String input) {
		String[] pieces = input.split(" ");
		int A = Integer.parseInt(pieces[0]);
		int B = Integer.parseInt(pieces[1]);
		return compute(A, B);
	}
	
	public static int compute(int A, int B) {
		Set<String> set = new HashSet<String>();
		int digitLen = ("" + A).length();
		int m = 0;
		for(int n = A; n <= B; ++n) {
			for(int i = 1; i < digitLen; ++i) {
				m = shift(n, i);
				if(m > n && m <= B) {
					set.add(n + "-" + m);
				}
			}
		}
		
		return set.size();
	}
	
	static int shift(int n, int i) {
		String word = "" + n;
		int len = word.length();
		int shift = len - i - 1;
		if(len < 2) {
			return n;
		} else if(len == 2) {
			String a = new String(word.charAt(1) + "");
			String b = new String(word.charAt(0) + "");
			return Integer.parseInt( a + b);
		}
		return Integer.parseInt(word.substring(shift + 1) + word.substring(0, shift + 1));
	}
	

	
}
