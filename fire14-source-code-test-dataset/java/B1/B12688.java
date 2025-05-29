package gcj2012;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecycledNumbers {

	private static final class IntPair {
		Integer a, b;
		IntPair(Integer a,Integer b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public boolean equals(Object obj) {
			IntPair other = (IntPair) obj;
			return a.equals(other.a) && b.equals(other.b);
		}
		@Override
		public int hashCode() {
			return a.hashCode() * b.hashCode();
		}
		
	}
	
	private static Map<IntPair, Object> beenThereDoneThat;
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(new File("C-small-attempt0.txt"));
		PrintWriter output = new PrintWriter(new FileWriter("out1.txt"));
		int size = scn.nextInt();
		for (int i = 1; i <= size; i++) {
			int total = 0;
			int a = scn.nextInt();
			int b = scn.nextInt();
			for (int j = a; j <= b; j++) {
				total += count(j, b);
			}
			output.write("Case #" + i + ": " + total);
			output.write('\n');
		}
		output.close();
	}
	
	private static int count(Integer curr, Integer max) {
		String currString = curr.toString();
		int currSize = currString.length();
		if (currSize == 1) {
			return 0;
		}
		beenThereDoneThat = new HashMap<IntPair, Object>();
		int localCount = 0;
		//i is start index of end part, which is moving to the front
		for (int i = 1; i < currSize; i++) {
			String newCurr = currString.substring(i) + currString.substring(0, i);
			int newCurrInt = Integer.valueOf(newCurr);
			if (newCurrInt > curr && newCurrInt <= max) {
				IntPair pair = new IntPair(curr, newCurrInt);
				if (beenThereDoneThat.get(pair) == null) {
					beenThereDoneThat.put(pair, new Object());
					localCount++;
				}
				
//				if (localCount == 1) {					
//					System.out.print(curr);
//				}
//				System.out.print(" "+newCurrInt);
			}
		}
//		if (localCount !=0) {			
//			System.out.println();
//		}
		return localCount;
	}
	
	
}
