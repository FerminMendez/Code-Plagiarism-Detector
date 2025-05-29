import java.io.*;
import java.util.InputMismatchException;

/**
 * Created with IntelliJ IDEA.
 * User: IIoTeP9HuY
 * Date: 14.04.12
 * Time: 5:25
 * To change this template use File | Settings | File Templates.
 */

public class Solver {

    static int getTripleType(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0)
            return 0;
        if (a > 10 || b > 10 || c > 10)
            return 0;
        if (Math.abs(a - b) > 2 || Math.abs(a - c) > 2 || Math.abs(b - c) > 2)
            return 0;
        if (Math.abs(a - b) == 2 || Math.abs(a - c) == 2 || Math.abs(b - c) == 2)
            return 2;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(new FileInputStream("input.txt"));
        OutputWriter out = new OutputWriter(new FileOutputStream("output.txt"));
        int testCases = in.readInt();
        for(int t = 1; t <= testCases; t++) {
            int N = in.readInt();
            int S = in.readInt();
            int p = in.readInt();
            int[] score = new int[N];
            int bestResultNumber = 0;
            for(int i = 0; i < N; i++) {
                score[i] = in.readInt();
                boolean canWithSurprise = false;
                boolean canWithoutSurprise = false;
                for(int firstScore = 0; firstScore <= score[i]; firstScore++) {
                    for(int secondScore = 0; secondScore + firstScore <= score[i]; secondScore++) {
                        int thirdScore = score[i] - firstScore - secondScore;
                        int tripleType = getTripleType(firstScore, secondScore, thirdScore);
                        if (tripleType == 0)
                            continue;
                        if (firstScore < p && secondScore < p && thirdScore < p)
                            continue;
                        if (tripleType == 2 && S <= 0)
                            continue;

                        if (tripleType == 1)
                            canWithoutSurprise = true;
                        else
                            canWithSurprise = true;
                    }
                }
                if (canWithoutSurprise)
                    bestResultNumber++;
                else
                if (canWithSurprise && S > 0) {
                    bestResultNumber++;
                    S--;
                }
            }
            out.print("Case #" + t + ": " + bestResultNumber + "\n");
        }
        out.close();
    }
}

class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public static boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(outputStream);
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

}

