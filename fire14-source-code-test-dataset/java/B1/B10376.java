import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class RecycledPairs {
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			HashSet<Integer> seen = new HashSet<Integer>();
			
			int T = Integer.parseInt(br.readLine());
			for (int t=1; t<=T; t++) {
				String[] nums = br.readLine().split("\\s+");
				int A = Integer.parseInt(nums[0]);
				int B = Integer.parseInt(nums[1]);
				int tally = 0;
				for (int i=A; i<=B; i++) {
					String istr = Integer.toString(i);
					seen = new HashSet<Integer>();
					for (int j=1; j<istr.length(); j++) {
						istr = istr.substring(1) + istr.substring(0,1);
						int newi = Integer.parseInt(istr);
						//System.out.println(newi);
						if ((newi > i) && (newi <= B)) {
							if (seen.add(newi)) {
								tally++;
								//System.out.println(i + " " + newi);
							}
						}
					}
				}
				System.out.println("Case #" + t + ": " + tally);
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
}
