import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class RecycledNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noCases = in.nextInt();
		
		for(int i = 0; i < noCases; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int noDigits = Integer.toString(a).length();
			Set<Pair> checkedNumber = new HashSet<Pair>();
			
			for(int number = a; number <= b; number++){
					for (int digit = 1; digit < noDigits; digit++) {
						if(number % Math.pow(10, digit) == 0){
							continue;
						}
						int rotatedNumber = rotate(number, digit, noDigits);
						Pair pair = new Pair(rotatedNumber,number);
						if (rotatedNumber >= a && rotatedNumber <= b
								&& !checkedNumber.contains(pair)
								&& number != rotatedNumber) {
							checkedNumber.add(pair);
						}
					}
			}
			
			System.out.println("Case #"+(i+1)+": " + checkedNumber.size());
		}
	}
	
	
	static class Pair{
		int value1, value2;
		public Pair(int value1, int value2){
			this.value1 = value1;
			this.value2 = value2;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (value1+value2);
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
			if (value1 != other.value1 && value1 != other.value2)
				return false;
			if (value2 != other.value2 && value2 != other.value1)
				return false;
			return true;
		}
		public String toString(){
			return "("+value1+","+value2+")";
		}
	}
	
	public static int rotate(int number, int noPlaces, int noDigits){
		int rotatedNumber = number;
		int divider = (int) Math.pow(10, noDigits-1);
		for(int i = 0; i < noPlaces; i++){
			int digit = rotatedNumber % 10;
			rotatedNumber = digit*divider + rotatedNumber / 10;
		}
		return rotatedNumber;
		
	}

}
