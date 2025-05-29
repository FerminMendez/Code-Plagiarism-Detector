import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 4/14/12
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static int bruteForce(int start, int end) {
        Set<String> set = new HashSet<String>();
        for (int k = start; k <= end; k++) {
            String repr = Integer.toString(k);
            for (int i = 1; i < repr.length(); i++) {
                String a = repr.substring(0, i);
                String b = repr.substring(i, repr.length());
                int comb = Integer.valueOf(b + a);
                if (comb > k & comb >= start && comb <= end) {
                    String c = "" + k + ":" + comb;
                    set.add(c);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("C-small-attempt0.in"));
        PrintWriter pw = new PrintWriter(new File("google.out"));

        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int comb = bruteForce(start, end);
            pw.print(String.format("Case #%d: %d%n", i + 1, comb));
        }


        scanner.close();
        pw.close();


    }

}
