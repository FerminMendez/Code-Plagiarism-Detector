
import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class ProblemC {

    static boolean check(String a, String b) {
        int x = Integer.parseInt(a);
        for (int i = 1; i < b.length(); i++) {
            String c = b.substring(i) + b.substring(0, i);
            int y = Integer.parseInt(c);
            if (x == y) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ret = 0;
            
            for (int i = a; i <= b; i++) {
                for (int j = i + 1; j <= b; j++) {
                    if (check(i + "", j + "")) {
                        ret++;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + ret);
        }
    }
    
}
