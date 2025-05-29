package codejam;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecycledNumbers {


    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static int recycleNum(int a, int b) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = String.valueOf(a).length();
        int c = 0;
        for (int i = a; i <= b; i++) {
            for (int j = 1; j < n ; j++) {
                int rNum = rotateRight(i, j);
                if (i < rNum && rNum <= b) {
                    if (!map.containsKey(rNum) || map.get(rNum) != i) {
                        map.put(rNum, i);
                        c++;
                    }
                }
            }
        }
        return c;
    }

    private static int rotateRight(int i, int j) {
        int length = String.valueOf(i).length();
        int sP = (int) Math.pow(10, j);
        int bP = (int) Math.pow(10, length - j);
        int rem = i % sP;
        return ((i - rem) / sP) + (rem * bP);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("D:\\codejam\\C-small-attempt0.in"));
        Writer writer = new OutputStreamWriter(new FileOutputStream("D:\\codejam\\C-small-attempt.out"));
        Integer n = Integer.valueOf(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            writer.write("Case #" + i + ": " + recycleNum(a, b));
            writer.write(LINE_SEPARATOR);
        }
        scanner.close();
        writer.close();
    }

}
