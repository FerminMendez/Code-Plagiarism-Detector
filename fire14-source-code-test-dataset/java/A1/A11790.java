import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

class dancing {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"output.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for (int k = 1; k < cases; k++) {
			st = new StringTokenizer(f.readLine());
			int memSum = Integer.parseInt(st.nextToken());
			int surprising = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			int[] scores = new int[memSum];
			for (int i = 0; i < memSum; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			int max = getMax(memSum, surprising, level, scores);
			out.println("Case #" + k + ": " + max); // output result
		}
		
		st = new StringTokenizer(f.readLine());
		int memSum = Integer.parseInt(st.nextToken());
		int surprising = Integer.parseInt(st.nextToken());
		int level = Integer.parseInt(st.nextToken());
		int[] scores = new int[memSum];
		for (int i = 0; i < memSum; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		int max = getMax(memSum, surprising, level, scores);
		out.print("Case #" + cases + ": " + max); // output result
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

	public static int getMax(int _memSum, int _surprising, int _level,
			int[] _scores) {
		int[] scores = _scores;
		int memSum = _memSum;
		int surprising = _surprising;
		int level = _level;
		int max = 0;
		int certainStart = level * 3 - 2;
		int certainEnd = 30;
		int maybeStart = level * 3 - 4;
		int maybeEnd = level * 3 + 4;
		
		if(certainStart < 0)
		{
			certainStart = level;
		}
		
		if(maybeStart < 0)
		{
			maybeStart = level;
		}
		
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] <= certainEnd && scores[i] >= certainStart) {
				max++;
			} else {
				if (surprising > 0) {
					if (scores[i] <= maybeEnd && scores[i] >= maybeStart) {
						max++;
						surprising--;
					}
				}
			}
		}
		return max;
	}
}