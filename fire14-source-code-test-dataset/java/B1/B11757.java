import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;


public class RecycledNumbers {

	public static void main(String[] args) {
		try {
			File output = new File("output.txt");
			
			if (output.exists()) {
				output.delete();
			}
			
			PrintWriter pw = new PrintWriter(output);
			
			Scanner s = new Scanner(new FileInputStream("input.txt"));
		
			int T = s.nextInt();
			s.nextLine();
			
			for (int c = 0; c < T; c++) {
				int start = s.nextInt();
				int end = s.nextInt();
				
				int digits = digits(start);
				
				System.out.println(String.format("%d - %d (%d)", start, end, digits));
				
				int found = 0;
				
				for (int n = start; n < end; n++) {
					int m = n;
					HashSet<Integer> pairs = new HashSet<>();
					for (int i = 0; i < digits; i++) {
						m = rotate(m, digits);
						
						if (m <= n) continue;
						
						if (m >= start && m <= end && !pairs.contains(m)) {
							pairs.add(m);
							found++;
							//System.out.println(String.format("%d - %d", n, m));
						}
					}
				}
				
				// 
				

				pw.println(String.format("Case #%d: %d", (c+1), found));
				
				System.out.println(String.format("Found %d numbers", found));
				
				
				System.out.println("---------------------");
			}
			
			// Read inputs and solve here
			
			pw.close();
			
			System.out.println("Done !");
			
			System.out.println(String.format("51234 rotated to %d", rotate(51234, 5)));
		} catch (Exception ex) {
			System.out.println("ERROR");
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	private static int digits(int n) {
		int d = 0;
		while (n > 0) {
			n /= 10;
			d++;
		}
		return d;
	}
	
	private static int rotate(int m, int digits) {
		if (digits == 1) return m;
		
		int left = m%10;
		
		m /= 10;
		
		m += left * (int)Math.pow(10, digits-1);
		
		return m;
	}
	
	public RecycledNumbers() {
	}
}
