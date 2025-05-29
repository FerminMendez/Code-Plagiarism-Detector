import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    static String shift(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int A = sc.nextInt(), B = sc.nextInt(), count = 0;
            for (int n = A; n <= B; ++n) {
                String s0 = Integer.toString(n);
                Set<Integer> matches = new HashSet<Integer>();
                for (String s = shift(s0); !s.equals(s0); s = shift(s)) {
                    if (!s.startsWith("0")) {
                        int m = Integer.parseInt(s);
                        if (m >= A && m <= B)
                            matches.add(m);
                    }
                }
                count += matches.size();
            }
            System.out.printf("Case #%d: %d\n", t, count/2);
        }
    }
}
