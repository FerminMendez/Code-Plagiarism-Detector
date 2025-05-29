
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edemairy
 */
public class Main {

    private final static Logger logger = Logger.getLogger(Main.class.getName());
    private static int nbTC;
    private static StringBuilder result = new StringBuilder();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.OFF);
//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nbTC = readInt(reader);
//        scanner.nextLine();
        for (int tc = 1; tc <= nbTC; ++tc) {
            result.append("Case #" + tc + ": ");
            result.append(oneTestCase(reader));
            result.append('\n');
        }
        System.out.print(result);
    }
    private static TreeSet<Integer> found = new TreeSet<Integer>();
    private static TreeSet<Integer> cycle = new TreeSet<Integer>();
    private static int[] p10 = {1, 10, 100, 1000, 10000, 100000, 1000000};

    private static StringBuilder oneTestCase(BufferedReader reader) throws IOException {
        int A = readInt(reader);
        int B = readInt(reader);
        int rnum = 0;
        found.clear();
        fori:
        for (int i = A; i <= B; ++i) {
            cycle.clear();
            int lg = (int) Math.floor(Math.log10(i));
            if (lg == 0) {
                continue fori;
            }
            if (found.contains(i)) {
                continue fori;
            }
            do {
                if (i >= p10[lg]) {
                    if ((i >= A) && (i <= B)) {
                        cycle.add(i);
                    }
                }
                int ld = i % 10;
                i /= 10;
                i += p10[lg] * ld;
            } while (!cycle.contains(i));
            int n = cycle.size();
            if (n != 1) {
                rnum += n * (n - 1) / 2;
                found.addAll(cycle);
            }
        }
        Formatter formatter = new Formatter();
        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < 5; ++i) {
//            formatter.format("%3d", n[i]);
//        }
//        result.append(formatter.out());
        result.append(rnum);
        return result;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        int result = 0;
        boolean positive = true;
        char currentChar = (char) reader.read();

        while ((currentChar == ' ') || (currentChar == '\n')) {
            currentChar = (char) reader.read();
        }
        if (currentChar == (char) -1) {
            throw new IOException("end of stream");
        }
        if (currentChar == '-') {
            positive = false;
            currentChar = (char) reader.read();
        }
        while ((currentChar >= '0') && (currentChar <= '9')) {
            result = result * 10 + currentChar - '0';
            currentChar = (char) reader.read();
        }
        if (positive) {
            return result;
        } else {
            return -result;
        }
    }

    private static char readChar(BufferedReader reader) throws IOException {
        return (char) reader.read();
    }
}
