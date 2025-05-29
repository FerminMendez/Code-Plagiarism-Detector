import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CodeJam3 {
	
	
	private static HashMap<Character, Character> map = new HashMap<Character, Character>();
	private static ArrayList<String> results = new ArrayList<String>();
	
	public static void main (String args[]) throws IOException {
	
		Scanner scanner = new Scanner(args[0]);
		
		int numToParse = Integer.parseInt(scanner.nextLine());
	
		for (int i = 0; i < numToParse; i++) {
			int count = 0;
			String string = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(string);
			int firstInt = Integer.parseInt(st.nextToken());
			int secondInt = Integer.parseInt(st.nextToken());
			String s = "" + firstInt;
			int length = s.length();
			for (int j = firstInt; j <= secondInt; j++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int k = 1; k < length; k++) {
					String localString = "" + j;
					String sub1 = localString.substring(0, k);
					String sub2 = localString.substring(k, length);
					String newString = sub2 + sub1;
					int integer = Integer.parseInt(newString);
					if (!list.contains(integer) && integer > j && integer <= secondInt) {
						count++;
						list.add(integer);
					}
				}
			}
			String result= "Case #" + (i + 1) + ": " + count;
			System.out.println(result);
		}
	}
}
