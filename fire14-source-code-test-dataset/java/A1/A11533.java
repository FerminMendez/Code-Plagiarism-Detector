import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {

	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader(new FileReader("/home/ramzy/Desktop/codejam/B-small.in"));
			PrintWriter output = new PrintWriter("/home/ramzy/Desktop/codejam/B-large.in");
			String line = input.readLine();
			int T = Integer.valueOf(line);
			for(int i = 1; i <= T; i++) {
				line = input.readLine();
				String[] values = line.split(" ");
				int N = Integer.valueOf(values[0]);
				int S = Integer.valueOf(values[1]);
				int p = Integer.valueOf(values[2]);
				int[] nums = new int[N];
				for(int j = 0; j < N; j++) {
					nums[j] = Integer.valueOf(values[3+j]); 
				}
				Arrays.sort(nums);
				int result = 0;
				for(int j = N-1; j >= 0; j--) {
					if(p == 0) {
						result++;
					} else if(p == 1) {
						if(nums[j] < 1)
							break;
						else
							result++;
					}else if(nums[j] > (p-1)*3) {
						result++;
					} else if(nums[j] > (p-2)*2 + (p-1) && S > 0) {
						result++;
						S--;
					} else if(S < 0) {
						break;
					}
				}
				
				output.println("Case #" + i + ": " + result);
				System.out.println("Case #" + i + ": " + result);
				
			}
			output.close();
			input.close();
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
}
