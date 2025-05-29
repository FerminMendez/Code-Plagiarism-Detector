import java.io.IOException;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.Writer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("B-small-attempt1.in");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("dancinggooglers.out");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		StreamInputReader in = new StreamInputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		DancingGooglers solver = new DancingGooglers();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class DancingGooglers {
	public void solve(int testNumber, StreamInputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        
        int n = in.readInt(), s = in.readInt(), p = in.readInt();
        int res = 0;
        for(int i = 0; i < n; ++i) {
            int t = in.readInt();
            if (t >= 3 * Math.max(0, p-1) + 1 || t >= 3 * p || t >= Math.max(0, 3 * p - 1)) {
                ++res;
            }
            else if (s > 0 && t >= 3 * Math.max(0, p-2) + 2) {
                --s;
                ++res;
            }
        }
        
        out.printLine(res);
	}
}

class StreamInputReader extends InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public StreamInputReader(InputStream stream) {
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

abstract class InputReader {

	public abstract int read();

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

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String next() {
        return readString();
    }

    protected boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    }

