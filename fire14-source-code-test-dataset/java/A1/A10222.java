package com.google.code;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

/**
 * @author Wellington Tadeu dos Santos [wellsantos@wellsantos.com]
 */
public class ProblemB {

    boolean endOfLine;
    Reader reader;
    Appendable writer;

    public ProblemB(Reader in, Appendable out) throws Exception {
        this.reader = in;
        this.writer = out;
    }

    public static void main(String[] args) throws Exception {
        long time = System.nanoTime();
        String in = "./src/com/google/code/B-small-attempt5.in";
        String out = in.substring(0, in.length() - 3) + ".out";
        FileReader reader = new FileReader(in);
        FileWriter writer = new FileWriter(out);
        new ProblemB(reader, writer).run();
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
            int n = this.readInt();
            int s = this.readInt();
            int p = this.readInt();
            int scored = 0;
            int surprisingPossibility = 0;
            for (int i = 0, c = n; i < c; i++) {
                int ti = this.readInt();
                int dif = (ti % 3);
                int low = ti / 3;
                switch (dif) {
                    case 0:
                        if (low >= p){
                            scored++;
                        } else if (low + 1 >=p && low > 0){
                            surprisingPossibility++;
                        }
                        break;

                    case 1:
                        if (low + 1>= p){
                            scored++;
                        }
                        break;
                    case 2:
                        if (low + 1>= p){
                            scored++;
                        } else if (low + 2 >=p){
                            surprisingPossibility++;
                        }
                        break;
                }
            }
            if (surprisingPossibility > s) {
                surprisingPossibility = s;
            }
            scored += surprisingPossibility;
            this.writer.append("Case #" + caseIndex + ": " + scored + "\n");
        }
    }

}