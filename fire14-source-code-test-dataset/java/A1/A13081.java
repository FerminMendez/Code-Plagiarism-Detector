import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class B {
	
	private String nombreInputOutput;
	private BufferedReader input;
	public int surprising = 0;

	public B(String nombreInputOutput) {
		this.nombreInputOutput = nombreInputOutput;
	}

	public void run() {
		try {
			input = new BufferedReader(new FileReader(new File(nombreInputOutput + ".in")));
			PrintWriter output = new PrintWriter(new File(nombreInputOutput + ".out"));
			
			int num_cases = Integer.parseInt(input.readLine().trim());
			String Solution;
			for (int runs = 1; runs <= num_cases; runs++) {
				Solution = new Solution().solve_case(input.readLine().trim());
				String result = "Case #" + runs + ": " + Solution;
				output.println(result);
				System.out.println(result);
			}
			output.close();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	public class Solution {
		
		public String solve_case(String caseline) throws Exception { 	
			String[] inputs = caseline.split("\\s+");
			int numGooglers = Integer.parseInt(inputs[0]);
			surprising = Integer.parseInt(inputs[1]);
			int bestResult = Integer.parseInt(inputs[2]);			
			ArrayList<Double> googlers = new ArrayList<Double>();
			int inputsTotal = inputs.length;
			for (int i = 1; i <= numGooglers; i++) {
				googlers.add(Double.parseDouble(inputs[inputsTotal - i]));
			}
			
			int maxNumGooglers = 0;
			for (Double g : googlers) {
				if (checkGoogler(g, bestResult)) {
					maxNumGooglers++;
				}
			}
			String Solution = Integer.toString(maxNumGooglers);
			return Solution;
		}
		
		private Boolean checkGoogler(Double result, int bestResult) {
			Double resultbythree = result / 3;
			if (resultbythree > bestResult-1) {
				return true;
			} else if (bestResult*3 > 5 && result > bestResult*3-5) {
				if (surprising > 0) {
					surprising--;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
        B b = new B("B-small");
		b.run(); 
    }
		
}