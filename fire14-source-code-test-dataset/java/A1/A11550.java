package world2012.qualification;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	public static boolean canPass(int[] t, int p) {
		if (t[0] < 0 || t[1] < 0 || t[2] < 0)
			return false;
		return t[0] >= p || t[1] >= p || t[2] >= p; 
	}

	public static int maxGooglers(int[] scores, int p, int s) {
		B b = new B();
		Triple[] ts = new Triple[scores.length];
		for (int i = 0; i < scores.length; i++) {
			ts[i] = b.new Triple(scores[i]);
		}
		
		int count = 0;
		int surpr = 0;
		for (Triple t : ts) {
			if (canPass(t.triple, p))
				count++;
			else if (canPass(t.sTriple, p))
				surpr++;
		}
		
		return count + Math.min(surpr, s);
	}
	
	static PrintWriter out;

	public static void parseInput() throws Exception {
		String file = "world2012/qualification/B-small-attempt1.in";
//		String file = "input.in";
		Scanner scanner = new Scanner(new File(file));
		out = new PrintWriter(new FileWriter((file.replaceAll(".in", ""))));
		
		int T = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < T; i++) {
			String[] in = scanner.nextLine().split("\\s");
			int N = Integer.parseInt(in[0]);
			int S = Integer.parseInt(in[1]);
			int P = Integer.parseInt(in[2]);
			int[] scores = new int[N];
			for (int j = 0; j < N; j++) {
				scores[j] = Integer.parseInt(in[j + 3]);
			}
			
			int r = maxGooglers(scores, P, S);
			out.println("Case #"+(i+1)+": "+r+"");
		}
	}
	
	public static void main(String[] args) throws Exception {
		parseInput();
		out.close();
		System.out.println("Done!");
	}

	class Triple {
		
		int[] triple;
		int[] sTriple;
		int score;
		
		public Triple(int score) {
			this.score = score;
			init();
		}
		
		private void init() {
			if (score % 3 == 2) {
				int l = score / 3;
				int b = score / 3 + 1;
				triple = new int[] {b, b, l};
				sTriple = new int[] {b + 1, b - 1, l};
			} else if (score % 3 == 1) {
				int l = score / 3;
				int b = score / 3 + 1;
				triple = new int[] {b, l, l};
				sTriple = new int[] {b, b, l - 1};
			} else {
				int l = score / 3;
				triple = new int[] {l, l, l};
				sTriple = new int[] {l + 1, l, l - 1};
			}
		}
	}

}
