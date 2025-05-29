import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class DancingWithTheGooglers {

	public static void main(String[] args) throws FileNotFoundException {
	
		File input = new File("/home/michael/sandbox/codejam2012/dwtg-small.in.txt");
		File output = new File("/home/michael/sandbox/codejam2012/dwtg-small.out.txt");
		PrintWriter fout = new PrintWriter(output);
		Scanner s = new Scanner(input);
		int tests = s.nextInt();
		for( int t = 0; t < tests; t++ ) {
			int dancers = s.nextInt();
			int surprises = s.nextInt();
			int threshold = s.nextInt();
			int definites = 0;
			int potential_surprises = 0;
			for( int d = 0; d < dancers; d++ ) {
				int score = s.nextInt();
				int[] analysis = new int[2];
				process(score,analysis);
				if( analysis[0] >= threshold ) {
					if( analysis[0] == threshold && analysis[1] == 1 ) {
						potential_surprises++;
					} else {
						definites++;
					}
				}
			}
			fout.println( "Case #" + (t+1) + ": " +
								(definites + Math.min(surprises,potential_surprises)) );
		}
		fout.close();
	}
		
	//analysis[0] is the highest achievable individual score given
	//the total score; analysis[1] is 1 if that score would be
	//surprising and 0 otherwise
	private static void process(int score, int[] analysis) {
		analysis[1] = 0;
		int avg_score = score / 3;
		if( score < 2 ) { // special cases, since -1 is not a legal score
			analysis[0] = score;
		} else if( score > 28 ) { // also special cases; 11 is also illegal
			analysis[0] = 10;
		} else if( score % 3 == 0 ) {
			analysis[0] = avg_score + 1;
			analysis[1] = 1;
		} else if( score % 3 == 1 ) {
			analysis[0] = avg_score + 1;
			// not surprising
		} else if( score % 3 == 2 ) {
			analysis[0] = avg_score + 2;
			analysis[1] = 1;
		}
	}
}
