import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class RecycledNumbers {
	public static void main(String[] args) {
		try {
			FileWriter w = new FileWriter(new File("E:\\output.out"));
			BufferedReader r = new BufferedReader(new FileReader(new File("E:\\C-small-attempt0.in")));
			int numbeOfCases = Integer.parseInt(r.readLine());
			for(int t = 0; t < numbeOfCases; t++) {
				String[] nums = r.readLine().split(" ");
				int b = Integer.parseInt(nums[1]);
				int a = Integer.parseInt(nums[0]);
				int number = 0;
				HashMap<String, String> f = new HashMap<String, String>();
				for(int n = a, digits = nums[0].length(), max = (int) (Math.pow(10, digits) - 1); n < max; n++)
					for(int j = 1; j < digits; j++)
						if(n % Math.pow(10, j) >= Math.pow(10, j - 1)) {
							int m = (int) ((n % Math.pow(10, j)) * (Math.pow(10, digits - j)) + n / Math.pow(10, j));
							if(m > n  && m <= b && !f.containsKey(m + "," + n) && !f.containsKey(n + "," + m)) {
								number++;
								f.put(m + "," + n,"");
								f.put(n + "," + m,"");
							}
						}
				w.write("Case #" + (t + 1) + ": " + number);
				if(t < numbeOfCases - 1)
					w.write("\n");
			}
			w.close();
			r.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}