import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class C {

	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader(new FileReader("/home/ramzy/Desktop/codejam/C-small.in"));
			PrintWriter output = new PrintWriter("/home/ramzy/Desktop/codejam/C-small.out");
			String line = input.readLine();
			int T = Integer.valueOf(line);
			for(int i = 0; i < T; i++) {
				line = input.readLine();
				String[] numbers = line.split(" ");
				int A = Integer.valueOf(numbers[0]);
				int B = Integer.valueOf(numbers[1]);
				int result = 0;
				ArrayList<String> chosen = new ArrayList<String>();
				for(int j = A; j <= B; j++) {
					String str = String.valueOf(j);
					for(int k = 1; k < str.length(); k++) {
						int n = Integer.valueOf(str.substring(k) + str.substring(0, k));
						if(n >= A && n<= B && n != j && !chosen.contains(n + " " + j) && !chosen.contains(j + " " + n)) {
							chosen.add(n + " " + j);
							result++;
						}
					}
				}
				output.println("Case #" + (i+1) + ": " + result);
				System.out.println("Case #" + (i+1) + ": " + result);
			}
			output.close();
			input.close();
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
}
