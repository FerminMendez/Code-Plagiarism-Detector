package com.javanme.gcj.one.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecycledNumbers {

    public static void main(String args[]) {
        String input = "C-small-attempt0";

        Path pathin = FileSystems.getDefault().getPath(input + ".in");
        Path pathout = FileSystems.getDefault().getPath(input + ".out");


        try (PrintWriter pout = new PrintWriter(Files.newOutputStream(pathout, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE))) {
            List<String> lines = Files.readAllLines(pathin, Charset.forName("UTF-8"));

            int countLines = lines.size();
            String str = null;
            int small = 0;
            int smallAux = 0;
            int big = 0;
            String[] split = null;
            String num = null;
            String numAux = null;
            StringBuffer backDigits = null;
            int countRecycled = 0;
            Map<Integer, Integer> mapDistinct = null;
            for (int i = 1; i < countLines; i++) {
                countRecycled = 0;
                str = lines.get(i);
                split = str.split(" ");
                small = Integer.parseInt(split[0]);
                big = Integer.parseInt(split[1]);
                for (int j = small; j < big; j++) {
                    num = "" + j;
                    backDigits = new StringBuffer();
                    mapDistinct = new HashMap<>();
                    for (int k = num.length() - 1; k > 0; k--) {
                        backDigits.insert(0, num.charAt(k));
                        numAux = backDigits.toString() + num.substring(0, num.length() - backDigits.length());
                        smallAux = Integer.parseInt(numAux);

                        if (j < smallAux && smallAux <= big) {
                            for (int m = j + 1; m <= big; m++) {
                                if (smallAux == m) {
                                    if (!mapDistinct.containsKey(m)) {
                                        mapDistinct.put(m,1);
                                        countRecycled++;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                pout.printf("Case #%d: %d\n", i, countRecycled);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
