import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Pairs {

	public static void main(String[] args) throws Exception {

		BufferedReader fis = new BufferedReader(new FileReader(
				new File("input")));
		String numCasesStr = fis.readLine();
		int numCases = Integer.parseInt(numCasesStr);
		String val = "";
		int caseNum = 1;
		while ((val = fis.readLine()) != null) {
			String out = eval(val);
			System.out.println("Case #" + caseNum + ": " + out);
			caseNum++;
		}

	}

	private static String eval(String val) {
		String[] vals = val.split(" ");
		int a = Integer.parseInt(vals[0]);
		int b = Integer.parseInt(vals[1]);
		
		int out = 0;
		ArrayList<String> ss = new ArrayList<String>();
		
		if (b > 10 && a != b) {
			for(int i = a; i <= b; i++) {
				//Are there any rotations of i which is less than b
				String m = "" + i;
				for(int j = 0; j < m.length()-1; j++) {
					m = m.substring(1) + m.substring(0, 1);
					if(m.startsWith("0")) {
						continue;
					}
					int n = Integer.parseInt(m);
					if(n <= b && n > i) {
						String v = i  + " , " + m;
						if(!ss.contains(v)) {
							//Skip cases such as ???????1212 , 2121
							ss.add(v);
							out++;
						}
						
					}
				}
			}
		}
		
		return "" + out;
	}
	

}
