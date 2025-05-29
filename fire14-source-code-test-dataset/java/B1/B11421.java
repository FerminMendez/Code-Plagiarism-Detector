import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Recycled {
	public static void main(String[] args) throws Exception{
		String inputFile = "C-small-attempt0.in";
		
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output")));
		long num_cases = Long.parseLong(input.readLine());
		int current_case = 0;
		
		while (current_case < num_cases){
			current_case++;
			
			String[] fields = input.readLine().split(" ");
			int A = Integer.parseInt(fields[0]);
			int B = Integer.parseInt(fields[1]);
			int total = 0;
			
			for (int n = A; n < B; n++){
				for (int m = n+1; m <= B; m++){
					if (isRecycled(n,m)) total++;
				}
			}
			
			System.out.println("Case #" + current_case + ": " + total);
			output.write("Case #" + current_case + ": " + total + "\n");
		}
		output.close();
	}

	private static boolean isRecycled(int n, int m) {
		String sn = ""+n;
		String sm = ""+m;
		if (sn.length() != sm.length()) return false;
		int totaln = 0, totalm = 0;
		for (int i = 0; i < sn.length(); i++){
			totaln += sn.charAt(i);
			totalm += sm.charAt(i);
		}
		if (totaln != totalm) return false;
		for (int i = 0; i < sn.length()-1; i++){
			sm = sm.charAt(sm.length() - 1) + sm.substring(0, sm.length() - 1);
			if (sm.equals(sn)) return true;
		}
		return false;
	}
}
