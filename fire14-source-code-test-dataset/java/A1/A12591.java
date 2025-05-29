import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Dancing {

	public static void main(String[] args) throws Exception {
		
		BufferedReader fis = new BufferedReader(new FileReader(new File("input")));
		String numCasesStr = fis.readLine();
		int numCases = Integer.parseInt(numCasesStr);
		String val = "";
		int caseNum = 1;
		while((val = fis.readLine()) != null) {
			String out = calculate(val);
			System.out.println("Case #" + caseNum + ": " +out);
			caseNum++;
		}
		
	}

	private static String calculate(String val) {
		String[] ss = val.split(" ");
		int n = Integer.parseInt(ss[0]);
		int s = Integer.parseInt(ss[1]);
		int p = Integer.parseInt(ss[2]);
		
		//The minimum normal scores with atleast one p value
		
		
		
		int out = 0;
		
		for(int i = 3; i < n + 3; i++) {
			int score = Integer.parseInt(ss[i]);
			
			if(p == 0) {
				out ++;
				continue;
			}
			
			// 28, 29, 30 covers everything
			if(score >= 28) { 
				out++;
				continue;
			}
			
			if(score == 0) {
				//This is useless at this point
				//p==0 is handled above
				continue;
			}
			
			//Be greedy use the surprises as we need them
			if(3*p-2 <= score) {
				out ++;
			} else if (s > 0 && score >= 3*p-4) {
				out ++;
				s--;
			}
			
		}
		
		return "" + out;
	}

}
