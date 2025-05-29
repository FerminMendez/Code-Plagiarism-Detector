import java.io.IOException;
import java.io.PrintWriter;

public class RecycledNumbers {
	
	public static void main(String[] args) {
		RecycledNumbers bt = new RecycledNumbers();
		bt.solveProblem();
		
	}
	public void solveProblem() {
		String[] testCases = ReadFile.readFile("C:/Users/Pablo/Documents/codejam/RN.in");
		int i = 0;
		StringBuilder res = new StringBuilder();
		for (String testCase : testCases) {
			if(!res.toString().equals("")) {
				res.append("\n");
			}
			res.append(processTestCase(testCase, ++i));
		}
		System.out.print(res.toString());
		try {
			PrintWriter pw = new PrintWriter("C:/Users/Pablo/Documents/codejam/RN.out");
			pw.print(res.toString());
			pw.close();
		} catch (IOException e) {
			System.out.println("Error writing file!!");
		}
	}
	
	private String processTestCase(String testCase, int caseNum) {
		Long a = Long.valueOf(testCase.split(" ")[0]);
		Long b = Long.valueOf(testCase.split(" ")[1]);
		Long lim = Double.valueOf(Math.floor((a + b)/ 2d)).longValue() + 1L;
		
		int cantNumbers = 0;
		
		if(a.compareTo(10L) >= 0) {
			cantNumbers = verifNumbers(b, a, 0);
		} 
		
		return "Case #" + caseNum + ": " + cantNumbers;
	}
	
	private int verifNumbers(Long b, Long num, int cantNumbers) {

		if(num.compareTo(b) < 0) {
			String n = num.toString();
			n = n.replaceAll(String.valueOf(n.charAt(0)), "");

			if(!n.equals("")) {
				for(int i = 1; i <= num.toString().length(); i++) {
					String s = num.toString().substring(num.toString().length() - i, num.toString().length()) + 
					num.toString().substring(0, num.toString().length() - i);

					Long tmp = Long.valueOf(s);

					if(tmp.compareTo(b) <= 0 && tmp.compareTo(num) > 0) {
						cantNumbers ++;
					}
				}
			}

			cantNumbers = verifNumbers(b, num + 1L, cantNumbers);
		}
		return cantNumbers;
	}	
}
