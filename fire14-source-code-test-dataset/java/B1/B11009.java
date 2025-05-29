import java.util.*;
import java.io.*;

class problemC {
	static class Coordinate implements Comparable<Coordinate> {
		int x, y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equal(Object o) {
			if (o == null || !(o instanceof Coordinate)) {
				return false;
			} else {
				return ((Coordinate)o).x == this.x &&
					((Coordinate)o).y == this.y;
			}
		}

		@Override
		public int compareTo(Coordinate o) {
			// TODO Auto-generated method stub
			if (o.x == this.x && o.y == this.y)
				return 0;
			else
				return -1;
		}
		
		public String toString() {
			return "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		String myFilename = (args.length < 1) ? "test" : args[0];
		Set<Coordinate> mySet = new TreeSet<Coordinate>();
		Scanner sc = new Scanner(new File(myFilename));
		int testCases, A, B, maxDigits, newNum;
		String currNumStr, shiftedNumStr, frontStr, newStr;

		testCases = sc.nextInt();
		sc.nextLine();

		for (int cases = 0; cases < testCases; cases++) {
			A = sc.nextInt();
			B = sc.nextInt();

			mySet.clear();
			for (int x = A; x <= B; x++) {
				currNumStr = Integer.toString(x);
				maxDigits = currNumStr.length();
				// Shifting 0 and maxDigits won't change the number
				for (int digitsToShift = 1; digitsToShift < maxDigits; digitsToShift++) {
					shiftedNumStr = currNumStr.substring(digitsToShift, currNumStr.length());
					if (shiftedNumStr.charAt(0) == '0')
						continue;
					frontStr = currNumStr.substring(0, digitsToShift);
					newStr = shiftedNumStr + frontStr;
					newNum = Integer.parseInt(newStr);
					if (x < newNum && newNum >= A && newNum <= B)
						mySet.add(new Coordinate(x, newNum));
				}
			}

			System.out.println("Case #" + (cases+1) + ": " + mySet.size());
		}
	}
}
