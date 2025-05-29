import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("B-small-attempt1.in"));
		PrintWriter writer = new PrintWriter(new File("output.txt"));
		int cases = reader.nextInt();
		for (int i=0; i<cases; i++) {
			int N = reader.nextInt();
			int S = reader.nextInt();
			int P = reader.nextInt();
			int[] G = new int[N];
			int X = 0;
			int K = 0;
			for (int j=0; j<N; j++) {
				G[j] = reader.nextInt();
				int score = G[j];
				int base =  (int) Math.ceil(G[j] /3);
				switch (score % 3) {
				case 0:
					if (base >= P) {
						X++;
					} else if (K < S && base > 0 && (base + 1) >= P) {
						K++;
						X++;
					}
					break;
				case 1:
					if (base >= P || (base + 1) >= P) {
						X++;
					} else if (K < S && (base + 1) >= P) {
						K++;
						X++;
					}
					break;
				case 2:
					if ((base + 1) >= P || base >= P) {
						X++;
					} else if (K < S && (base + 2) >= P) {
						K++;
						X++;
					}
					break;
				}
			}
			writer.println("Case #" + (i+1) + ": " + X);
		}
		System.out.println("done");
		reader.close();
		writer.close();
	}

}
