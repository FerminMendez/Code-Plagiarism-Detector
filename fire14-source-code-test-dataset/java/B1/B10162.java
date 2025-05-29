import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class QRProblemC {
	public static void main(String[] args) {
		try {
			char problem = 'C';
			int attempt = 1;
			BufferedReader input = new BufferedReader(new FileReader(problem + "-small-attempt" + attempt + ".in"));
			BufferedWriter output = new BufferedWriter(new FileWriter(problem + "-small-attempt" + attempt + ".out"));
			int lines = Integer.parseInt(input.readLine());
			for (int i = 0; i < lines; i++) {
				String in = input.readLine();
				System.out.println(in);
				String out = "";
				//Code here
				String[] numbers = in.split(" ");
				int A = Integer.parseInt(numbers[0]);
				int B = Integer.parseInt(numbers[1]);
				int count = 0;
				for (int n = A; n < B; n++) {
					for (int m = n + 1; m <= B; m++) {
						String goal = Integer.toString(m);
						String start = Integer.toString(n);
						while (start.length() < goal.length()) start = "0" + start;
						for (int j = 1; j < start.length(); j++) {
							if (start.charAt(j) == goal.charAt(0)) {
								if (goal.equals(start.substring(j) + start.substring(0, j))) {
									count++;
									break;
								}
							}
						}
					}
				}
				out = Integer.toString(count);
				//End code
				out = "Case #" + (i + 1) + ": " + out.trim();
				System.out.println(out);
				output.append(out);
				if (i < lines - 1) output.append("\n");
			}
			input.close();
			output.close();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
