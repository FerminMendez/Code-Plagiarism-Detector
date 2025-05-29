import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Problem3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int lineNo = scan.nextInt();
		
		for(int i = 0 ; i < lineNo ; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
//			String aString = String.valueOf(a);
			String bString = String.valueOf(b);
			
			int stringLength = bString.length();
			
//			HashMap<String, String> recycleMap = new HashMap<String, String>();
			Set<Pair> pairSet = new HashSet<Pair>();
			
			int size = 0;
			for(int j = a ; j <= b ; j++) {
				String numString = String.format("%0" + stringLength + "d", j);
				
				String movedString = new String(numString);
				for(int k = 0 ; k < stringLength ; k++) {
					String frontString = String.valueOf(movedString.charAt(0));
					movedString = movedString.substring(1) + frontString;
					int movedInt = Integer.parseInt(movedString);
					if(a <= movedInt && movedInt <= b && movedInt > j) {
//						recycleMap.put(numString, movedString);
						pairSet.add(new Pair(j, movedInt));
						
//						System.out.println(numString + ": " + movedString);
						size++;
					}
				}
			}
			
			System.out.println("Case #" + (i+1) + ": " + pairSet.size());
			
			// For Test
//			System.out.println("=== Test Map ===");
//			
//			Set<String> keyMap =  recycleMap.keySet();
//			for(Iterator<String> iter = keyMap.iterator() ; iter.hasNext() ; ) {
//				String key = iter.next();
//				String value = recycleMap.get(key);
//				
//				System.out.println(key + ": " + value);
//			}
		}
	}
} 

class Pair {
	int min;
	int max;
	
	public Pair(int a, int b) {
		if(a < b) {
			min = a;
			max = b;
		}
		else  {
			min = b;
			max = a;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + max;
		result = prime * result + min;
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
		if (max != other.max)
			return false;
		if (min != other.min)
			return false;
		return true;
	}
}
