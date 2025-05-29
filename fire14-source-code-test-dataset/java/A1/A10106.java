package my.codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author "Dzianis Siarheyeu" <denser.by@gmail.com>
 * 
 */
public class TaskB {

	private final static boolean DEBUG_OUTPUT = true;

	static class Combo {
		final int[] sequence;
		final boolean surprise;
		final int sum;
		final int min, max;
		final boolean usual;

		public Combo(int[] sequence, boolean surprise) {
			super();
			this.sequence = sequence;
			this.surprise = surprise;

			int sumX = 0;
			for (int i = 0; i < sequence.length; i++) {
				sumX += sequence[i];
			}
			this.sum = sumX;

			this.min = Math
					.min(sequence[2], Math.min(sequence[0], sequence[1]));
			this.max = Math
					.max(sequence[2], Math.max(sequence[0], sequence[1]));

			if (max - min > 2) {
				throw new IllegalStateException("Wrong combo.");
			}
			this.usual = max - min <= 1;
		}

		public Combo(int b1, int b2, int b3) {
			this.sequence = new int[3];
			sequence[0] = b1;
			sequence[1] = b2;
			sequence[2] = b3;
			surprise = Math.abs(b1 - b2) + Math.abs(b2 - b3) == 2 ? true
					: false;

			this.sum = b1 + b2 + b3;
			this.min = Math.min(b3, Math.min(b1, b2));
			this.max = Math.max(b3, Math.max(b1, b2));

			if (max - min > 2) {
				throw new IllegalStateException("Wrong combo.");
			}
			this.usual = max - min <= 1;

		}

		public boolean isUsual() {
			return usual;
		}

		public int getMin() {
			return min;
		}

		public int getMax() {
			return max;
		}

		public int getSum() {
			return sum;
		}

		public int[] getSequence() {
			return sequence;
		}

		public boolean isSurprise() {
			return surprise;
		}

		@Override
		public String toString() {
			return "Combo [max=" + max + ", min=" + min + ", sequence="
					+ Arrays.toString(sequence) + ", sum=" + sum
					+ ", surprise=" + surprise + "]";
		}

	}

	static class Score {
		final int sum;
		final Combo usual;
		final Combo su;

		public Score(Combo usual, Combo su) {
			super();
			this.sum = usual.getSum();
			this.usual = usual;
			this.su = su;

			if (usual.isUsual() == false) {
				throw new IllegalStateException(
						"Unfortunately usual is unusual...   usual=" + usual
								+ "   su=" + su);
			}
		}

		public int getSum() {
			return sum;
		}

		public Combo getUsual() {
			return usual;
		}

		public Combo getSu() {
			return su;
		}

		@Override
		public String toString() {
			return "Score [\nsu=" + su + ", sum=" + sum + ", \nusual=" + usual
					+ "]";
		}

	}

	static class ScoreBase {

		Map<Integer, Score> base = new HashMap<Integer, Score>();

		{
			base.put(0, new Score(new Combo(0, 0, 0), null));
			base.put(1, new Score(new Combo(0, 0, 1), null));
			base.put(2, new Score(new Combo(0, 1, 1), new Combo(0, 0, 2)));
			base.put(3, new Score(new Combo(1, 1, 1), new Combo(0, 1, 2)));
			base.put(4, new Score(new Combo(1, 1, 2), new Combo(0, 2, 2)));
			base.put(5, new Score(new Combo(1, 2, 2), new Combo(1, 1, 3)));
			base.put(6, new Score(new Combo(2, 2, 2), new Combo(1, 2, 3)));
			base.put(7, new Score(new Combo(2, 2, 3), new Combo(1, 3, 3)));
			base.put(8, new Score(new Combo(2, 3, 3), new Combo(2, 2, 4)));
			base.put(9, new Score(new Combo(3, 3, 3), new Combo(2, 3, 4)));
			base.put(10, new Score(new Combo(3, 3, 4), new Combo(2, 4, 4)));
			base.put(11, new Score(new Combo(3, 4, 4), new Combo(3, 3, 5)));
			base.put(12, new Score(new Combo(4, 4, 4), new Combo(3, 4, 5)));
			base.put(13, new Score(new Combo(4, 4, 5), new Combo(3, 5, 5)));
			base.put(14, new Score(new Combo(4, 5, 5), new Combo(4, 4, 6)));
			base.put(15, new Score(new Combo(5, 5, 5), new Combo(4, 5, 6)));
			base.put(16, new Score(new Combo(5, 5, 6), new Combo(4, 6, 6)));
			base.put(17, new Score(new Combo(5, 6, 6), new Combo(5, 5, 7)));
			base.put(18, new Score(new Combo(6, 6, 6), new Combo(5, 6, 7)));
			base.put(19, new Score(new Combo(6, 6, 7), new Combo(5, 7, 7)));
			base.put(20, new Score(new Combo(6, 7, 7), new Combo(6, 6, 8)));
			base.put(21, new Score(new Combo(7, 7, 7), new Combo(6, 7, 8)));
			base.put(22, new Score(new Combo(7, 7, 8), new Combo(6, 8, 8)));
			base.put(23, new Score(new Combo(7, 8, 8), new Combo(7, 7, 9)));
			base.put(24, new Score(new Combo(8, 8, 8), new Combo(7, 8, 9)));
			base.put(25, new Score(new Combo(8, 8, 9), new Combo(7, 9, 9)));
			base.put(26, new Score(new Combo(8, 9, 9), new Combo(8, 8, 10)));
			base.put(27, new Score(new Combo(9, 9, 9), new Combo(8, 9, 10)));
			base.put(28, new Score(new Combo(9, 9, 10), new Combo(8, 10, 10)));
			base.put(29, new Score(new Combo(9, 10, 10), null));
			base.put(30, new Score(new Combo(10, 10, 10), null));
		}

		Map<Integer, Score> getMap() {
			return base;
		}

		int getMaxPlayers(int N, int S, int P, int[] Ti) {

			// System.out.println("getMaxPlayers()   N=" + N + " S=" + S + " P="
			// + P + " Ti=" + Arrays.toString(Ti));

			int res = 0;
			int surprisedNotUsed = S;

			for (int t : Ti) {
				Score cur = base.get(t);

				Combo usual = cur.getUsual();
				if (usual.getMax() >= P) {
					res++;

					// System.out.println("" + usual.getSum() + " "
					// + Arrays.toString(usual.getSequence()));
					continue;

				} else {
					if (surprisedNotUsed > 0) {
						Combo su = cur.getSu();
						if (su != null && su.getMax() >= P) {
							res++;
							surprisedNotUsed--;
							// System.out.println("" + su.getSum() + " "
							// + Arrays.toString(su.getSequence()) + " *");
							continue;

						}
					}
				}

				// System.out.println(" t="
				// + t
				// + " "
				// + Arrays.toString(cur.usual.getSequence())
				// + " "
				// + (cur.su != null ? Arrays.toString(cur.su
				// .getSequence())
				// + "*" : "NULL"));

			}

			// System.out.println("getMaxPlayers()   res=" + res + "\n");

			return res;
		}

		String getInfo() {
			StringBuffer buf = new StringBuffer();

			for (int i = 0; i < 30; i++) {
				Score score = base.get(i);

				buf.append("\n   i=" + i + "   score=" + score + "\n");
			}

			return buf.toString();
		}

	}

	static void reportError(String text) {
		System.out.println("ERR " + text);
	}

	private static String getOutFileName(String inFileName) {
		String outFileName = inFileName.replace(".in", ".out");
		return outFileName;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");

		String filePath = "/home/dsa/Downloads/B-small-attempt1.in";
		String filePathOut = getOutFileName(filePath);

		File file = new File(filePath);
		File fileOut = new File(filePathOut);

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(fileOut);

		if (DEBUG_OUTPUT) {
			System.out.println("----------------------------------------");
		}

		ScoreBase scoreBase = new ScoreBase();

		// String info = scoreBase.getInfo();
		// System.out.println("   info=" + info);

		MyReader myReader = new MyReader(scoreBase);
		int item;
		while ((item = fis.read()) > 0) {
			char ch = (char) item;

			if (DEBUG_OUTPUT) {
				System.out.print(ch);
			}

			myReader.feedItem(ch);
		}
		myReader.endOfInputReached();

		fis.close();

		if (DEBUG_OUTPUT) {
			System.out.println("----------------------------------------");
		}

		List<Integer> output = myReader.getOutput();
		long testCaseCount = 0;

		for (Integer testCase : output) {
			testCaseCount++;

			String s1 = "Case #" + testCaseCount + ": " + testCase + "\n";
			if (DEBUG_OUTPUT) {
				System.out.print(s1);
			}
			fos.write(s1.getBytes());
		}

		fos.flush();
		fos.close();

	}

	static class MyReader {

		ScoreBase scoreBase = new ScoreBase();

		public MyReader(ScoreBase scoreBase) {
			super();
			this.scoreBase = scoreBase;
		}

		enum MyReaderState {
			NOT_USED, FIRST_LINE, DATA_LINE, FINISHED;
		};

		MyReaderState curState = MyReaderState.NOT_USED;
		StringBuffer curWordContent = new StringBuffer();
		int casesNumber = -1;
		List<Integer> output = new ArrayList<Integer>();
		List<String> curLine = new ArrayList<String>();

		void endOfInputReached() {
			// if (curLineReverse.size() > 0 || curWordContent.length() > 0) {
			// processLine();
			// }
		}

		List<Integer> getOutput() {
			return output;
		}

		void feedItem(char ch) {

			// if (DEBUG_OUTPUT) {
			// System.out.println("feedItem()  ch=\"" + ch + "\""
			// + "   curWordContent=" + curWordContent.toString());
			// }

			if (ch == '\r')
				return;

			switch (curState) {
			case NOT_USED:
				if (ch == '\n') {
					throw new IllegalStateException(
							"Input file can't start with empty first line.");
				}
				curState = MyReaderState.FIRST_LINE;
				curWordContent.append(ch);
				break;

			case FIRST_LINE:
				if (ch == '\n') {
					curState = MyReaderState.DATA_LINE;
					casesNumber = Integer.parseInt(curWordContent.toString());
					System.out.println("First line parsed: casesNumber="
							+ casesNumber);
					curWordContent.setLength(0);
				} else {
					curWordContent.append(ch);
				}
				break;

			case DATA_LINE:
				switch (ch) {

				case '\n':
					processDataLine();
					break;

				default:
					curWordContent.append(ch);
					break;
				}
				break;

			default:
				break;
			}
		}

		private void processDataLine() {

			String curLine = curWordContent.toString();
			String[] curLineParts = curLine.split(" ");
			int[] intParts = new int[curLineParts.length];

			for (int i = 0; i < curLineParts.length; i++) {
				intParts[i] = Integer.parseInt(curLineParts[i]);
			}
			// System.out.println("processDataLine()   curLine=" + curLine);

			int N = intParts[0];
			int S = intParts[1];
			int P = intParts[2];
			int[] Ti = new int[intParts.length - 3];
			System.arraycopy(intParts, 3, Ti, 0, Ti.length);

			// System.out.println("processDataLine()   N=" + N + " S=" + S +
			// " P="
			// + P + " Ti=" + Arrays.toString(Ti));

			curWordContent.setLength(0);

			int maxPlayers = scoreBase.getMaxPlayers(N, S, P, Ti);
			// System.out.println("processDataLine()   maxPlayers=" +
			// maxPlayers);

			output.add(maxPlayers);
		}
	}

}
