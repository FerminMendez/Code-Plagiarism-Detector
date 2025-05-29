import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Dancers {

	static LinkedList<Integer> scores;
	static int googlers = 0;
	static int surprising = 0;
	static int p;
	
	
	public static void main(String[] args) {
		String text = "";
		int tests = 0;
		int test_index=0;
		int result;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			tests = Integer.parseInt(br.readLine());		
			while ((text = br.readLine()) != null && test_index < tests){							
				test_index++;
				String[] testcase = text.split(" ");
				googlers = Integer.parseInt(testcase[0]);
				surprising = Integer.parseInt(testcase[1]);
				p = Integer.parseInt(testcase[2]);
				int i = 3;
				scores = new LinkedList<Integer>();
				while(i<testcase.length){
					scores.add(Integer.parseInt(testcase[i]));
					i++;
				}
				result = calc();
				System.out.println("Case #" + test_index + ": " + result);
			}
		} catch (Exception e) {e.printStackTrace();}				
	}

	private static int calc() {
		int result = 0;
		for(int x : scores){
			
			if(p == 0) { result = scores.size(); break; }
			
			if(x == 0 && p == 0) { result++; continue; }
			if(x == 0 && p != 0) { continue; }
				
			int surpriseLimit = Math.max(p+(p-2)+(p-2),0);
			int okLimit = Math.max(p+(p-1)+(p-1),0);
			if(x >= okLimit) { result++; }			
			if(x >= surpriseLimit && x < okLimit && surprising > 0){
				surprising--;
				result++;
			}			
			
		}
		return result;
	}
	
}
