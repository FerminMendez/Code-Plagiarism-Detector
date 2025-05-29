import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class DancingWithGooglers {
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
			
			for (int i = 0; i < T; i++) {
				int N = s.nextInt();
				int S = s.nextInt();
				int p = s.nextInt();
				int[] ts = new int[N];
				
				for (int j = 0; j < N; j++) {
					ts[j] = s.nextInt();
				}
				
				DancingWithGooglers solve = new DancingWithGooglers(ts, S, p);
				
				pw.println(String.format("Case #%d: %d", (i+1), solve.compute()));
			}
			
			pw.close();
			
			System.out.println("Done !");
		} catch (Exception ex) {
			System.out.println("ERROR");
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	private int[] totals;
	private int surprising;
	private int max;
	
	public DancingWithGooglers(int[] totals, int surprising, int max) {
		this.totals = totals;
		this.surprising = surprising;
		this.max = max;
	}
	
	public int compute() {
		System.out.println("Trying...");
		
		int found = 0;
		int surprisingLeft = surprising;
		for (int i = 0; i < totals.length; i++) {
			int t = totals[i];
			System.out.println(String.format("S = %d, p = %d, t = %d", surprising, max, t));	
			boolean foundNormal = findNormal(t);
			boolean foundSurprising = findSurprising(t);
			
			if (foundNormal) found++;
			
			if (!foundNormal && foundSurprising && surprisingLeft > 0) {
				found++;
				surprisingLeft--;
			}
			
			System.out.println(String.format("#%d: %s / %s", (i+1), foundNormal, foundSurprising));
		}
		System.out.println(String.format("Suprising left : %d", surprisingLeft));
		System.out.println("----------------------------");
		return found;
	}
	
	private boolean findNormal(int total) {
		boolean result = false;
		for (int s1 = 10; s1 >= 0; s1--) {
			if (s1 > total) continue;
			for (int s2 = s1; s2 >= Math.max(s1-1,  0); s2--) {
				if (s1 + s2 > total) continue;
				for (int s3 = s2; s3 >= Math.max(s1-1,  0); s3--) {
					if (s1 + s2 + s3 != total) continue;
					
					if (s1 >= max || s2 >= max || s3 >= max) {
						System.out.println(String.format("%d %d %d", s1, s2, s3));
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	private boolean findSurprising(int total) {
		boolean result = false;
		for (int s1 = 10; s1 >= 0; s1--) {
			if (s1 > total) continue;
			for (int s2 = s1; s2 >= Math.max(s1-2,  0); s2--) {
				if (s1 + s2 > total) continue;
				for (int s3 = s2; s3 >= Math.max(s1-2,  0); s3--) {
					if (s1 + s2 + s3 != total) continue;
					
					if (s1-s3 != 2) continue;
						
					if (s1 >= max || s2 >= max || s3 >= max) {
						System.out.println(String.format("%d %d %d (*)", s1,s2,s3));
						result = true;
					}
				}
			}
		}
		return result;
	}
}
