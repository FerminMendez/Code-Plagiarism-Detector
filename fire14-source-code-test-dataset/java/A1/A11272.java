import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* run with JDK7 */
public class DancingWithTheGooglers {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("K:/B-small-attempt0.in"), Charset.defaultCharset());
        PrintWriter output = new PrintWriter("K:/B-small-attempt0.out");
        int testCount = Integer.parseInt(input.get(0));
        for (int i = 1; i <= testCount; ++i) {
            String[] parts = input.get(i).split(" ");
            int n = Integer.parseInt(parts[0]);
            int s = Integer.parseInt(parts[1]);
            int p = Integer.parseInt(parts[2]);
            int[] t = new int[n];
            for (int j = 0; j < n; ++j)
                t[j] = Integer.parseInt(parts[3 + j]);
            // solution
            int alwaysCount = 0, surpriseCount = 0;
            for (int j=0; j<n; ++j) {
                switch (findResult(t[j], p)) {
                    case ALWAYS: ++alwaysCount; break;
                    case SURPRISE: ++surpriseCount; break;
                }
            }
            output.printf("Case #%d: %d\n", i, alwaysCount + Math.min(s, surpriseCount));
        }
        output.close();
    }

    private static Result findResult(int t, int p) {
        int base = t / 3;
        int rem = t - base * 3;
        Result r = null;
        switch (rem) {
            case 0:
                r = tryResult(t, p, base, base, base);
                if (r == null) r = tryResult(t, p, base - 1, base, base + 1);
                break;
            case 1:
                r = tryResult(t, p, base, base, base + 1);
                if (r == null) r = tryResult(t, p, base - 1, base + 1, base + 1);
                break;
            case 2:
                r = tryResult(t, p, base, base + 1, base + 1);
                if (r == null) r = tryResult(t, p, base, base, base + 2);
                break;
            default:
                assert false;
        }
        return r != null ? r : Result.NEVER;
    }

    private static Result tryResult(int t, int p, int a, int b, int c) {
        assert a + b + c == t;
        assert a <= b && b <= c;
        if (a < 0)
            return null;
        if (c >= p) {
            return c - a == 2 ? Result.SURPRISE : Result.ALWAYS;
        }
        return null;
    }

    public enum Result {
        ALWAYS,
        SURPRISE,
        NEVER,
    }
}
