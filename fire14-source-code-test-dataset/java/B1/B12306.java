package com.mademoisellegeek.googlecodejam.y2012.qualround;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class RecycledNumbers implements Runnable {

    BufferedReader in;
    BufferedWriter out;
    static String inputFile = "2012-qualround-C-small.in";
    static String outputFile = "2012-qualround-C-small.out";

    public void run() {

        try {
            in = new BufferedReader(new FileReader(inputFile));
            out = new BufferedWriter(new FileWriter(outputFile));
            try {
                String line = in.readLine();
                int nbCases = Integer.parseInt(line);
                for (int i=1; i<=nbCases; i++) {
                    line = in.readLine();
                    String [] lineArray = line.split(" ");
                    int min = Integer.parseInt(lineArray[0]);
                    int max = Integer.parseInt(lineArray[1]);
                    out.write("Case #" + i + ": " + solve(min, max) + "\n");
                }
            } finally {
                in.close();
            }
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int solve(int min, int max) {
        HashMap recycled = new HashMap();
        for (int i=min; i<=max; i++) {
            for (int j=1; j< nbDigits(i); j++) {
                int result = move(i, j);
                if (result != i && result <= max && result >= min) {
                    int small = Math.min(result, i);
                    int big = Math.max(result, i);
                    if (!recycled.containsKey(small)) {
                        ArrayList empty = new ArrayList();
                        empty.add(big);
                        recycled.put(small,empty);
                    }
                    else {
                        ArrayList list = (ArrayList) recycled.get(small);
                        if (!list.contains(big))
                            list.add(big);
                        recycled.put(small,list);
                    }
                }
            }
        }
        int result = 0;
        for (Object list : recycled.values()) {
            result += ((ArrayList)list).size();
        }
        return result;
    }

    private int move(int i, int j) {
        String whole = String.valueOf(i);
        String suffix = whole.substring(whole.length()-j);
        String prefix = whole.substring(0, whole.length()-j);
        return Integer.parseInt(suffix+prefix);
    }

    private int nbDigits(int j) {
        return String.valueOf(j).length();

    }
}
