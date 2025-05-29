import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B {
	
	private static boolean isValid(int val) {
		int[] invalids = new int[] { 0,1,4,7,10,13,16,19,22,25,28 };
		for(int i = 0; i < invalids.length; i++) {
			if(invalids[i] == val) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = -1;
		
		int[] maxValue = new int[31];
		for(int i = 0; i < maxValue.length; i++) {
			maxValue[i] = (int)Math.ceil((double)i / 3.0);
		}
		try {
			t = Integer.parseInt(reader.readLine());
			for(int j = 0; j < t; j++) {
				
				String[] line = reader.readLine().split(" ");
				int n = Integer.parseInt(line[0]);
				int s = Integer.parseInt(line[1]);
				int p = Integer.parseInt(line[2]);
				
				int count = 0;
				for(int i = 0; i < n; i++) {
					int total = Integer.parseInt(line[3 + i]);
					int max = maxValue[total];
					if(max >= p) {
						count++;
					}
					else {
						if(s > 0 && isValid(total) && ((max + 1) == p)) {
							count++;
							s--;
						}
					}
				}
				System.out.println("Case #" + (j+1) + ": " + count);
			}
			
		}
		catch(IOException e) {}
	}
}
