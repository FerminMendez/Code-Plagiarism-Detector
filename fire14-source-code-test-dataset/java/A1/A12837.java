
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;
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
    private static int N;
    private static int S;
    private static int P;
    private static int T[] = new int[101];

    private static StringBuilder oneTestCase(BufferedReader reader) throws IOException {
        N = readInt(reader);
        S = readInt(reader);
        P = readInt(reader);
        for (int i = 0; i < N; ++i) {
            T[i] = readInt(reader);
        }
        Formatter formatter = new Formatter();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 102; ++i) {
            Arrays.fill(v[i], -2);
        }
        result.append(val(S, 0));
//        for (int i = 0; i < 5; ++i) {
//            formatter.format("%3d", n[i]);
//        }
//        result.append(formatter.out());
        return result;
    }
    public static int[][] v = new int[102][102];

    public static int val(int s, int pos) {
        if (v[s][pos] != -2) {
            return v[s][pos];
        }

        int result;
        if (pos >= N) {
            if (s == 0) {
                result = 0;
            } else {
                result = -1;
            }
        } else {
            int surprising = -1;
            if (s > 0) {
                surprising = valSurprising(T[pos], P);
                int rem = val(s - 1, pos + 1);
                if ((surprising == -1) || (rem == -1)) {
                    surprising = -1;
                } else {
                    surprising += rem;
                }
            }
            int remNotSurprising = val(s, pos + 1);
            int notSurprising = valNotSurprising(T[pos], P);
            if ((notSurprising == -1) || (remNotSurprising == -1)) {
                notSurprising = -1;
            } else {
                notSurprising += remNotSurprising;
            }
            if ((surprising == -1) && (notSurprising == -1)) {
                result = -1;
            } else if (surprising == -1) {
                result = notSurprising;
            } else if (notSurprising == -1) {
                result = surprising;
            } else {
                result = Math.max(surprising, notSurprising);
            }
        }
        v[s][pos] = result;
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

    public static int valNotSurprising(int t, int p) {
        if ((t < 0) || (t > 30)) {
            return -1;
        }
        int m = t / 3;
        // searching a and b such as t = a*m+ b*(m+1)

        int b = t - (3*m);
        int a = 3 - b;
        int result = 0;
        if (m >= p) {
            result = 1;
        }
        if ((b!=0) && (m + 1 >= p)) {
            result = 1;
        }
        return result;
    }

    public static int valSurprising(int t, int p) {
        if ((t < 2) || (t > 28)) {
            return -1;
        }
        int result = 0;
        foralpha:
        for (int alpha = 0; alpha < 3; ++alpha) {

            int remn = (t - 2 - alpha) % 3;
            if (remn != 0) {
                continue foralpha;
            }
            int n = (t - 2 - alpha) / 3;
            int resultLoop = 0;
            if (n >= p) {
                resultLoop = 1;
            }
            if ((n + 2) >= p) {
                resultLoop = 1;
            }
            if ((n + alpha) >= p) {
                resultLoop = 1;
            }
            result = Math.max(result, resultLoop);
        }
        return result;
    }
}
