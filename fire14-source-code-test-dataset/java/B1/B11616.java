import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author fedor.korotkov
 */
public class QualificationC {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(new FileInputStream("in.txt"));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.print("Case #" + i + ": ");
            System.out.println(solve(a, b));
        }
    }

    private static int solve(int a, int b) {
        int result = 0;
        for (int i = a; i < b; ++i) {
            for (int j = i + 1; j <= b; ++j) {
                if (recycled(i, j)) ++result;
            }
        }
        return result;
    }

    private static boolean recycled(int i, int j) {
        String tmp = Integer.toString(i) + Integer.toString(i);
        return tmp.indexOf(Integer.toString(j)) != -1;
    }
}
