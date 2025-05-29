import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class NumberQueue {
	String number;
	
	public NumberQueue(int number) {
		this.number = number + "";
	}
	
	public void cycle() {
		char front = number.charAt(0);
		number = number.substring(1) + front;
	}
	
	public List<Pair> distinctRoations(int min, int max) {
		List<Pair> pairs = new ArrayList<Pair>();
		String original = number;
		int origNum = toInteger();
		for(int i = 0; i < number.length(); i++) {
			if(!number.equals(original)) {
				// check bounds
				int numInt = toInteger();
				if(numInt >= min && numInt <= max) {
					Pair ap = new Pair(origNum, numInt);
					if(!pairs.contains(ap)) {
						pairs.add(ap);
					}
				}
				cycle();
			} else {
				cycle();
			}
		}
		number = original;
		return pairs;
	}
	
	public int toInteger() {
		return Integer.valueOf(number);
	}
	
	public class Pair implements Comparable<Pair>{
		public int first;
		public int second;
		
		public Pair(int f, int s) {
			first = f;
			second = s;
		}
		
		// override default equals
		public boolean equals(Object o) {
			Pair other = (Pair) o;
			return (first == other.first && second == other.second) || (first == other.second && second == other.first);
		}
		
		public String toString() {
			return "" + first + "<=>" + second;
		}
		
		// compare to for ordering - mostly debugging
		public int compareTo(Pair other) {
			if(equals(other)) {
				return 0;
			} else {
				return first - other.first;
			}
		}
	}
}
