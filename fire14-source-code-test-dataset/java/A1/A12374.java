import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nova
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("B.input.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("B.output.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int numberOfTests = in.nextInt();
        for (int testNum = 1; testNum <= numberOfTests; testNum++) {
            out.print("Case #" + testNum + ": ");
            int res = 0;
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < n; i++) {
                int cc = a[i] / 3;
                if (a[i] % 3 != 0) cc++;
                if (cc >= p) res++;
                else if (s > 0) {
                    cc = a[i] / 3;
                    if (a[i] % 3 == 0 && cc > 0) cc++;
                    if (a[i] % 3 == 1) cc++;
                    if (a[i] % 3 == 2) cc += 2;
                    if (cc >= p) {
                        res++;
                        s--;
                    }
                }
            }
            out.println(res);
        }
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
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

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            writer.print(objects[i]);
        }
    }

    public void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }
}

