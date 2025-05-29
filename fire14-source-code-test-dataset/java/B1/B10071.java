/**
 * @(#)C.java
 *
 *
 * @author
 * @version 1.00 2012/4/14
 */
import java.util.*;
import java.io.*;

public class C {
	public static int recycle(int a, int b) {
		int count = 0;
		ArrayList<String> pair = new ArrayList<String>();
		for(int i = a; i <= b; i++) {
			for(int j = i+1; j <= b; j++) {
				String n1 = "" + i;
				String n2 = "" + j;
				for(int k = 1; k <= n1.length(); k++) {
					if((n2.substring(k) + n2.substring(0, k)).equals(n1) && !pair.contains(n1+n2)) {
						//System.out.println(n1 + " equals " + n2);
						count++;
						pair.add(n1+n2);
					}
				}
			}
		}

		return count;
	}

	public static void main(String [] argz) throws IOException {
		Scanner reader = new Scanner(new File("C-small-attempt0.in"));
		int numCases = reader.nextInt();
		reader.nextLine();

		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);

    	for(int i = 0; i < numCases; i++) {
    		Scanner lineReader = new Scanner(reader.nextLine());
    		int a = lineReader.nextInt();
    		int b = lineReader.nextInt();
    		out.write("Case #" + (i+1) + ": " + recycle(a, b) + "\n");
    	}

		out.close();

	}
}