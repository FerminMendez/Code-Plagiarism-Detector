package blacky.codejam.qualifications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {

	private static class Pair {
		
		final public int m;
		
		final public int n;
		
		public Pair(int m, int n) {
			this.m = m;
			this.n = n;
		}
		
		public boolean equals(Object other) {
			return ((Pair)other).m == this.m && ((Pair)other).n == this.n;
		}
		
		public String toString() {
			return String.format("(%d,%d)", this.m, this.n);
		}
		
		public int hashCode() {
			return this.m * 31 + n;
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
		int numberOfTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numberOfTestCases; i++) {
			String numbers[] = reader.readLine().split(" ");
			Set<Pair> pairs = new HashSet<Pair>();
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			for(int j = a; j < b; j++) {
				String jAsString = Integer.toString(j);
				int recycledNumbers[] = new int[jAsString.length()];
				recycledNumbers[0] = j;
				for(int k = 1; k < jAsString.length(); k++) {
					int offset = jAsString.length() - k;
					String currentRecNum = jAsString.substring(offset).concat(jAsString.substring(0, offset));
					recycledNumbers[k] = Integer.parseInt(currentRecNum);
				}
				Arrays.sort(recycledNumbers);
				for(int k = 0; k < recycledNumbers.length - 1; k++) {
					if(!(a <= recycledNumbers[k] && recycledNumbers[k] <= b)) continue;
					for(int l = k + 1; l < recycledNumbers.length; l++) {
						if(!(a <= recycledNumbers[l] && recycledNumbers[l] <= b)) continue;
						if(recycledNumbers[l] == recycledNumbers[k]) continue;
						pairs.add(new Pair(recycledNumbers[k], recycledNumbers[l]));
					}
				}
			}
			System.out.println(String.format("Case #%d: %d", i + 1, pairs.size()));
		}
	}
	
}
