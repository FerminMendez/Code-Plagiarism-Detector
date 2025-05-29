import java.io.*;
import java.util.*;

public class Recycled {
    public static class Pair {
        private int a;
        private int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != pair.a) return false;
            if (b != pair.b) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }

        public String toString() {
            return String.format("[%d, %d]", a, b);
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
            PrintWriter out = new PrintWriter(new FileWriter("C-small-attempt0.out"));

            int cases = Integer.valueOf(in.readLine().trim());
            for (int i =0; i < cases; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine().trim());
                int a = Integer.valueOf(st.nextToken().trim());
                int b = Integer.valueOf(st.nextToken().trim());
                int pairs = solve(a, b);
                out.println(String.format("Case #%d: %d", i+1, pairs));
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int solve(int a, int b) {
        Set<Pair> pairs = new HashSet<Pair>();
        for (int i = a; i < b; i++) {
            String s = String.valueOf(i);
            for (int j = 1; j < s.length(); j++) {
                int recycled = Integer.valueOf(s.substring(j)+s.substring(0,j));
                if (recycled > i && recycled <= b) {
                    pairs.add(new Pair(i, recycled));
                }
            }
        }
        return pairs.size();
    }
}
