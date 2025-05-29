import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.Writer;
import java.util.StringTokenizer;
import java.util.HashSet;
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
			inputStream = new FileInputStream("C.input.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("C.output.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int numberOfTests = in.nextInt();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int testNum = 1; testNum <= numberOfTests; testNum++) {
            out.print("Case #" + testNum + ": ");

            int a = in.nextInt();
            int b = in.nextInt();
            int res = 0;

            for (int num = a; num <= b; num++) {
                StringBuilder sb = new StringBuilder();
                String s = String.valueOf(num);
                sb.append(s);
                sb.append(s);
                set.clear();
                for (int i = 0; i < s.length(); i++) {
                    int cc = Integer.parseInt(sb.substring(i, i + s.length()));
                    if (num < cc && cc >= a && cc <= b && !set.contains(cc)) {
                        res++;
                        set.add(cc);
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

