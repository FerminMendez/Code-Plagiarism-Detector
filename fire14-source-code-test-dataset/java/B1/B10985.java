import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class ProblemC {
	
	public int countDistinctRecycledPairsBetween(int min, int max) {
		int count = 0;
		int digit = Integer.toString(min).length();
		for (int i = min; i <= max; i++) {
			count += this.countDistinctRecycledPairOf(i, min, max, digit);
		}
		return count;
	}
	
	public int countDistinctRecycledPairOf(int number, int min, int max, int digit) {
		List<Integer> used = new ArrayList<Integer>(digit);
		int count = 0;
		int rotated = number;
		
		for (int i = 0, rotateCount = digit - 1; i < rotateCount; i++) {
			rotated = this.shiftRightAndRotate(rotated, digit);
			
			if (rotated > number && rotated <= max && used.indexOf(rotated) == -1) {
				count++;
				used.add(rotated);
			}
		}
		
		return count;
	}
	
	private int shiftRightAndRotate(int number, int digit) {
		return (number % 10) * (int)Math.pow(10, digit - 1) + (number / 10);
	}
	
	public void solve(String inputFileName, String outputFileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(inputFileName)));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
			
			int testCount = Integer.parseInt(reader.readLine());
			for (int i = 0; i < testCount; i++) {
				String testCase = reader.readLine();
				String[] fields = testCase.split(" ");
				
				int min = Integer.parseInt(fields[0]);
				int max = Integer.parseInt(fields[1]);
				int count = this.countDistinctRecycledPairsBetween(min, max);
				
				writer.write("Case #" + (i + 1) + ": " + count);
				writer.newLine();
			}
			
			reader.close();
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		ProblemC problem = new ProblemC();
//		problem.solve("C-small-attempt.in", "C-small-attempt.out");
		problem.solve("C-small-attempt0.in", "C-small-attempt0.out");
//		problem.solve("B-large.in", "B-large.out");
	}
}
