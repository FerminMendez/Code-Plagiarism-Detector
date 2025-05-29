import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solver {
	
	public static void main(String[] args) {
		try {
			FileInputStream fIS = new FileInputStream(args[0]);
			BufferedReader r = new BufferedReader(new InputStreamReader(fIS));
			
			int t = Integer.parseInt(r.readLine());
			for (int i=0;i<t;++i) {
				System.out.print("Case #" + (i+1) + ": ");
				if (i < t-1)
					System.out.println(solveTest(r.readLine()));
				else
					System.out.print(solveTest(r.readLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}

	private static int solveTest(String line) {
		String[] nums = line.split(" ");
		int n = Integer.parseInt(nums[0]);
		int s = Integer.parseInt(nums[1]);
		int p = Integer.parseInt(nums[2]);
		
		int[] scoresSums = new int[nums.length - 3];
		for (int i=3;i<nums.length;++i)
			scoresSums[i-3] = Integer.parseInt(nums[i]);
		
		int ok = 0;
		int okMin = notNegative(p-1) + notNegative(p-1) + p;
		
		for (int i=0;i<scoresSums.length;++i) {
			if (scoresSums[i] >= okMin)
				++ok;
		}
		
		int suprisings = 0;
		int sMin = notNegative(p-2)+notNegative(p-2)+p;
		for (int i=0;i<scoresSums.length;++i) {
			if (scoresSums[i] < okMin && scoresSums[i] >= sMin)
				++suprisings;
		}
		
		if (suprisings > s)
			suprisings = s;
		
		return ok + suprisings;
	}

	private static int notNegative(int i) {
		return (i < 0) ? 0 : i;
	}
}
