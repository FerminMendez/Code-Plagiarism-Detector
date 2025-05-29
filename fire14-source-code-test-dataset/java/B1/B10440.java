/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author lhideg
 */
public class Problem3 {

    private static String fileName = Problem3.class.getSimpleName().replaceFirst("_.*", "");
    private static String inputFileName = fileName + ".in";
    private static String outputFileName = fileName + ".out";
    private static Scanner in;
    private static PrintWriter out;

    private int solve() {
        Map<String, Integer> solutionMap = new HashMap<String, Integer>();
        int result = 0;

        String nStr = in.next();
        String mStr = in.next();

        Integer n = Integer.valueOf(nStr);
        Integer m = Integer.valueOf(mStr);
        Set<Integer> watchedSet = new HashSet<Integer>();
        Set<String> valueSet = new HashSet<String>();
        if (nStr.length() != 1) {
            for (int i = n; i <= m; i++) {
                String str = String.valueOf(i);
                watchedSet.add(i);

                String watchStr = str;

                for (int j = 0; j < str.length() - 1; j++) {
                    watchStr = watchStr.substring(1) + watchStr.charAt(0);
                    if (watchStr.charAt(0) == '0') {
                        continue;
                    }
                    Integer watchInt = Integer.valueOf(watchStr);
                    watchedSet.add(watchInt);
                    if (watchInt > i && watchInt <= m && watchInt > i) {
                        valueSet.add(str+watchStr);
                        valueSet.add(watchStr+str);
                    }
                }
            }
        }
        return valueSet.size()/2;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        if (args.length >= 2) {
            inputFileName = args[0];
            outputFileName = args[1];
        }
        in = new Scanner(new FileReader(inputFileName));
        out = new PrintWriter(outputFileName);
        int tests = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= tests; t++) {
            System.out.println("#" + t);
            out.print("Case #" + t + ": ");
            out.print(new Problem3().solve() + "\n");
        }
        in.close();
        out.close();

    }
}
