import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class ProblemB {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            int ret = 0;
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = a / 3;
                int c = a % 3;
                if (b >= p) {
                    ret++;
                } else if (b + 1 >= p && c >= 1) {
                    ret++;
                } else if (b + 2 >= p && c >= 2 && s > 0) {
                    ret++;
                    s--;
                } else if (b + 1 >= p && s > 0 && b > 1) {
                    ret++;
                    s--;
                }
            }
            System.out.println("Case #" + t + ": " + ret);
        }
    }
    
}
