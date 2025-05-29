package com.brootdev.gcj2012.problemB;

import com.brootdev.gcj2012.common.Data;

import java.io.IOException;

public class Main {

    private Data data;
    private long casesNumber;
    private long currentCase;

    public static void main(String[] args) throws IOException {
        new Main().go(args[0], args[1]);
    }

    public void go(String inFile, String outFile) throws IOException {
        data = new Data(inFile, outFile);
        casesNumber = data.readLongLine();
        for (currentCase = 0; currentCase < casesNumber; currentCase++) {
            data.writeCaseHeader(currentCase);
            processCase();
        }

        data.out.flush();
    }

    private void processCase() throws IOException {
        long[] longs = data.readLongsArrayLine();
        long N = longs[0];
        long S = longs[1];
        long p = longs[2];
        long p3 = p * 3;

        long sum = 0;
        long s = 0;
        for (int g = 3; g < longs.length; g++) {
            long pts = longs[g];
            if (pts < p) {
                continue;
            }
            if (pts >= p3 - 2) {
                sum++;
            } else if (pts >= p3 - 4) {
                s++;
            }
        }
        sum += Math.min(S, s);

        data.out.println(sum);
    }
}
