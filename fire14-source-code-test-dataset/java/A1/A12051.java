package codejam;

import java.io.*;
import java.util.Scanner;

public class DancingWithGooglers {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static int getNum(int n, int s, int p, int[] points) {
        return getNum(0, n, s, p, points);
    }

    public static int getNum(int i, int n, int s, int p, int[] points) {
        if (i == n) return 0;
        
        int point = points[i];

        int x = point / 3;
        
        int res1 = 0, res2 = 0;
        
        if (point % 3 == 0) {
            //x x x
            if (x >= p) {
                res1++;
            }
            res1 += getNum(i+1, n, s, p, points);

            // x-1 x x+1 (s)
            if (x > 0 && s > 0) {
                if (x+1 >= p) {
                    res2++;
                }
                res2 += getNum(i+1, n, s - 1, p, points);
            }
        } else if (point % 3 == 1) {
            //x x x+1
            if (x+1 >= p) {
                res1++;
            }
            res1 += getNum(i+1, n, s, p, points);

            //x-1 x+1 x+1
            if (x > 0 && s > 0) {
                if (x+1 >= p) {
                    res2++;
                }
                res2 += getNum(i+1, n, s-1, p, points);
            }
        } else if (point % 3 == 2) {
            //x x+1 x+1
            if (x+1 >= p) {
                res1++;
            }
            res1 += getNum(i+1, n, s, p, points);
            //x x x+2
            if (s > 0) {
                if (x+2 >= p) {
                    res2++;
                }
                res2 += getNum(i+1, n, s-1, p, points);
            }
        }

        return Math.max(res1, res2);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("D:\\codejam\\B-small-attempt1.in"));
        Writer writer = new OutputStreamWriter(new FileOutputStream("D:\\codejam\\B-small1.out"));
        Integer t = Integer.valueOf(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            System.out.println();
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int p = scanner.nextInt();
            int[] points = new int[n];
            for (int j = 0; j < n; j++)
                points[j] = scanner.nextInt();
            writer.write("Case #" + i + ": " + getNum(n, s, p, points));
            writer.write(LINE_SEPARATOR);
        }
        scanner.close();
        writer.close();
    }
}
