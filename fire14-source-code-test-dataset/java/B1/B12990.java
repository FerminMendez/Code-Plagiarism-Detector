import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mondodello
 */
public class GCJ_2012Q_RecycledNumbers {
    private static boolean isAValidRotation(String s1, String s2) {
        return (s1.length() == s2.length()) && ((s1 + s1).contains(s2));
    }

    public static void main(String[] args) throws IOException {

        String inputFile = "in.txt";
        String outputFile = "out.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        PrintWriter pw = new PrintWriter(new FileWriter(outputFile));

        int numOfTestCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < numOfTestCases; t++) {
            String[] split = br.readLine().split(" ");

            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);

            int count = 0;
            
            // shamelessly brute-forcing this ;)
            for (int i = A; i <= B; i++) {
                for (int j = A; (i != j) && (j <= B); j++) {
                    if (isAValidRotation(Integer.toString(i), Integer.toString(j))) {
                        count++;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + count);
            pw.println("Case #" + (t + 1) + ": " + count);
        }

        pw.close();
        br.close();
    }
}