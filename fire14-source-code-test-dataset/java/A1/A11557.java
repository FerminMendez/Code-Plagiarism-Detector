
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author baskara
 */
public class Dancing {

    /**
     * @param args the command line arguments
     */
    private static File inputFile = new File("/home/baskara/input.txt");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            String[] intInString = reader.readLine().split(" ");
            int N = Integer.parseInt(intInString[0]);
            int S = Integer.parseInt(intInString[1]);
            int p = Integer.parseInt(intInString[2]);
            int[] ti = new int[N];
            for (int j = 0; j < ti.length; j++) {
                ti[j] = Integer.parseInt(intInString[3 + j]);
            }

            System.out.print(calculate(ti, S, p));
            System.out.println();
        }
    }

    private static int calculate(int[] ti, int S, int p) {
        int availS = S;
        int result = 0;
        for (int i = 0; i < ti.length; i++) {
            if (maxScore(ti[i]) >= p) {
                result++;
            } else if ((availS > 0) && (maxSuprisingScore(ti[i]) >= p)) {
                result++;
                availS--;
            }
        }
        return result;
    }

    private static int maxScore(int ti) {
        if (ti > 1) {
            return (ti + 2) / 3;
        } else {
            return ti;
        }

    }

    private static int maxSuprisingScore(int ti) {
        if (ti > 2) {
            return (ti + 4) / 3;
        } else {
            return ti;
        }
    }
}
