package codejam2012.qualification.c;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public final class GoC {

    public static void main(String[] args) throws Exception {
        String name = args[0];
        String nameIn = name + ".in";
        String nameOut = name + ".out";
        String dataIn = Resources.toString(Resources.getResource(nameIn), Charsets.ISO_8859_1);
        try (PrintStream out = new PrintStream(nameOut)) {
            run(new Scanner(dataIn), out);
        }
    }

    public static void run(Scanner in, PrintStream out) {
        new GoC(in, out).run();
    }

    private final Scanner in;
    private final PrintStream out;

    public GoC(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int A = in.nextInt();
            int B = in.nextInt();
            out.println(String.format("Case #%d: %d", t, run(A, B)));
        }
    }

    private static class Pair {
        final int a;
        final int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public static Pair of(int a, int b) {
            return new Pair(a, b);
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }

        public boolean valid(int A, int B) {
            String n = Integer.toString(a);
            String m = Integer.toString(b);

            return (A <= a) && (a < b) && (b <= B) && (n.length() == m.length()) && (n.charAt(0) != '0') && (m.charAt(0) != '0');
        }
    }

    private static int run(int A, int B) {
        System.out.println("A: " + A + " B: " + B);
        HashSet<Pair> done = new HashSet<>();

        for (int i = A; i <= B; ++i) {
            int[] digits = digits(i);
            int first = digits[0];

            for (int j = digits.length - 1; j > 0; --j) {
                int curr = digits[j];
                if (curr >= first) {
                    Pair pair = Pair.of(i, undigits(recycle(digits, j)));
                    if (pair.valid(A, B)) {
                        done.add(pair);
                        System.out.println(pair);
                    }
                }
            }
        }

        System.out.println(done.size());
        System.out.println();

        return done.size();
    }

    private static int[] digits(int a) {
        char[] chars = Integer.toString(a).toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = Character.digit(chars[i], 10);
        }
        return result;
    }

    private static int undigits(int[] digits) {
        int result = 0;
        for (int i : digits) {
            result *= 10;
            result += i;
        }
        return result;
    }

    private static int[] recycle(int[] digits, int from) {
        int[] result = new int[digits.length];
        int index = 0;
        for (int i = from; i < digits.length; ++i) {
            result[index++] = digits[i];
        }
        for (int i = 0; i < from; ++i) {
            result[index++] = digits[i];
        }
        return result;
    }
}
