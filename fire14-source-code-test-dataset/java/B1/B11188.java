import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Recycling {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C-small-attempt0.in");
		Scanner in = new Scanner(file);
		
		int cases = in.nextInt();
		
		for (int i = 0; i < cases; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int pairs = 0;
			while (A < B) {
				String perm = A+"";
				for (int j = 1; j < perm.length(); j++) {
					String x = perm.substring(0,j);
					String y = perm.substring(j,perm.length());
					String out = y+x;
					int testCase = Integer.parseInt(out);
					if (A < testCase && testCase <= B ) {
						pairs++;
						
					}
				}
				
				A++;
			}
			
			
			System.out.println("Case #"+ (i+1) + ": " + pairs);
		}
		
	}
}
