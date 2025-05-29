import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DancingWiththeGooglers {
	public static void main(String[] args) {
		try {
			FileWriter w = new FileWriter(new File("E:\\output.out"));
			BufferedReader r = new BufferedReader(new FileReader(new File("E:\\B-small-attempt2.in")));
			int numbeOfCases = Integer.parseInt(r.readLine());
			for(int t = 0; t < numbeOfCases; t++) {
				String[] nums = r.readLine().split(" ");
				int s = Integer.parseInt(nums[1]);
				int p = Integer.parseInt(nums[2]);
				
				int mid = Math.max(0, 3 * p - 2);
				int min = Math.max(0, 3 * p - 4);
				int number = 0;
				for(int i = 3; i < nums.length; i++) {
					int score = Integer.parseInt(nums[i]);
					if(p <= score) {
						if(score >= mid)
							number++;
						else if (score >= min && s > 0) {
							s--;
							number++;
						}
					}
				}
				
				w.write("Case #" + (t + 1) + ": " + (number));
				//System.out.println("Case #" + (t + 1) + ": " + (number));
				if(t < numbeOfCases - 1)
					w.write("\n");
				//System.out.println(t);
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
