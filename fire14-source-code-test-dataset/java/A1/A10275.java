package codejam2012.qualification;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class ProblemB {

    public static void main(String[] args) throws IOException {
        String problem = "ProblemB";
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream(String.format("%s.in", problem)));
        PrintStream out = new PrintStream(String.format("C:\\workplace\\GoogleCodeJam\\src\\codejam2012\\qualification\\%s.out", problem));
//        out = System.out;
        
//        4
//        3 1 5 15 13 11
//        3 0 8 23 22 21
//        2 1 1 8 0
//        6 2 8 29 20 8 18 18 21
        int numInputs = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numInputs; i++) {
            int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();
            int c = 0;
            for (int j = 0; j < N; j++) {
                int n = in.nextInt();
                int t;
                if (n % 3 == 0) {
                    t = n / 3;
                } else {
                    t = n / 3 + 1;
                }
                if (t >= p) {
                    c++;
                    continue;
                }
                if (t + 1 == p && n % 3 != 1 && t != 0 && S > 0) {
                    c++;
                    S--;
                }
            }
            out.println("Case #" + (i+1) + ": " + c);
//            out.println(map);
        }
    }
}
