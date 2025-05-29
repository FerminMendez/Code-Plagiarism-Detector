import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class DancingGooglers {

	private final String inputFile = "D:\\input.in";
	private final String outputFile = "D:\\output.out";
	
	private static class TestCase{
		int n;
		int s;
		int p;
		int result = 0;
		List<Integer> ti = new ArrayList<Integer>();
		
		public void calculateBest(){
			result = 0;
			int max = p * 3;
			for (int i: ti){
				if (p <= 0){
					result++;
					continue;
				}
				if (i > 0 && i >= (max - 4)){
					if (i >= max || (max - i) <= 2){
						result++;
					}else if((max - i) <= 4 && s > 0){
						result++; s--;
					}
				}
				
			}
		}
	}
	List<TestCase> input = new ArrayList<DancingGooglers.TestCase>();
	public void parseInput(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			int numTestCases = Integer.parseInt(br.readLine());
			for (int i = 0; i < numTestCases; i++){
				String [] lineTokens = br.readLine().split(" ");
				TestCase tc = new TestCase();
				tc.n = Integer.parseInt(lineTokens[0]);
				tc.s  = Integer.parseInt(lineTokens[1]);
				tc.p  = Integer.parseInt(lineTokens[2]);
				for (int j = 3; j < lineTokens.length; j++){
					tc.ti.add(Integer.parseInt(lineTokens[j]));
				}
				tc.calculateBest();
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
				pw.println("Case #" + (i + 1) + ": " + tc.result);
			}
			
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		DancingGooglers dg = new DancingGooglers();
		dg.parseInput();
		dg.doOutput();
	}
}
