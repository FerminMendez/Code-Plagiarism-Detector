import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Set;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.Writer;
import java.math.BigInteger;
import java.util.HashSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("C-small-attempt0.in");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("recyclednumbers.out");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		StreamInputReader in = new StreamInputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		RecycledNumbers solver = new RecycledNumbers();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class RecycledNumbers {
	public void solve(int testNumber, StreamInputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        
        int A = in.readInt(), B = in.readInt();
        int P = 10;
        while (A / P > 0) {
            P *= 10;
        }

        int res = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = A; i < B; ++i) {
            int p = 10;
            set.clear();
            while (p < P) {
                int j = (i % p) * (P / p) + (i / p);
                if (j <= B && i < j && j / (P / 10) > 0) {
                    set.add(j);
                }
                p *= 10;
            }
            res += set.size();
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

