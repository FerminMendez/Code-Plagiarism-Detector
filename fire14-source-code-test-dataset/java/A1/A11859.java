import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Dancers {
	
	public static void main(final String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Input and output file must be given");
			return;
		}
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
			final List<TestCase> cases = parseInput(args[0]);
			for(final TestCase test : cases) {
				pw.println("Case #" + test.getCaseNum() + ": " + test.solve());
			}
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
	
	private static List<TestCase> parseInput(String filename) throws IOException {
		final List<TestCase> res = new ArrayList<TestCase>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			int caseNum = Integer.parseInt(br.readLine());
			for(int i = 0; i < caseNum; ++i) {
				String[] args = br.readLine().split("\\s");
				int n = Integer.parseInt(args[0]);
				int s = Integer.parseInt(args[1]);
				int p = Integer.parseInt(args[2]);
				int [] scores = new int[n];
				for(int j = 0; j < n; ++j) {
					scores[j] = Integer.parseInt(args[3 + j]);
				}
				res.add(new TestCase(i + 1, n, s, p, scores));
			}
		} finally {
			if(br != null) {
				br.close();
			}
		}
		return res;
	}

	private static class TestCase {
		private int caseNum;
		private int numberOfGooglers;
		private int suprisingTriplets;
		private int minBestResult;
		private int[] scores;
		
		public TestCase(int caseNum, int numberOfGooglers,
				int suprisingTriplets, int minBestResult, int[] scores) {
			super();
			this.caseNum = caseNum;
			this.numberOfGooglers = numberOfGooglers;
			this.suprisingTriplets = suprisingTriplets;
			this.minBestResult = minBestResult;
			this.scores = scores;
		}

		public int solve() {
			int res = 0;
			int [] x = new int[suprisingTriplets];
			for(int i = 0; i < suprisingTriplets; ++i) {
				x[i] = i;
			}
			
			while(true) {
				int maxGooglersForPermutation = countMaxGooglersForPermutation(x);
				res = Math.max(res, maxGooglersForPermutation);
				if(!nextPermutation(x)) {
					break;
				}
			}
			return res;
		}

		private boolean nextPermutation(int[] x) {
			int k = -1;
			for(int i = suprisingTriplets - 1; i >= 0; --i) {
				if(x[i] < numberOfGooglers + suprisingTriplets - i) {
					k = i;
					break;
				}
			}
			if(k >= 0) {
				x[k]++;
				for(int i = k + 1; i < suprisingTriplets; ++i) {
					x[i] = x[k] + i - k;
				}
			}
			return k >= 0;
		}

		private int countMaxGooglersForPermutation(int[] arr) {
			List<Integer> x = new ArrayList<Integer>();
			for(int i = 0; i < suprisingTriplets; ++i) {
				x.add(arr[i]);
			}
			int res = 0;
			for(int i = 0; i < numberOfGooglers; ++i) {
				int score = scores[i];
				int maxForGoogler = -1;
				if(x.contains(i)) {
					maxForGoogler = countMaxForSuprising(score);
				} else {
					maxForGoogler = countMaxForNotSuprising(score);
				}
				if(maxForGoogler >= minBestResult) {
					++res;
				}
			}
			return res;
		}

		private int countMaxForNotSuprising(int score) {
			if(score % 3 == 0) {
				return score / 3;
			} else if(score % 3 == 1) {
				return ((score - 1) / 3) + 1;
			} else {
				return ((score - 2) / 3) + 1;
			}
		}

		private int countMaxForSuprising(int score) {
			if(score % 3 == 0) {
				return score == 0 ? -1 : ((score - 3) / 3) + 2;
			} else if(score % 3 == 1) {
				return score == 1 ? -1 : ((score - 4) / 3) + 2;
			} else {
				return ((score - 2) / 3) + 2;
			}
		}

		public int getCaseNum() {
			return caseNum;
		}

	}
}
