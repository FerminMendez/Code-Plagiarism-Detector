package c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class RecycledNumbers {

	public static int getDistinctRecycleCount(int min, int max) {
		HashSet<String> distinctCollection = new HashSet<String>();
		for(int i = min; i <= max; i++) {
			distinctCollection.addAll(getThePossiblePair(i, max));
		}
		return distinctCollection.size();
	}
	
	private static HashSet<String> getThePossiblePair(int theNum, int max) {
		HashSet<String> ret = new HashSet<String>();
		String theNumStr = Integer.toString(theNum);
		for(int n = 1; n < theNumStr.length(); n++) {
			//roll the number 1 time to the left
			char firstChar = theNumStr.charAt(0);
			theNumStr = theNumStr.substring(1) + firstChar;
			int theRolledNum = Integer.parseInt(theNumStr);

			//check if the rolled number is possible
			if((theNum < theRolledNum) && (theRolledNum <= max))
				ret.add(Integer.toString(Math.min(theNum, theRolledNum)) +
						"-" +
						Integer.toString(Math.max(theNum, theRolledNum)));
		}
		return ret;
	}


	public static void main(String[] args) throws Exception {

		//initial reader by args[0]
		BufferedReader r = new BufferedReader(new FileReader(args[0]));
		int cases = Integer.parseInt(r.readLine());

		//initial writer by args[1]
		PrintWriter w = new PrintWriter(args[1]);

		//do
		for(int i = 1; i <= cases; i++) {
			String[] ab = r.readLine().split(" ");
			w.println("Case #" + i + ": " + getDistinctRecycleCount(Integer.parseInt(ab[0]), Integer.parseInt(ab[1])));
		}

		//close file handles
		w.close();
		r.close();
	}

}