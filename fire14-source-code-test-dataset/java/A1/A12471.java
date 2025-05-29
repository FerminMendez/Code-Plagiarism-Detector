
import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;

/**
 * A program to simulate a Snapper
 *
 *
 * @see Google CodeJam
 *
 * @since 8 may 2010
 * @version 1.0
 * @author ididi, Jeroen van Oorschot
 */
public class Dancers {

    Scanner sc;
    String fileName = "B-small-attempt0";
    File file = new File(fileName + ".in");
    FileWriter out;
    PrintWriter output;
    /* the snapper checker
     * 
     * @pre true
     * @post true
     */

    public void snapper() {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("no input file found");
            System.out.println(fileName + ".in");
        }
        try {
            out = new FileWriter(fileName + ".out");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        output = new PrintWriter(out);
        int tries = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= tries; i++) {
            output.print("Case #" + i + ": ");
            run();
            output.println();
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public void run() {
        int n = sc.nextInt();
        int s = sc.nextInt();
        final int p = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t / 3 >= p) {
                ans++;
            } else if (t / 3 == p - 2 && t % 3 == 2 && s > 0) {
                ans++;
                s--;
            } else if (t / 3 == p - 1) {
                if (t % 3 == 2 || t % 3 == 1) {
                    ans++;
                } else if (s > 0 && t > 0) {
                    ans++;
                    s--;
                }
            }
        }
        output.print(ans);
    }

    public static void main(String[] args) {
        new Dancers().snapper();
    }
}
