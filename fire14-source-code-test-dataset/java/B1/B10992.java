import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class RecycledNumbers {

	public static void main(String[] args) throws IOException {
		if(args.length != 2) {
			System.out.println("Error");
			System.exit(1);
		}
		
		RecycledNumbers recycle = new RecycledNumbers();
		
		BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
		PrintWriter out = new PrintWriter(new File(args[1]));
		
		in.readLine();
		int index = 1;
		while(true) {
			String line = in.readLine();
			if(line == null) break;
			String[] numbers = line.split(" ");
			out.println("Case #" + index + ": " + recycle.numOfRecycledNumbers(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])));
			index++;
		}
		out.close();
		in.close();
	}
	
	private Map<Pair, Boolean> recycledNumbersMap = new HashMap<Pair, Boolean>(); 
	
	private class Pair {
		int n;
		int m;
		
		public Pair(int n, int m) {
			this.n = n;
			this.m = m;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + m;
			result = prime * result + n;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}

		private RecycledNumbers getOuterType() {
			return RecycledNumbers.this;
		}
	}
	
	public int numOfRecycledNumbers(int lowerLimit, int upperLimit) {
		int recycledNumbers = 0;
		for (int n = lowerLimit; n <= upperLimit; n++) {
			for (int m = n + 1; m <= upperLimit; m++) {
				Pair pair = new Pair(n, m);
				Pair otherPair = new Pair(m, n);
				if(recycledNumbersMap.containsKey(pair)) {
					if(recycledNumbersMap.get(pair)) recycledNumbers++;
					continue;
				}
				String nStr = String.valueOf(n);
				String mStr = String.valueOf(m);
				boolean foundRecycled;
				if (sameNumberOfDigits(nStr, mStr) && 
						containSameDigits(nStr, mStr) &&
						checkIfRecycledNumbers(nStr, mStr)) {
					recycledNumbers++;
					foundRecycled = true;
				} else {
					foundRecycled = false;
				}
				recycledNumbersMap.put(pair, foundRecycled);
				recycledNumbersMap.put(otherPair, foundRecycled);
			}
		}
		return recycledNumbers;
	}
	
	boolean sameNumberOfDigits(String n, String m) {
		return n.length() == m.length();
	}
	
	boolean containSameDigits(String n, String m) {
		while(!n.isEmpty()) {
			String c = n.charAt(0) + "";
			n = n.replaceFirst(c, "");
			if (!m.contains(c)) return false;
			m = m.replaceFirst(c, "");
		}
		return m.isEmpty();
	}
	
	boolean checkIfRecycledNumbers(String n, String m) {
		int secondLength = m.length();
		
		List<Integer> allIndexes = getAllIndexes(m, n.charAt(0));
		boolean foundRecycle;
		
		for(int index : allIndexes) {
			int secondIndex = index;
			foundRecycle = true;
			
			for(int firstIndex = 1; firstIndex < n.length(); firstIndex++) {
				secondIndex = (secondIndex + 1) % secondLength;
				if (n.charAt(firstIndex) != m.charAt(secondIndex)) {
					foundRecycle = false;
					break;
				}
			}
			if(foundRecycle) return true;
		}
		return false;
	}
	
	List<Integer> getAllIndexes(String str, char c) {
		List<Integer> indexes = new ArrayList<Integer>();
		int index = 0;
		while(true){
			if(index >= str.length()) break;
			index = str.indexOf(c, index);
			if(index == -1) break;
			indexes.add(index);
			index++;
		}
		return indexes;
	}
}
