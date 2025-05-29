import java.util.*;
public class ProblemC {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int digit = String.valueOf(A).length();
            Set<String> set = new HashSet<>();
            for ( int i=digit-1; i>0; i-- )  {
                for (int n=A; n<=B; n++) {
                    String ns = String.valueOf(n);
                    String ms = (ns.substring(digit-i) + ns.substring(0,digit-i));
                    int m = Integer.parseInt(ms);
                    if( m>B ) continue;
                    if( n<m ) set.add(ns+","+ms);
                }
            }
            System.out.println("Case #" +t+ ": " + set.size());
        }
    }
}
