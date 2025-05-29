package com.google.code;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

/**
 * @author Wellington Tadeu dos Santos [wellsantos@wellsantos.com]
 */
public class ProblemC {

    boolean endOfLine;
    Reader reader;
    Appendable writer;

    public ProblemC(Reader in, Appendable out) throws Exception {
        this.reader = in;
        this.writer = out;
    }

    public static void main(String[] args) throws Exception {
        long time = System.nanoTime();
        String in = "./src/com/google/code/C-small-attempt0.in";
        String out = in.substring(0, in.length() - 3) + ".out";
        FileReader reader = new FileReader(in);
        FileWriter writer = new FileWriter(out);
        new ProblemC(reader, writer).run();
        writer.flush();
        writer.close();
        reader.close();
        System.out.println((System.nanoTime() - time) / 1000000.0);
    }

    private int readInt() throws Exception {
        int val = 0;
        int chr;
        while ((chr = this.reader.read()) >= '0' && chr <= '9') {
            val = val * 10 + (chr - '0');
        }
        switch (chr) {
            case '\r':
                chr = this.reader.read();
            case '\n':
            case -1:
                this.endOfLine = true;
                break;
            default:
                this.endOfLine = false;
        }
        return val;
    }

    private void run() throws Exception {
        int testCases = this.readInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int a = this.readInt();
            int b = this.readInt();
            int count = 0;
            for (int n = a; n <= b; n++) {
                for (int m = n + 1; m <= b; m++) {
                    String nx = String.valueOf(n);
                    String mx = String.valueOf(m);
                    int f = nx.length();
                    if (f == mx.length()) {
                        for (int i = 0; i < f; i++) {
                            if (mx.charAt(i) == nx.charAt(f - 1)) {
                                if (mx.substring(0, i + 1).equals(nx.substring(f - i - 1, f))
                                        && mx.substring(i + 1, f).equals(nx.substring(0, f - i - 1))) {
                                    count++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.writer.append("Case #" + caseIndex + ": " + count + "\n");
        }
    }
}