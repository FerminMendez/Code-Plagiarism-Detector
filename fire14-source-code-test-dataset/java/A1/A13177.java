import java.io.*;
import java.util.*;


public class DancingWithTheGooglers {

	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(new File("B-small.txt"));
		
		int cases;
		cases = in.nextInt();
		
		int google, s, p;
		int count;
		
		int temp;
		
		for (int n = 0; n < cases; n++) {
			google = in.nextInt();
			s = in.nextInt();
			p = in.nextInt();
			count = 0;
			
			for (int i = 0; i < google; i++) {
				temp = in.nextInt();
				
				if (p == 0) {
					count ++;
				} else if (p == 1 && temp == 0) {
					continue;
				} else if (temp/3 >= p) {
					count ++;
				} else if (temp/3 == p - 1 && temp%3 >= 1) {
					count ++;
				} else if (temp/3 == p - 1 && temp%3 == 0){
					if (s != 0) {
						count ++;
						s--;
					}
				} else if (temp/3 == p - 2 && temp%3 == 2) {
					if (s != 0) {
						count ++;
						s--;
					}
				}
			}			
			
			System.out.println("Case #" + (n+1) + ": " + count);
		}

	}
}