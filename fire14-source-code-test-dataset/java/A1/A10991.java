package codejam2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Jimmy
 * Date: 4/14/12
 * Time: 10:17 PM
 */
public class DancingWithTheGooglers implements Runnable {

    Scanner scanner;
    PrintWriter pw;

    public static void main(String arguments[]) {
        new Thread(new DancingWithTheGooglers()).start();
    }

    public static boolean isSurprising(int points) {
        return points > 1 && points < 29;
    }

    public static int ms(int points) {
        return (points + 4) / 3;
    }

    public static int mn(int points) {
        return (points + 2) / 3;
    }

    public void solution() {
        int t = scanner.nextInt();

        int i, n, s, p, j;
        int points;
        int d;
        int r = 0;
        int result;
        for(i = 1; i <= t; i++) {
            n = scanner.nextInt();
            s = scanner.nextInt();
            p = scanner.nextInt();

            System.out.println(n + " " + s + " " + p);

            int sum1 = 0;
            int sum2 = 0;

            for(j = 0; j < n; j++) {
                r = 0;
                points = scanner.nextInt();
                if(isSurprising(points)) {
                    int ms = ms(points);
                    int mn = mn(points);

                    if (ms >= p && mn < p)
                        sum1++;

                    else if (mn >= p)
                        sum2++;
                } else {
                    if (mn(points) >= p)
                        sum2++;
                }
            }
            System.out.println("******************************************************");
            pw.println("Case #" + i + ": " + (Math.min(s, sum1) + sum2));
        }
    }

    public void run() {
        scanner = new Scanner(System.in);
        try {
            pw = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        solution();

        pw.close();
        scanner.close();
    }
}
