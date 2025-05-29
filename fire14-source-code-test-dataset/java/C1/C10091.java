package com.brootdev.gcj2012.common;

import java.io.*;

public class Data {

    public final BufferedReader in;
    public final PrintWriter out;

    public Data(String inFile, String outFile) throws IOException {
        in = new BufferedReader(new FileReader(inFile));
        out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
    }

    public int readIntLine() throws IOException {
        return DataUtils.readIntLine(in);
    }

    public long readLongLine() throws IOException {
        return DataUtils.readLongLine(in);
    }

    public int[] readIntsArrayLine() throws IOException {
        return DataUtils.readIntsArrayLine(in);
    }

    public long[] readLongsArrayLine() throws IOException {
        return DataUtils.readLongsArrayLine(in);
    }

    public void writeCaseHeader(long case_) {
        DataUtils.writeCaseHeader(out, case_);
    }
}
