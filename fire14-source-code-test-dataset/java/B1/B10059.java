import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class RecycledNumbers {

	private final String inputFile = "D:\\input.in";
	private final String outputFile = "D:\\output.out";
	private static  class TestCase{
		int a;
		int b;
		public int calculateRecycleds(){
			int result = 0;
			for (int i = a; i <= b; i++){
				int numDigits = getNumDigits(i);
				int lastResycled = -1;
				for (int j = 0, divisor = 10; j < numDigits - 1; j++, divisor *= 10){
					int recycled = i % divisor;
					for (int k = 0; k < numDigits - j - 1; k++){
						recycled *= 10;
					}
					recycled += (i / divisor);
					if (isInRange(recycled) && recycled > i && lastResycled != recycled){
						result ++;
						lastResycled = recycled;
					}
				}
				
			}
			return result;
		}
		private int getNumDigits(int i){
			int numDigits = 0;
			while (i > 0){
				numDigits++;
				i /= 10;
			}
			return numDigits;
		}
		private boolean isInRange(int i){
			return (i >= a) && (i <= b);
		}
	}
	List<TestCase> input =  new ArrayList<RecycledNumbers.TestCase>();
	public void parseInput(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			int numTestCases = Integer.parseInt(br.readLine());
			for (int i = 0; i < numTestCases; i++){
				String [] lineTokens = br.readLine().split(" ");
				TestCase tc = new TestCase();
				tc.a = Integer.parseInt(lineTokens[0]);
				tc.b = Integer.parseInt(lineTokens[1]);
				input.add(tc);
			}			
			br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public void doOutput(){
		try {
			PrintWriter pw = new  PrintWriter(new FileOutputStream(outputFile));
			
			for (int i = 0; i < input.size(); i++){
				TestCase tc = input.get(i);
				pw.println("Case #" + (i + 1) + ": " + tc.calculateRecycleds());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		RecycledNumbers rn  = new RecycledNumbers();
		rn.parseInput();
		rn.doOutput();
	}
}
