import java.util.ArrayList;
import java.util.List;


public class RecycledNumbers {

	private int A;
	private int B;
	
	public RecycledNumbers(int A, int B) {
		this.A = A;
		this.B = B;
	}
	
	public int calculate() {
		int result = 0;
		int digitCount = Integer.toString(A).length();
		
		if (digitCount == 1) return 0;
		
		List<String> numbers = new ArrayList<String>();
		for (int i = A; i < B + 1; i++) {
			numbers.add(Integer.toString(i));
		}
		
		for (int i = 0; i < numbers.size(); i++) {
			String number = numbers.get(i);
			
			for (int j = 1; j < digitCount; j++) {
				String reverseNumber = number.substring(j) + number.substring(0, j);
				int reversInt = Integer.parseInt(reverseNumber);
				
				if ((reversInt <= B) && (reversInt > Integer.parseInt(number))) {
//					System.out.println("A(" + A + ") <= " + number + " < " + reverseNumber + " <=B(" + B + ")");
					result++;
				}
			}
		}
		
		return result;
	}
	
	public static List<RecycledNumbers> parseFromFile(List<String> readInput) {
		List<RecycledNumbers> result = new ArrayList<RecycledNumbers>();
		int testCaseCount = Integer.parseInt(readInput.get(0));

		for (int i = 0; i < testCaseCount; i++) {
			String line[] = readInput.get(i + 1).split(" ");

			result.add(new RecycledNumbers(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
		}

		return result;
	}
	
	@Override
	public String toString() {
		return "A = " + A + "; B = " + B;
	}
}
