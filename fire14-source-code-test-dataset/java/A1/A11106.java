package code.jam.y2012.quali;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemB {

    private static String PATH = "F:\\dev\\projects\\code-jam-2012\\src\\code\\jam\\y2012\\quali";
    File inputFile = new File(PATH, "B-small-attempt0.in");
    File outputFile = new File(PATH, "B-small-attempt0.out");
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws Exception {
        new ProblemB().solve();
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
        final int googlers = nextInt();
        final int surprises = nextInt();
        final int atLeastRate = nextInt();
        int googlersPass = 0;
        int surprisesUsed = 0;
        for (int i = 0; i < googlers; i++) {
            final double minSafeAverage = (atLeastRate * 3 - 2) / 3d;
            final double minSurpriseAverage = (atLeastRate * 3 - 4) / 3d;
            final int googlerTotal = nextInt();
            if (atLeastRate==0 && googlerTotal==0) {
                googlersPass++;
                continue;
            }
            if (googlerTotal==0) {
                continue;
            }
            final double googlerAverage = googlerTotal / 3d;
            if (googlerAverage>=minSafeAverage) {
                //System.out.println("pass: " + googlerTotal + " " + googlerAverage);
                googlersPass++;
                continue;
            }
            if (googlerAverage>=minSurpriseAverage && surprises>surprisesUsed) {
                //System.out.println("PASS: " + googlerTotal + " " + googlerAverage);
                googlersPass++;
                surprisesUsed++;
                continue;
            }
        }
        print("Case #" + testCase + ": " + googlersPass);
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
