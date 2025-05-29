package com.brootdev.gcj2012.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DataUtils {

    public static long readLongLine(BufferedReader in) throws IOException {
        return Long.valueOf(in.readLine());
    }

    public static long[] readLongsArrayLine(BufferedReader in) throws IOException {
        String[] numsS = in.readLine().split("\\s+");
        long[] nums = new long[numsS.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.valueOf(numsS[i]);
        }
        return nums;
    }

    public static void writeCaseHeader(PrintWriter out, long case_) {
        out.print("Case #");
        out.print(case_ + 1);
        out.print(": ");
    }
}
