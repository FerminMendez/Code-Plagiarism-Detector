
package B;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new File("/output.txt"));
        Scanner in = new Scanner(new File("/B-small-attempt0.in"));
        int testCase = Integer.parseInt(in.next());
        for (int n = 0; n < testCase; n++) {
            int count = 0;
            int googlers = Integer.parseInt(in.next());
            int surprising = Integer.parseInt(in.next());
            int wantScores = Integer.parseInt(in.next());
            for (int g = 0; g < googlers; g++) {
                int scores = Integer.parseInt(in.next());
                if (scores - (wantScores * 3) >= -2) {
                    count++;
                } else if ((surprising > 0) && (((scores - (wantScores * 3) == -4)&&scores>=2) || ((scores - (wantScores * 3) == -3)&&scores>=3))) {
                    surprising--;
                    count++;
                }
            }
            out.println("Case #" + (n + 1) + ": " + count);
            System.out.println("Case #" + (n + 1) + ": " + count);
        }
        in.close();
        out.close();
    }
}
