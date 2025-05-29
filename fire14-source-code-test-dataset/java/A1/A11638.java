import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Dance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numCases = Integer.parseInt(br.readLine());
		for ( int i = 1; i <= numCases; i++ ) {
			String[] c = br.readLine().split(" ");
			int googlers = Integer.parseInt(c[0]);
			int exceptions = Integer.parseInt(c[1]);
			int target = Integer.parseInt(c[2]);
			int hits = 0;
			int potentials = 0;
			for ( int j = 3; j < (googlers + 3); j++ ) {
				int val = Integer.parseInt(c[j])
					, avg = val/3
					, mod = val%3
					, max = avg + (mod == 2 ? 2 : 1)
					, normalMax = (mod == 0 ? avg : avg + 1)
				;
				//				System.out.println("Checking " + val + " with avg " + avg + " and mod " + mod + " and max " + max + " and normal max " + normalMax);
				if ( (val == 0 && target > 0) || max < target ) {
					continue; // Unobtainable, discard
				}
				else if ( normalMax >= target ) {
					hits++;
				}
				else {
					potentials++;
				}
			}
			System.out.println("Case #" + i + ": " + (hits + (exceptions >= potentials ? potentials : exceptions)));
		}
	}
}