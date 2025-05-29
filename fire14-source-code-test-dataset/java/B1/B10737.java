import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;

public class ProblemB {

	BufferedReader input;
	BufferedWriter output;

	public static void main(String[] args) {
		(new ProblemB()).solve();
	}

	private void solve() {
		try {
			input = new BufferedReader(new FileReader("E://Technical/eclipse/workspace/CodeJam2012/input/C-small-attempt0.in"));
			output = new BufferedWriter(new FileWriter("E://Technical/eclipse/workspace/CodeJam2012/output/problemB.out"));

			int T = Integer.parseInt(input.readLine());

			for(int i=0; i < T; i++) {

				String[] t = input.readLine().split(" ");

				long A = Long.parseLong(t[0]);
				long B = Long.parseLong(t[1]);

				long y = 0;
				HashSet o = new HashSet();

				for(long j = A; j <= B; j++) {
					if(j>9) calculate(j, A, B,o);
				}

				y = o.size() / 2;
				output.write("Case #" + (i + 1) + ": " + y + "\n");
			}

			output.flush();
			System.out.println("completed");
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

	public void calculate(long number, long A, long B, HashSet o)
	{
		long y = 0;
		long t = number;

		int n = (int) Math.log10((double)number);
		int m = (int) Math.pow(10.0, (double)n);
		
		while(true)
		{
			long r = number % 10;

			number = number / 10;
			number = number + m * r;

			if(number != t && number >= A && number <= B) {
				o.add(t+":"+number);
				o.add(number+":"+t);
			}

			if(number == t)
				break;
		}
	}	
}
