package bchang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: bchang
 * Date: 4/14/12
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProblemC {
    private static void cycle(char[] charArray) {
        char first = charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            charArray[i - 1] = charArray[i];
        }
        charArray[charArray.length - 1] = first;
    }

    private static Set<String> toSet(int a, int b) {
        Set<String> set = new HashSet<String>();
        for (int x = a; x <= b; x++) {
            set.add(Integer.toString(x));
        }
        return set;
    }

    private static int combos(int n) {
        if (n == 1) {
            return 1;
        }
        return n + combos(n-1);
    }

    private static int process(BufferedReader reader) throws IOException {
        String[] pair = reader.readLine().split(" ");
        int a = Integer.parseInt(pair[0]);
        int b = Integer.parseInt(pair[1]);
        Set<String> set = toSet(a, b);
        int counter = 0;
        while (set.size() > 0) {
            Iterator<String> iterator = set.iterator();
            String n = iterator.next();
            iterator.remove();
            char[] working = n.toCharArray();
            Set<Integer> matchingPairs = new HashSet<Integer>();
            for (int idx = 1; idx < working.length; idx++) {
                cycle(working);
                String mStr = new String(working);
                int mInt = Integer.parseInt(mStr);

                if (a <= mInt && mInt <= b && !n.equals(mStr) && mStr.charAt(0) != '0') {
                    set.remove(mStr);
                    matchingPairs.add(mInt);
                }
            }
            if (matchingPairs.size() > 0) {
                int numPairs = combos(matchingPairs.size());
                counter += numPairs;
            }
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(reader.readLine());
            for (int i = 0; i < t; i++) {
                int result = process(reader);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                }
            }
        }

    }
}
