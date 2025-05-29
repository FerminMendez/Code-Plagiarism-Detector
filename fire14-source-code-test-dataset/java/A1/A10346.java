import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n; // # googlers
		int s; // surprising
		int p; // score
		int scores[];
		int max;
		int min;
		int ret;

		BufferedReader br = new BufferedReader(new FileReader("b.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("b.out"));
		StringTokenizer tk;

		int tests = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= tests; t++) {
			tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());
			s = Integer.parseInt(tk.nextToken());
			p = Integer.parseInt(tk.nextToken());

			max = 3 * p - 2;
			min = 3 * p - 4;

			ret = 0;
			scores = new int[n];
			for (int j = 0; j < scores.length; j++)
				scores[j] = Integer.parseInt(tk.nextToken());

			Arrays.sort(scores);

			if (p >= 2)
				for (int i = scores.length - 1; i >= 0; i--) {
					if (scores[i] >= max)
						ret++;
					else if (scores[i] < min)
						break;
					else {
						
						if (s==0)break;
						ret++;
						s--;
					}
				}

			else {
				if (p == 0)
					ret += scores.length;
				else
					for (int i = scores.length-1; i>=0; i--) {
						if (scores[i] > 0)
							ret++;
						else
							break;
					}

			}

//			System.out.println("Case #" + t + ": " + ret);
			bw.write("Case #" + t + ": " + ret);
			bw.newLine();

		}

		bw.close();
	}

}
