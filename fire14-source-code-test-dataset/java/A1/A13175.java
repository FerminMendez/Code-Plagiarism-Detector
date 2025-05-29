import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class DancingWithGooglers {

	/**
	 * @param args
	 */
	private final static String WRITE_DEST = "C:\\Users\\mkobit\\Documents\\GoogleCodeJam2012\\Dancing With the Googlers\\out.txt";
	public static void main(String[] args) {
		int T;	// T test cases
		int N;	// number of Googlers
		int S;	// surprising number of scores
		int p;	// best result score
		int howManyP = 0;
		BufferedReader in;
		PrintWriter outfile;
		try {
			in = new BufferedReader(new FileReader(args[0]));
			outfile = new PrintWriter(new FileWriter(WRITE_DEST));
			String text = in.readLine();
			T = Integer.parseInt(text);
			for (int i = 0; i < T; i++) {
				// for each test case
				howManyP = 0;
				text = in.readLine();
				//System.out.println(text);
				StringTokenizer token = new StringTokenizer(text, " ");
				N = Integer.parseInt(token.nextToken());
				S = Integer.parseInt(token.nextToken());
				p = Integer.parseInt(token.nextToken());
				//System.out.println(N);
				//System.out.println(S);
				//System.out.println("case=" + (i+1) + " p=" + p + " strange=" + S);
				while (token.hasMoreTokens()) {
					String s = token.nextToken();
					//System.out.print(s + " ");
					int score = Integer.parseInt(s);
					Googler goog = new Googler(score);
					if (goog.hasHighScore(p)) {
						//System.out.print(goog + " ");
						howManyP++;
					} else if (S > 0 && goog.weirdHighScore(p)) {
						//System.out.print(goog + " ");
						howManyP++;
						S--;
					} else {
						//System.out.print(goog + " ");
					}
				}
				//System.out.println("withp=" + howManyP);
				// write output to file
				String s = String.format("Case #%d: %d\n", i + 1, howManyP);
				outfile.write(s);
				//System.out.println(howManyP);
			}
			in.close();
			outfile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
