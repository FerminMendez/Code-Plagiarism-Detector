import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 *
 *
 */
public class B {


    public static void main(String[] args) {
        try {

            Scanner scanner = (new Scanner(new File("c:/input.txt")));
            int N = scanner.nextInt();

            FileOutputStream out = new FileOutputStream("c:/output.txt");
            PrintWriter wr = new PrintWriter(out);

            scanner.nextLine();

            for (int i = 0; i < N; i++) {
                doCase(i+1, scanner, wr);
            }


            wr.close();
            out.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void doCase(int caseNum, Scanner scanner, PrintWriter wr) {
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int p = scanner.nextInt();

        int notSurp = 3 * p - 2;
        int surp = 3 * p - 4;
        if (p == 1) {
            surp = 1;
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int res = scanner.nextInt();
            if (res >= notSurp) {
                cnt++;
            } else if (res >= surp) {
                if (S > 0) {
                    S--;
                    cnt++;
                }
            }
        }
        wr.println("Case #" + caseNum + ": " + cnt);
    }

    private static String formatNumber(int result, String format) {
        DecimalFormat f = new DecimalFormat(format);
        return f.format(result);
    }
}