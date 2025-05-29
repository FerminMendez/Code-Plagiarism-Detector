package code.jam.y2012.quali;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ProblemC {

    private static String PATH = "F:\\dev\\projects\\code-jam-2012\\src\\code\\jam\\y2012\\quali";
    File inputFile = new File(PATH, "C-small-attempt0.in");
    File outputFile = new File(PATH, "C-small-attempt0.out");
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws Exception {
        new ProblemC().solve();
    }

    void solve() throws Exception {
        in = new BufferedReader(new FileReader(inputFile));
        out = new PrintWriter(outputFile);

        for (int testCase = 1, testCount = nextInt(); testCase <= testCount; testCase++) {
            solve(testCase);
        }

        out.close();
    }
    
    void solve(int testCase) throws IOException {
        final int min = nextInt();
        final int max = nextInt();
        Set validPatterns = new HashSet();
        for (int i = min; i <= max; i++) {
            String[] patterns = getRecycledPatterns(String.valueOf(i));
            for (int j = 0; j < patterns.length - 1; j++) {
                for (int k = j; k < patterns.length; k++) {
                    if (isValid(Integer.parseInt(patterns[j]), Integer.parseInt(patterns[k]), min, max)) {
                        validPatterns.add(patterns[j] + "-" + patterns[k]);
                    }
                }
            }
        }
        print("Case #" + testCase + ": " + validPatterns.size());
    }
    
    private static String[] getRecycledPatterns(String pattern) {
        String[] result = new String[pattern.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = pattern.substring(i) + pattern.substring(0, i);
        }
        return result;
    }
    
    
    
    private boolean isValid(int a, int b, int min, int max) {
        return min <= a && a < b && b <= max && String.valueOf(a).length()==String.valueOf(b).length();
    }
    
    private void print(String text) {
        out.println(text);
        System.out.println(text);
    }

    
    /**
     * helpers
     */
    String nextToken() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    
    int nextChar() throws IOException {
        return in.read();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextLine() throws IOException {
        st = new StringTokenizer("");
        return in.readLine();
    }

    boolean EOF() throws IOException {
        while (!st.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return true;
            }
            st = new StringTokenizer(s);
        }
        return false;
    }
    
}
