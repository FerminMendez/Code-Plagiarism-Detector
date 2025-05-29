import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

class IntegerPair implements Comparable<IntegerPair> {
    int a, b;

    IntegerPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(IntegerPair p) {
        if (a == p.a) return b - p.b;
        return a - p.a;
    }
}

public class Main implements Runnable {
    final String fileName = "C-small-attempt0";

    void solveCase(int test) throws Exception {
        out.print("Case #" + test + ": ");
        int a = nextInt();
        int b = nextInt();
        TreeSet<IntegerPair> answer = new TreeSet<IntegerPair>();
        for (int v = a; v <= b; v++) {
            String s = Integer.toString(v);
            for (int i = 1; i < s.length(); i++) {
                String t = s.substring(i) + s.substring(0, i);
                if (t.charAt(0) == '0') continue;
                int v2 = Integer.parseInt(t);
                if (v2 <= v || v2 > b) continue;
                answer.add(new IntegerPair(v, v2));
            }
        }
        out.println(answer.size());
        out.flush();
        System.out.println(answer.size());
        System.out.flush();
    }

    void solution() throws Exception {
        int t = nextInt();
        for (int i = 0; i < t; i++)
            solveCase(i + 1);
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String l = in.readLine();
            if (l == null) return null;
            st = new StringTokenizer(l);
        }
        return st.nextToken();
    }

    public static void main(String args[]) {
        //Locale.setDefault(Locale.UK);
        new Thread(new Main()).start();
    }

    public void run() {
        try {
            in = new BufferedReader(new FileReader(fileName + ".in"));
            //out = new PrintWriter(System.out);
            out = new PrintWriter(fileName + ".out");
            solution();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(202);
        }
    }

    BufferedReader in;
    StringTokenizer st;
    PrintWriter out;
}