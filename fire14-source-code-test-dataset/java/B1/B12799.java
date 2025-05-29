package quialification;

import base.Base;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: babulya
 * Date: 14.04.12
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
public class C extends Base {
    private static class Number {
        private int[] digits;

        private Number(int[] digits) {
            this.digits = digits;
        }

        public Number(int N) {
            int dc = (int) Math.ceil(Math.log10(N + 1));
            digits = new int[dc];
            for (int i = 0; i < dc; i++) {
                digits[i] = N % 10;
                N = N / 10;
            }
        }

        private static int compareTo(int o1, int o2) {
            return o1 - o2;
        }

        public int compareTo(Number other) {
            int res = compareTo(digits.length, other.digits.length);
            if (res != 0) return res;
            int ind = digits.length - 1;
            while (ind >= 0 && digits[ind] == other.digits[ind]) {
                ind--;
            }
            if (ind >= 0) return compareTo(digits[ind], other.digits[ind]);
            return 0;
        }

        public Set<Number> pairs() {
            Set<Number> res = new HashSet<Number>();
            for (int i = 0; i < digits.length - 1; i++) {
                int[] newdigits = new int[digits.length];
                for (int j = 0; j <= i; j++) {
                    newdigits[j + digits.length - i - 1] = digits[j];
                }
                for (int j = i + 1; j < digits.length; j++) {
                    newdigits[j - i - 1] = digits[j];
                }
                res.add(new Number(newdigits));
            }
            return res;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Number number = (Number) o;

            if (!Arrays.equals(digits, number.digits)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return digits != null ? Arrays.hashCode(digits) : 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }
            return sb.toString();
        }
    }

    private static int solve(int a, int b) {
        int result = 0;
        Number A = new Number(a);
        Number B = new Number(b);
        for (int n = a; n <= b; n++) {
            Number N = new Number(n);
            for (Number M : N.pairs()) {
                if (A.compareTo(N) <= 0 && N.compareTo(M) < 0 && M.compareTo(B) <= 0) {
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    protected void solve(Scanner in, PrintStream out) {
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            out.println(String.format("Case #%d: %d", i, solve(A, B)));
        }
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        new C();
        System.out.println((System.currentTimeMillis() - now)/1000);
    }
}
