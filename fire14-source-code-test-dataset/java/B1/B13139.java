package cj2012.qual;

import java.io.*;
import java.util.Arrays;

public class ProblemC extends PrintWriter {

    private final static String PREFIX = "ProblemC_";
    private final static String INPUT_FILE = PREFIX + "in.txt";
    private final static String OUTPUT_FILE = PREFIX + "out.txt";

    private static final int BUFF_SIZE = 64 * 1024;
    int pos = 0;
    int len = -1;
    final DataInputStream dis;
    final byte[] b = new byte[BUFF_SIZE];

    public static void main(String[] args) throws Exception {
        ProblemC problem = new ProblemC(new BufferedOutputStream(System.out));
        problem.solve();
        problem.flush();
        problem.close();
    }

    public ProblemC(OutputStream os) throws FileNotFoundException {
//        super(new BufferedOutputStream(System.out));
        super(new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE)));
        dis = new DataInputStream(new BufferedInputStream(new FileInputStream(INPUT_FILE)));
    }

    public int read() {
        if (pos >= len) {
            pos = 0;
            len = -1;
            try {
                len = dis.read(b);
            } catch (IOException ex) {
            }
        }
        return pos < len ? b[pos++] : -1;
    }

    public int nextInt() throws IOException {
        int ret = 0;
        int ch = skipWhite();
        int sign = 1;
        if (ch == '-') {
            sign = -1;
            ch = read();
        }
        while (!isSpaceChar(ch) && ch != -1) {
            ret *= 10;
            ret += ch - '0';
            ch = read();
        }
        return ret * sign;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        int ch = skipWhite();
        int sign = 1;
        if (ch == '-') {
            sign = -1;
            ch = read();
        }
        while (!isSpaceChar(ch) && ch != -1) {
            ret *= 10;
            ret += ch - '0';
            ch = read();
        }
        return ret * sign;
    }

    public int skipWhite() throws IOException {
        int ch = read();
        while (true) {
            if (ch == -1) {
                return -1;
            }
            if (!isSpaceChar(ch)) {
                return ch;
            }
            ch = read();
        }
    }

    public boolean isSpaceChar(int c) {
        return c <= 32 && c >= 0;
    }

    public int next(char[] buff) throws IOException {
        int c = skipWhite();
        int len = 0;
        while (!isSpaceChar(c) && c != -1) {
            buff[len++] = (char) c;
            c = read();
        }
        return len;
    }

    public String next() throws IOException {
        int c = skipWhite();
        StringBuilder res = new StringBuilder();
        while (!isSpaceChar(c) && c != -1) {
            res.appendCodePoint(c);
            c = read();
        }
        return res.toString();
    }

    public String nextLine() throws IOException {
        int c = skipWhite();
        StringBuilder res = new StringBuilder();
        while (c != '\n' && c != '\r' && c != -1) {
            res.appendCodePoint(c);
            c = read();
        }
        return res.toString();
    }

    void debug(Object... obj) {
        println("-->" + Arrays.deepToString(obj));
    }

    void solve() throws Exception {
        int[] pow = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        int cases = nextInt();
        for (int kk = 1; kk <= cases; kk++) {
            int a = nextInt();
            int b = nextInt();

            int sol = 0;
            for (int i = a; i <= b; i++) {
                int dig = getDigits(i);

                int start = i;
                int[] found = new int[dig];
                int len = 0;
                for (int j = 0; j < dig; j++) {
                    int mod = start % 10;
                    int next = start / 10 + mod * pow[dig - 1];
                    if (i < next && next <= b && mod != 0 && start != next) {
                        boolean valid = true;
                        for (int k = 0; k < len; k++) {
                            if (found[k] == next) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            sol++;
                            found[len++] = next;
                        }
                    }
                    start = next;
                }
            }
            println(String.format("Case #%d: %d", kk, sol));
        }
    }

    private int getDigits(int a) {
        if (a < 10) return 1;
        if (a < 100) return 2;
        if (a < 1000) return 3;
        if (a < 10000) return 4;
        if (a < 100000) return 5;
        return 6;
    }
}