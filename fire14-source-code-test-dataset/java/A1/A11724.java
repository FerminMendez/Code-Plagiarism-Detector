import java.util.Scanner;

/**
 *
 * @author Nur Endah Safitri
 */
public class D2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        for (int i = 1; i <= x; i++) {
            int res = 0;
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            for (int j = 0; j < a; j++) {
                int d = in.nextInt();
                if (c == 0) {
                    res++;
                } else if (Math.ceil(d / 3.00) >= c) {
                    res++;
                } else if (Math.ceil(d / 3.00) >= c - 1 && d != 0 && b != 0 && d % 3 != 1) {
                    res++;
                    b--;
                }
            }
            System.out.println("Case #" + i + ": " + res);
        }
    }
}
