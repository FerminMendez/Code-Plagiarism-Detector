import java.util.Hashtable;
import java.util.Scanner;

class RecycleResult{
	private int lowerBound, upperBound, numberOfDigits;
	public RecycleResult(int a, int b, int d){
		lowerBound = a;
		upperBound = b;
		numberOfDigits = d;
	}
	public int solve(){
		int count = 0;
		for (int i = lowerBound; i < upperBound; i++){
			int p = i;
			Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
			for (int j = 1; j < numberOfDigits; j++){
				p = moveToFront(p);
				if ((p <= upperBound) && (p > i) && (!(p == i)) && (!(hash.containsValue(p)))){
					count++;
					hash.put(count, p);
				}
			}
		}
		return count;
	}
	public int moveToFront(int z){
		int lastDigit = z % 10;
		int otherDigits = (z / 10);
		for (int i = 0; i < numberOfDigits - 1; i++){
			lastDigit = lastDigit * 10;
		}
		return otherDigits + lastDigit;
	}
}
public class Recycle {
	public static void main(String[] args) {
		int numberOfCases;
		Scanner myScanner = new Scanner(System.in);
		int a, b;
		numberOfCases = myScanner.nextInt();
		RecycleResult myResult;
		
		for (int i = 0; i < numberOfCases; i++){
			a = myScanner.nextInt();
			b = myScanner.nextInt();
			int length = String.valueOf(a).length();
			myResult = new RecycleResult(a, b, length);
			int count = myResult.solve();
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}
}
