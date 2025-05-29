package com.brootdev.gcj2012.problemC;

import com.brootdev.gcj2012.common.Data;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
        long A = longs[0];
        long B = longs[1];

        int digits = ((int) Math.log10(A)) + 1;
        long mn = (long) Math.pow(10, digits - 1);
        long sum = 0;
        Set<Long> m2 = new HashSet<Long>();
        for (long n = A; n < B; n++) {
            long m = n;
            m2.clear();
            for (int i = 1; i < digits; i++) {
                int r = (int) (m % 10);
                m = r * mn + m / 10;
                if (m <= B && n < m && ! m2.contains(m)) {
                    sum++;
                    m2.add(m);
                }
            }
        }

        data.out.println(sum);
    }
}
